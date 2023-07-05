package cs3500.pa05.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import cs3500.pa05.model.EventJson;
import cs3500.pa05.model.FileCreate;
import cs3500.pa05.model.FileReader;
import cs3500.pa05.model.FuzzySearch;
import cs3500.pa05.model.GoalsJson;
import cs3500.pa05.model.JsonUtils;
import cs3500.pa05.model.NotesJson;
import cs3500.pa05.model.SaveModel;
import cs3500.pa05.model.TaskJson;
import cs3500.pa05.model.Warnings;
import cs3500.pa05.model.WeekNameJson;
import cs3500.pa05.model.Weekday;
import cs3500.pa05.view.GuiView;
import cs3500.pa05.view.GuiViewEvent;
import cs3500.pa05.view.GuiViewMain;
import cs3500.pa05.view.GuiViewSetting;
import cs3500.pa05.view.GuiViewTask;
import cs3500.pa05.view.GuiViewTheme2;
import cs3500.pa05.view.GuiViewTheme3;
import cs3500.pa05.view.GuiViewTheme4;
import cs3500.pa05.view.GuiViewTheme5;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Creates an instance of a Controller, delegates the button actions to model
 */
public abstract class ControllerAbstract implements ControllerInterface {

  // Buttons that will take you to another screen/scene, excluding save button
  // which will save the week to a json
  @FXML
  public MenuItem eventButton;

  @FXML
  public MenuItem openButton;
  @FXML
  public MenuItem taskButton;
  @FXML
  public MenuItem saveButton;
  @FXML
  public MenuItem settingsButton;
  @FXML
  public MenuItem newWeekButton;

  // Buttons for different themes
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

  // holds all the menu items
  @FXML
  public MenuBar menuBar;

  // the main week screen
  @FXML
  public Scene mainScene;

  // the goals and notes box
  @FXML
  public TextArea goalsBox;
  @FXML
  public TextArea notesBox;

  // the search bar
  @FXML
  public TextField searchBar;

  @FXML
  public ComboBox searchComboBox;

  // where user inputs the week name
  @FXML
  public TextField weekName;

  // where all the events and tasks are stores
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
  public ComboBox<String> toDo;


  private Stage stage;

  // PopUp Message helper class
  public static PopupUtils popup;

  public static ArrayList<JsonNode> fileAttributeNodes = new ArrayList<>();
  // stores all the events/tasks in arrayList
  public static ArrayList<JsonNode> tasksAndEvents = new ArrayList<>();
  public static ArrayList<TaskJson> taskList = new ArrayList<>();
  public static ArrayList<EventJson> eventList = new ArrayList<>();

  // Controllers for event/tasks
  public EventController eventController;
  public TaskController taskController;

  // Warnings helper class
  private Warnings warnings;


  /**
   * Constucts a new instance of Controller Abstract
   *
   * @param stage : which theme is being shown
   */
  public ControllerAbstract(Stage stage) {
    this.stage = stage;
  }

  /**
   * runs the program
   */
  @Override
  public void run() {
    //initializes all the shortcuts.
    initialize();


    // need to initialize warnings
    warnings = new Warnings();

    ComboBox<String> toDo = new ComboBox<>();


    ScreenController controller = new ScreenController(mainScene, stage);

    // Initatilizes event/task controller
    eventController = new EventController(controller, stage, this);
    taskController = new TaskController(controller, stage, this);

    // loads an event creator scene
    eventButton.setOnAction(event -> {
      GuiViewEvent viewEvent = new GuiViewEvent(eventController);
      stage.setScene(viewEvent.load());
      eventController.run();
    });

    // loads a new task creator scene
    taskButton.setOnAction(event -> {
      GuiViewTask viewTask = new GuiViewTask(taskController);
      stage.setScene(viewTask.load());
      taskController.run();
    });

    // saves the current state of the week
    saveButton.setOnAction(event -> {
      saveHelper();
    });

    openButton.setOnAction(event -> controller.welcomeScreen());

    //Allows the user to set the max amount of events and tasks
    settingsButton.setOnAction(event -> {
      SettingsController settingsController = new SettingsController(controller, warnings);
      GuiViewSetting viewSetting = new GuiViewSetting(settingsController);
      stage.setScene(viewSetting.load());
      settingsController.run();
    });

    searchBar.setOnAction(event -> pasteSearchResults(searchBar.getText()));

    //Opens a new week that is blank
    newWeekButton.setOnAction(event -> controller.newWeek());

    //Loads the correct theme
    loadTheme();
  }


  /**
   * serializes the file nodes
   */
  private void saveHelper() {
    WeekNameJson weekNameJson = new WeekNameJson(weekName.getText());
    fileAttributeNodes.add(JsonUtils.serializeRecord(weekNameJson));

    GoalsJson goals = new GoalsJson(goalsBox.getText());
    fileAttributeNodes.add(JsonUtils.serializeRecord(goals));

    NotesJson notes = new NotesJson(notesBox.getText());
    fileAttributeNodes.add(JsonUtils.serializeRecord(notes));

    Path file = createFile(weekNameJson.name());
    //if file ID already exists in another saved file open that one and save
    saveFile(file);
  }

  /**
   * pastes the search results for the search
   *
   * @param toSearch - string to
   */
  private void pasteSearchResults(String toSearch) {
    FuzzySearch searcher = new FuzzySearch(taskList);
    searcher.similarStrings(toSearch);
    Stream<Map.Entry<TaskJson, Integer>> sortedMapStream = searcher.sortMapValues();
    String[] nameList = new String[searcher.getSearchMap().size()];
    int count = 0;
    Map<TaskJson, Integer> sortedMap = sortedMapStream.sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
            (e1, e2) -> e1, LinkedHashMap::new));
    for (Map.Entry<TaskJson, Integer> entry : sortedMap.entrySet()) {
      nameList[count] = entry.getKey().getName();
      count++;
    }
    ObservableList<String> observableList = FXCollections.observableArrayList(nameList);
    searchComboBox.setItems(observableList);
  }


  /**
   * adds a new event to the week
   *
   * @param eventJson record of event
   */
  public void addEventToWeek(EventJson eventJson) {
    if (!warnings.isOverEventMax()) {
      tasksAndEvents.add(JsonUtils.serializeRecord(eventJson));
      eventList.add(eventJson);
      CheckBox box = new CheckBox(eventJson.startTime() + " " + eventJson.name()
          + System.lineSeparator() + eventJson.description());
      // mini view button
      Button miniButton = new Button("Mini View");
      // delete button
      Button deleteButton = new Button("Delete");
      addToRightDay(eventJson.day(), box, miniButton, deleteButton);

      // removes an event in all lists and week
      deleteButton.setOnAction(event -> removeEvent(eventJson, box, miniButton, deleteButton));

      // shows the mini view of the event
      miniButton.setOnAction(event -> popup.showEventPopup(eventJson));
    } else {
      // will show error if max num of events has been rached
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Error");
      alert.setHeaderText("Reached maximum events");
      alert.showAndWait();
    }
    warnings.updateEventTotal(eventList.size());
  }

  /**
   * removes an event from the lists and the week view
   *
   * @param event        record of event
   * @param box          box that has event
   * @param miniButton   mini view button
   * @param deleteButton delete button
   */
  private void removeEvent(EventJson event, CheckBox box, Button miniButton, Button deleteButton) {
    eventList.remove(event);
    tasksAndEvents.remove(event);
    removeEventFromRightDay(event.day(), box, miniButton, deleteButton);
  }

  /**
   * helper method that will remove the event from the week
   *
   * @param day          day that event needs to be removed from
   * @param box          event box
   * @param miniButton   mini button
   * @param deleteButton delete button
   */
  private void removeEventFromRightDay(Weekday day, CheckBox box, Button miniButton,
                                       Button deleteButton) {
    switch (day) {
      case MONDAY -> {
        mondayBox.getChildren().remove(box);
        mondayBox.getChildren().remove(miniButton);
        mondayBox.getChildren().remove(deleteButton);
      }
      case TUESDAY -> {
        tuesdayBox.getChildren().remove(box);
        tuesdayBox.getChildren().remove(miniButton);
        tuesdayBox.getChildren().remove(deleteButton);
      }
      case WEDNESDAY -> {
        wednesdayBox.getChildren().remove(box);
        wednesdayBox.getChildren().remove(miniButton);
        wednesdayBox.getChildren().remove(deleteButton);
      }
      case THURSDAY -> {
        thursdayBox.getChildren().remove(box);
        thursdayBox.getChildren().remove(miniButton);
        thursdayBox.getChildren().remove(deleteButton);
      }
      case FRIDAY -> {
        fridayBox.getChildren().remove(box);
        fridayBox.getChildren().remove(miniButton);
        fridayBox.getChildren().remove(deleteButton);
      }
      case SATURDAY -> {
        saturdayBox1.getChildren().remove(box);
        saturdayBox1.getChildren().remove(miniButton);
        saturdayBox1.getChildren().remove(deleteButton);
      }
      case SUNDAY -> {
        sundayBox1.getChildren().remove(box);
        sundayBox1.getChildren().remove(miniButton);
        sundayBox1.getChildren().remove(deleteButton);
      }
      default -> {
      }
    }
  }

  /**
   * adds the task to Week
   *
   * @param taskJson task record
   */
  public void addTaskToWeek(TaskJson taskJson) {
    if (!warnings.isOverTaskMax()) {
      tasksAndEvents.add(JsonUtils.serializeRecord(taskJson));
      taskList.add(taskJson);
      ObservableList<String> taskObservableList = FXCollections.observableArrayList();
      // Add tasks to the observable list
      for (TaskJson task : taskList) {
        String taskName =
            task.getName();
        taskObservableList.add(taskName);
      }

      Comparator<String> taskComparator = Comparator.comparingInt(task ->
          getDayOfWeekOrder(
              getTaskDay(taskList, task))); // Assuming you have implemented getTaskDay() correctly
      taskObservableList.sort(taskComparator);
      // Clear the existing contents of taskObservableList


      // Set the observable list as items in the ComboBox
      toDo.setItems(taskObservableList);
      // task
      CheckBox box = new CheckBox(taskJson.name()
          + System.lineSeparator() + taskJson.description());
      //mini view button
      Button miniButton = new Button("Mini View");
      //delete button
      Button deleteButton = new Button("Delete");

      // helper to add to the week
      addToRightDay(taskJson.day(), box, miniButton, deleteButton);
      // when clicked will show mini view
      miniButton.setOnAction(event -> popup.showTaskPopup(taskJson));
      deleteButton.setOnAction(event -> removeTask(taskJson, box, miniButton, deleteButton));
    } else {
      // shows an alert if the max num of tasks has been reached
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Error");
      alert.setHeaderText("Reached maximum tasks");
      alert.showAndWait();
    }
    warnings.updateTaskTotal(taskList.size());
  }

  /**
   * removes a task from the week
   *
   * @param taskJson     task
   * @param box          task box
   * @param miniButton   mini view button
   * @param deleteButton delete button
   */
  private void removeTask(TaskJson taskJson, CheckBox box, Button miniButton, Button deleteButton) {
    taskList.remove(taskJson);
    tasksAndEvents.remove(taskJson);
    removeEventFromRightDay(taskJson.getDay(), box, miniButton, deleteButton);
  }

  /**
   * helper method that will add either event/task to week
   *
   * @param day          day to be added to
   * @param box          event/task
   * @param button       mini view button
   * @param deleteButton delete button
   */
  public void addToRightDay(Weekday day, CheckBox box, Button button, Button deleteButton) {
    switch (day) {
      case MONDAY -> mondayBox.getChildren().addAll(box, button, deleteButton);
      case TUESDAY -> tuesdayBox.getChildren().addAll(box, button, deleteButton);
      case WEDNESDAY -> wednesdayBox.getChildren().addAll(box, button, deleteButton);
      case THURSDAY -> thursdayBox.getChildren().addAll(box, button, deleteButton);
      case FRIDAY -> fridayBox.getChildren().addAll(box, button, deleteButton);
      case SATURDAY -> saturdayBox1.getChildren().addAll(box, button, deleteButton);
      case SUNDAY -> sundayBox1.getChildren().addAll(box, button, deleteButton);
      default -> System.out.println("No day chosen");
    }
  }

  /**
   * sets up the program and bings all the keyboard shortcuts
   */
  public void initialize() {
    Menu createMenu = menuBar.getMenus().get(0);
    MenuItem event = createMenu.getItems().get(0);
    event.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));;
    MenuItem task = createMenu.getItems().get(1);
    task.setAccelerator(KeyCombination.keyCombination("Ctrl+T"));
    Menu saveMenu = menuBar.getMenus().get(1);
    MenuItem save = saveMenu.getItems().get(0);
    save.setAccelerator(KeyCombination.keyCombination("Ctrl + S"));
    Menu openMenu = menuBar.getMenus().get(2);
    MenuItem open = openMenu.getItems().get(0);
    open.setAccelerator(KeyCombination.keyCombination("Ctrl + O"));
    Menu newWeekMenu = menuBar.getMenus().get(3);
    MenuItem newWeek = newWeekMenu.getItems().get(0);
    newWeek.setAccelerator(KeyCombination.keyCombination("Ctrl + N"));
    Menu settingsmenu = menuBar.getMenus().get(4);
    MenuItem settings = settingsmenu.getItems().get(0);
    settings.setAccelerator(KeyCombination.keyCombination("Ctrl + ,"));
    Menu theme = menuBar.getMenus().get(5);
    MenuItem theme1 = theme.getItems().get(0);
    theme1.setAccelerator(KeyCombination.keyCombination("Ctrl + 1"));
    MenuItem theme2 = theme.getItems().get(1);
    theme2.setAccelerator(KeyCombination.keyCombination("Ctrl + 2"));
    MenuItem theme3 = theme.getItems().get(2);
    theme3.setAccelerator(KeyCombination.keyCombination("Ctrl + 3"));
    MenuItem theme4 = theme.getItems().get(3);
    theme4.setAccelerator(KeyCombination.keyCombination("Ctrl + 4"));
    MenuItem theme5 = theme.getItems().get(4);
    theme5.setAccelerator(KeyCombination.keyCombination("Ctrl + 5"));
  }

  /**
   * saves the week into a json
   *
   * @param file bujo file
   */
  private void saveFile(Path file) {
    SaveModel save = new SaveModel();
    save.save(file, fileAttributeNodes, eventList, taskList);
  }

  /**
   * creates a new bujo file
   *
   * @return path ot gile
   */
  private Path createFile(String name) {
    FileReader reader = new FileReader();
    try {
      Files.walkFileTree(Path.of("src/main/resources"), reader);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    FileCreate creator = new FileCreate(reader.getBujoFiles(), name);
    try {
      return creator.create();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * loads and changes the theme of week
   */
  private void loadTheme() {
    ControllerTheme controller = new ControllerTheme(stage, fileAttributeNodes, taskList,
        eventList);
    theme1.setOnAction(event -> loadThemeHelper(new GuiViewMain(controller), controller));
    theme2.setOnAction(event -> loadThemeHelper(new GuiViewTheme2(controller), controller));
    theme3.setOnAction(event -> loadThemeHelper(new GuiViewTheme3(controller), controller));
    theme4.setOnAction(event -> loadThemeHelper(new GuiViewTheme4(controller), controller));
    theme5.setOnAction(event -> loadThemeHelper(new GuiViewTheme5(controller), controller));
  }

  /**
   * helper method to load in the themes
   *
   * @param view       view that theme should be loaded into
   * @param controller controller to be run
   */
  private void loadThemeHelper(GuiView view, ControllerTheme controller) {
    saveHelper();
    stage.setScene(view.load());
    controller.run();
    try {
      controller.loadAttributes();
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }


  /**
   * switch case so that the tasks can be sorted by day of the week
   *
   * @param weekDay day that the task is on
   * @return the number case of the task
   */

  private int getDayOfWeekOrder(Weekday weekDay) {
    switch (weekDay) {
      case MONDAY:
        return 1;
      case TUESDAY:
        return 2;
      case WEDNESDAY:
        return 3;
      case THURSDAY:
        return 4;
      case FRIDAY:
        return 5;
      case SATURDAY:
        return 6;
      case SUNDAY:
        return 7;
      default:
        throw new IllegalArgumentException("Invalid weekday: " + weekDay);
    }
  }

  /**
   * gets the task day
   *
   * @param taskList task list that needs to return the day of
   * @param taskName name of the task
   * @return the day of the week the task is on
   */
  private Weekday getTaskDay(List<TaskJson> taskList, String taskName) {
    for (TaskJson taskJson : taskList) {
      String name = taskJson.getName();
      if (name.equals(taskName)) {
        Weekday taskDay = taskJson.getDay();
        return Weekday.valueOf(String.valueOf(taskDay));
      }
    }
    throw new IllegalArgumentException("Task not found: " + taskName);
  }


  /**
   * Adds the given file attributes to the file.
   *
   * @param goals the goals.
   * @param notes the notes.
   * @param name  the name of the week.
   */
  public void addFileAttributes(GoalsJson goals, NotesJson notes, WeekNameJson name) {
    // ERROR SOMEWHERE
    goalsBox.appendText(goals.goals());
    notesBox.appendText(notes.notes());
    weekName.appendText(name.name());
  }

}
