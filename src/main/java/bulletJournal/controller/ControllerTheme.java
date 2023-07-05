package bulletJournal.controller;

import bulletJournal.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Contains all the elements in BulletJournal APp
 */
public class ControllerTheme extends ControllerAbstract {

  @FXML
  public MenuItem eventButton;
  @FXML
  public MenuItem taskButton;
  @FXML
  public MenuItem saveButton;
  @FXML
  public MenuItem settingsButton;
  @FXML
  public MenuItem newWeekButton;
  @FXML
  public MenuBar menuBar;
  @FXML
  public Scene mainScene;
  @FXML
  public TextArea goalsBox;
  @FXML
  public TextArea notesBox;
  @FXML
  public TextField weekName;
  @FXML
  public VBox mondayBox;
  @FXML
  public VBox tuesdayBox;
  @FXML
  public VBox wednesdayBox;
  @FXML
  public VBox thursdayBox;
  @FXML
  public VBox fridayBox;
  @FXML
  public VBox saturdayBox1;
  @FXML
  public VBox sundayBox1;
  @FXML
  public MenuItem theme1;
  @FXML
  public MenuItem theme2;
  @FXML
  public MenuItem theme3;
  @FXML
  public MenuItem theme4;
  @FXML
  public MenuItem theme5;

  private ArrayList<JsonNode> nodesList;

  private ArrayList<EventJson> events;

  private ArrayList<TaskJson> tasks;

  /**
   * Adds the stage to controller
   *
   * @param stage stage being shown to the user
   */
  public ControllerTheme(Stage stage, ArrayList<JsonNode> nodes, ArrayList<TaskJson> tasks,
                         ArrayList<EventJson> events) {
    super(stage);
    this.nodesList = nodes;
    this.events = events;
    this.tasks = tasks;
  }

  /**
   * Loads all of the previous file attributes.
   *
   * @throws JsonProcessingException if the file is unable to be written to.
   */
  public void loadAttributes() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    for (JsonNode node : nodesList) {
      if (node.has("goals")) {
        GoalsJson goal = mapper.readValue(node.toString(), GoalsJson.class);
        goalsBox.appendText(goal.goals());
      } else if (node.has("notes")) {
        NotesJson note = mapper.readValue(node.toString(), NotesJson.class);
        notesBox.appendText(note.notes());
      } else if (node.has("WeekName")) {
        WeekNameJson name = mapper.readValue(node.toString(), WeekNameJson.class);
        weekName.appendText(name.name());
      }
      for (EventJson event : events) {
        addEventToWeek(event);
      }
      for (TaskJson task : tasks) {
        addTaskToWeek(task);
      }
    }
  }
}
