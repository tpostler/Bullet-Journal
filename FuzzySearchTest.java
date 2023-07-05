package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for FuzzySeach
 */
class FuzzySearchTest {

  private FuzzySearch fuzzySearch;
  private ArrayList<TaskJson> tasks;

  /**
   * Sets up requirments for fuzzy seach to work
   */
  @BeforeEach
  void setUp() {
    // Initialize tasks for testing
    tasks = new ArrayList<>();
    tasks.add(new TaskJson("Task 1", "", Weekday.SATURDAY));
    tasks.add(new TaskJson("Task 2", "howdy", Weekday.TUESDAY));
    tasks.add(new TaskJson("Task 3", "mr mustard", Weekday.THURSDAY));

    fuzzySearch = new FuzzySearch(tasks);
  }

  /**
   * Test is making sure tasks are getting added to the searchMap
   */
  @Test
  void similarStrings_ReturnsMatchingTasks() {
    fuzzySearch.similarStrings("Task");
    Map<TaskJson, Integer> searchMap = fuzzySearch.getSearchMap();

    // Ensure all tasks with "Task" in their name are added to the searchMap
    assertEquals(3, searchMap.size());
    assertTrue(searchMap.keySet().containsAll(tasks));
  }

  /**
   * Tests the partial ratio that is getting added
   */
  @Test
  void similarStrings_FiltersByPartialRatio() {
    fuzzySearch.similarStrings("Task");
    Map<TaskJson, Integer> searchMap = fuzzySearch.getSearchMap();

    // Ensure only tasks with a partial ratio of at least 50 are added to the searchMap
    assertFalse(searchMap.containsValue(49));  // Partial ratio below 50
    assertFalse(searchMap.containsValue(50));   // Partial ratio exactly 50
    assertTrue(searchMap.containsValue(100));  // Partial ratio above 50
  }

  /**
   * testing to make sure the sorted map values match
   */
  @Test
  void sortMapValues_ReturnsSortedStream() {
    fuzzySearch.similarStrings("Task");
    Map<TaskJson, Integer> searchMap = fuzzySearch.getSearchMap();

    // Sort the searchMap by value in descending order
    Map<TaskJson, Integer> sortedMap = searchMap.entrySet().stream()
        .sorted(Map.Entry.<TaskJson, Integer>comparingByValue(Integer::compareTo).reversed())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
            (oldValue, newValue) -> oldValue, HashMap::new));

    // Ensure the sortedMap returned by sortMapValues matches the sortedMap obtained manually
    assertEquals(sortedMap,
        fuzzySearch.sortMapValues().collect(Collectors.toMap(Map.Entry::getKey,
            Map.Entry::getValue)));
  }
}
