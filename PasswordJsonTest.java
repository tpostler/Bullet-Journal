package cs3500.pa05.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests the password json
 */
public class PasswordJsonTest {

  /**
   * testing getting the password
   */
  @Test
  public void testGetPassword() {
    // Create a PasswordJson instance
    PasswordJson passwordJson = new PasswordJson("password123");

    // Verify that the getPassword method returns the correct password
    Assertions.assertEquals("password123", passwordJson.getPassword());
  }

  /**
   * testing serialization
   *
   * @throws JsonProcessingException json error
   */
  @Test
  public void testSerialization() throws JsonProcessingException {
    // Create a PasswordJson instance
    PasswordJson passwordJson = new PasswordJson("password123");

    // Serialize the PasswordJson object to JSON
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(passwordJson);

    // Verify that the serialized JSON contains the correct password field
    Assertions.assertTrue(json.contains("\"Password\":\"password123\""));
  }

  /**
   * Testing the deserialziation of the file
   *
   * @throws IOException json error
   */
  @Test
  public void testDeserialization() throws IOException {
    // Create a JSON string representing a PasswordJson object
    String json = "{\"Password\":\"password123\"}";

    // Deserialize the JSON to a PasswordJson object
    ObjectMapper objectMapper = new ObjectMapper();
    PasswordJson passwordJson = objectMapper.readValue(json, PasswordJson.class);

    // Verify that the deserialized PasswordJson object has the correct password
    Assertions.assertEquals("password123", passwordJson.getPassword());
  }
}