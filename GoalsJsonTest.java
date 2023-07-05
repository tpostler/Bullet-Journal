package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;


/**
 * Tests the goal json
 */
public class GoalsJsonTest {

  /**
   * making sure the goals are added to the json
   *
   * @throws Exception json error
   */
  @Test
  public void testGoalsJson() throws Exception {
    String goals = "Sample goals";
    GoalsJson goalsJson = new GoalsJson(goals);

    ObjectMapper mapper = new ObjectMapper();
    String jsonString = mapper.writeValueAsString(goalsJson);

    String expectedJsonString = "{\"goals\":\"Sample goals\"}";
    assertEquals(expectedJsonString, jsonString);
  }
}
