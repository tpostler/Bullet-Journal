package cs3500.pa05.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



/**
 * tests the note Json
 */
public class NotesJsonTest {

  /**
   * Tesing the Serialization of json
   *
   * @throws IOException json error
   */
  @Test
  public void testSerialization() throws IOException {
    // Create a NotesJson object
    NotesJson notesJson = new NotesJson("Sample notes");

    // Serialize the object to JSON
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(notesJson);

    // Verify the JSON content
    String expectedJson = "{\"notes\":\"Sample notes\"}";
    Assertions.assertEquals(expectedJson, json);
  }

  /**
   * testing the de serialzation of json
   *
   * @throws IOException json error
   */
  @Test
  public void testDeserialization() throws IOException {
    // Define a JSON string
    String json = "{\"notes\":\"Sample notes\"}";

    // Deserialize the JSON string to a NotesJson object
    ObjectMapper mapper = new ObjectMapper();
    NotesJson notesJson = mapper.readValue(json, NotesJson.class);

    // Verify the deserialized object
    Assertions.assertEquals("Sample notes", notesJson.notes());
  }
}
