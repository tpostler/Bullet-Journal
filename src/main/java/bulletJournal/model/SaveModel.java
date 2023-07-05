package bulletJournal.model;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * represents the class needed to save a file
 */
public class SaveModel {

  /**
   * writes to the json nodes to the file
   *
   * @param file  file being written to
   * @param nodes nodes being written
   */

  public void save(Path file, ArrayList<JsonNode> nodes, ArrayList<EventJson> events,
                   ArrayList<TaskJson> tasks) {
    if (file.toFile().length() > 0) {
      FileOpen opener = new FileOpen(file);
      opener.getFileAttributes();
      nodes.add(JsonUtils.serializeRecord(new PasswordJson(opener.getPassword())));
    }
    try {
      PrintWriter writer = new PrintWriter(file.toFile());
      writer.print("");
      writer.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    FileWriter writer = new FileWriter();
    for (JsonNode node : nodes) {
      writer.write(node, file);
    }
    for (EventJson event : events) {
      writer.write(event, file);
    }
    for (TaskJson task : tasks) {
      writer.write(task, file);
    }
  }
}
