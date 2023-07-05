package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

/**
 * Tests the JsonUtils class, cannot test the error thrown (TA told me that)
 */
public class JsonUtilsTest {

  /**
   * ensures the json is getting serializied correctly
   */
  @Test
  public void testSerialization() {
    TaskJson taskJson = new TaskJson("test", "test", Weekday.MONDAY);
    JsonNode node = JsonUtils.serializeRecord(taskJson);
    String expected = "{\"Name\":\"test\",\"Description\":\"test\",\"Weekday\":"
        + "\"MONDAY\"}";
    assertEquals(expected, node.toString());
  }
}
