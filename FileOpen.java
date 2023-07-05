package cs3500.pa05.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.controller.ControllerAbstract;
import cs3500.pa05.controller.ScreenController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Stream;
import javafx.stage.Stage;

/**
 * Opens a given bujo file.
 */
public class FileOpen {

  private Stage stage;
  private Path path;
  private ArrayList<EventJson> events = new ArrayList<>();
  private ArrayList<TaskJson> tasks = new ArrayList<>();
  private GoalsJson goals;
  private NotesJson notes;
  private WeekNameJson name;
  private PasswordJson password;

  /**
   * constructor for File open
   *
   * @param stage stage
   * @param path  path
   */

  public FileOpen(Stage stage, Path path) {
    this.stage = stage;
    this.path = path;
  }

  /**
   * constructor for file open
   *
   * @param path path
   */
  public FileOpen(Path path) {
    this.path = path;
  }

  /**
   * gets the file attributes
   */
  public void getFileAttributes() {
    try (Stream<String> linesStream = Files.lines(path)) {
      linesStream.forEach(line -> {
        try {
          addJson(line);
        } catch (JsonProcessingException e) {
          throw new RuntimeException(e);
        }
      });
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * adds the json to the mapper
   *
   * @param line to be added
   * @throws JsonProcessingException if json couldnt be processed
   */
  private void addJson(String line) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    if (line.startsWith("Event")) {
      line = line.replace("Event ", "");
      EventJson event = mapper.readValue(line, EventJson.class);
      events.add(event);
    } else if (line.startsWith("Task")) {
      line = line.replace("Task ", "");
      TaskJson task = mapper.readValue(line, TaskJson.class);
      tasks.add(task);
    } else if (line.startsWith("Goals")) {
      line = line.replace("Goals ", "");
      GoalsJson goals = mapper.readValue(line, GoalsJson.class);
      this.goals = goals;
    } else if (line.startsWith("Notes")) {
      line = line.replace("Notes ", "");
      NotesJson note = mapper.readValue(line, NotesJson.class);
      this.notes = note;
    } else if (line.startsWith("Week")) {
      line = line.replace("Week Title ", "");
      WeekNameJson name = mapper.readValue(line, WeekNameJson.class);
      this.name = name;
    } else if (line.startsWith("Password")) {
      line = line.replace("Password ", "");
      PasswordJson password = mapper.readValue(line, PasswordJson.class);
      this.password = password;
    }
  }

  /**
   * opens a previous week
   */
  public void openPreviousWeek() {
    ScreenController controller = new ScreenController(stage);
    controller.newWeek();
    ControllerAbstract mainController = controller.getController();
    for (EventJson event : events) {
      mainController.addEventToWeek(event);
    }
    for (TaskJson task : tasks) {
      mainController.addTaskToWeek(task);
    }
    mainController.addFileAttributes(goals, notes, name);
  }

  /**
   * gets the password
   *
   * @return the password
   */
  public String getPassword() {
    return password.getPassword();
  }

}
