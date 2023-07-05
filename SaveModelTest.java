package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * Testing the saveModel
 */
public class SaveModelTest {

  /**
   * testing saving a file with associatied json nodes
   */
  @Test
  public void testSave() {
    GoalsJson goals = new GoalsJson("goals");

    ArrayList<JsonNode> nodes = new ArrayList<>();
    nodes.add(JsonUtils.serializeRecord(goals));

    ArrayList<String> links = new ArrayList<>();
    links.add("link");

    ArrayList<EventJson> events = new ArrayList<>();
    EventJson event = new EventJson("name", "desc", Weekday.FRIDAY,
        "AM", "10:30", links);
    events.add(event);

    ArrayList<TaskJson> tasks = new ArrayList<>();
    TaskJson task = new TaskJson("name", "desc", Weekday.FRIDAY);
    tasks.add(task);

    SaveModel saveModel = new SaveModel();

    File expected = new File("src/test/resources/TestWeek.bujo");
    Path path = Path.of(expected.getPath());

    saveModel.save(path, nodes, events, tasks);

    assertTrue(expected.exists());
  }
}
