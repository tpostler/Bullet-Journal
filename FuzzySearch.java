package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * represents the fuzzy search algorithim
 */
public class FuzzySearch {

  private ArrayList<TaskJson> tasks;

  private Map<TaskJson, Integer> searchMap = new HashMap<>();

  /**
   * represents the constructor
   *
   * @param tasks tasks
   */
  public FuzzySearch(ArrayList<TaskJson> tasks) {
    this.tasks = tasks;
  }

  /**
   * finds similar strings
   *
   * @param searchingString to compare to
   */
  public void similarStrings(String searchingString) {
    for (TaskJson task : tasks) {
      int ratio = me.xdrop.fuzzywuzzy.FuzzySearch.partialRatio(task.getName(), searchingString);
      if (ratio >= 50) {
        searchMap.put(task, ratio);
      }
    }
  }

  /**
   * sorts the  strings to which one is the closests
   *
   * @return task data and the integer of how similar it is
   */
  public Stream<Map.Entry<TaskJson, Integer>> sortMapValues() {
    return searchMap.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue(Integer::compareTo)));
  }

  /**
   * gets the search map
   *
   * @return map of taskjson and integers
   */
  public Map<TaskJson, Integer> getSearchMap() {
    return searchMap;
  }

}
