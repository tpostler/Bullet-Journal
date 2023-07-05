package cs3500.pa05.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * The file writer class.
 */
public class FileWriter {

  /**
   * Adds the JsonNode to the given file.
   *
   * @param node the node to add.
   * @param file the file to write to.
   */
  public void write(JsonNode node, Path file) {
    try {
      if (node.has("goals")) {
        Files.write(file, "Goals ".getBytes(), StandardOpenOption.APPEND);
      } else if (node.has("notes")) {
        Files.write(file, "Notes ".getBytes(), StandardOpenOption.APPEND);
      } else if (node.has("WeekName")) {
        Files.write(file, "Week Title ".getBytes(), StandardOpenOption.APPEND);
      } else if (node.has("Password")) {
        Files.write(file, "Password ".getBytes(), StandardOpenOption.APPEND);
      }
      Files.write(file, node.toString().getBytes(), StandardOpenOption.APPEND);
      Files.write(file, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Writes an event to a given file.
   *
   * @param event the event JSON.
   * @param file  the file path.
   */
  public void write(EventJson event, Path file) {
    try {
      Files.write(file, "Event ".getBytes(), StandardOpenOption.APPEND);
      ObjectMapper mapper = new ObjectMapper();
      String jstr = mapper.writeValueAsString(event);
      Files.write(file, jstr.getBytes(), StandardOpenOption.APPEND);
      Files.write(file, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Writes a task to a given file.
   *
   * @param task the task JSON.
   * @param file the file path.
   */
  public void write(TaskJson task, Path file) {
    try {
      Files.write(file, "Task ".getBytes(), StandardOpenOption.APPEND);
      ObjectMapper mapper = new ObjectMapper();
      String jstr = mapper.writeValueAsString(task);
      Files.write(file, jstr.getBytes(), StandardOpenOption.APPEND);
      Files.write(file, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
