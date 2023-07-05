package cs3500.pa05.controller;

import cs3500.pa05.model.Task;
import cs3500.pa05.model.TaskJson;
import cs3500.pa05.model.Weekday;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * the controller for task
 */
public class TaskController implements ControllerInterface {

  private Stage stage;

  // how the user is customizing the task
  @FXML
  public TextField taskTitle;
  @FXML
  public TextArea taskDescription;
  @FXML
  public Button doneButton;

  // the days which the user can pick from
  @FXML
  public MenuItem monday;
  @FXML
  public MenuItem tuesday;
  @FXML
  public MenuItem wednesday;
  @FXML
  public MenuItem thursday;
  @FXML
  public MenuItem friday;
  @FXML
  public MenuItem saturday;
  @FXML
  public MenuItem sunday;

  // I don't think we need this
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
  public VBox saturdayBox;
  @FXML
  public VBox sundayBox;

  @FXML
  public MenuButton dayWeek;

  @FXML
  public Button cancelButton;

  // the task json
  private TaskJson taskJson;

  // needs a privacy thingy
  ScreenController controller;

  private ControllerAbstract controllerAbstract;

  /**
   * creates an instance of task controller, handles creating a task
   *
   * @param controller         screen controller
   * @param stage              stage that usr was on
   * @param controllerAbstract the controller of project
   */
  public TaskController(ScreenController controller, Stage stage,
                        ControllerAbstract controllerAbstract) {
    this.controller = controller;
    this.stage = stage;
    this.controllerAbstract = controllerAbstract;
  }

  /**
   * runs the task, when task button is created this will execute
   */
  @FXML
  public void run() {
    Task task = new Task();
    setDay(task);
    doneButton.setOnAction(event -> setEverythingAndClose(task));
    setMenuItemAction(monday, task);
    setMenuItemAction(tuesday, task);
    setMenuItemAction(wednesday, task);
    setMenuItemAction(thursday, task);
    setMenuItemAction(friday, task);
    setMenuItemAction(saturday, task);
    setMenuItemAction(sunday, task);
    cancelButton.setOnAction(event -> cancelButtonAction());
  }

  /**
   * Sets the selected day for the task and updates the prompt text of dayButton
   *
   * @param menuItem The MenuItem associated with the week day
   * @param task     The task to update
   */
  private void setMenuItemAction(MenuItem menuItem, Task task) {
    menuItem.setOnAction(event -> {
      Weekday selectedDay = getWeekDayFromMenuItem(menuItem);
      task.setWeekDay(selectedDay);
      dayWeek.setText(selectedDay.toString());
    });
  }

  /**
   * Retrieves the WeekDay enum value associated with a MenuItem
   *
   * @param menuItem The MenuItem to retrieve the WeekDay from
   * @return The corresponding WeekDay enum value
   */
  private Weekday getWeekDayFromMenuItem(MenuItem menuItem) {
    if (menuItem == monday) {
      return Weekday.MONDAY;
    } else if (menuItem == tuesday) {
      return Weekday.TUESDAY;
    } else if (menuItem == wednesday) {
      return Weekday.WEDNESDAY;
    } else if (menuItem == thursday) {
      return Weekday.THURSDAY;
    } else if (menuItem == friday) {
      return Weekday.FRIDAY;
    } else if (menuItem == saturday) {
      return Weekday.SATURDAY;
    } else if (menuItem == sunday) {
      return Weekday.SUNDAY;
    }
    return null;
  }


  /**
   * returns to the main screen again, look this over again
   *
   * @param task task
   */
  public void setEverythingAndClose(Task task) {
    task.setName(taskTitle.getText());
    task.setDescription(taskDescription.getText());
    taskJson = new TaskJson(task.getName(), task.getDescription(), task.getDay());
    addTask();
    controller.activateMain();
  }

  /**
   * adds the task to the week
   */
  public void addTask() {
    controllerAbstract.addTaskToWeek(taskJson);
  }

  /**
   * helper method to set a day for task
   *
   * @param task task
   */
  public void setDay(Task task) {
    monday.setOnAction(e -> task.setWeekDay(Weekday.MONDAY));
    tuesday.setOnAction(e -> task.setWeekDay(Weekday.TUESDAY));
    wednesday.setOnAction(e -> task.setWeekDay(Weekday.WEDNESDAY));
    thursday.setOnAction(e -> task.setWeekDay(Weekday.THURSDAY));
    friday.setOnAction(e -> task.setWeekDay(Weekday.FRIDAY));
    saturday.setOnAction(e -> task.setWeekDay(Weekday.SATURDAY));
    sunday.setOnAction(e -> task.setWeekDay(Weekday.SUNDAY));
  }

  /**
   * goes back to the main scene
   */
  @FXML
  public void cancelButtonAction() {
    controller.activateMain();
  }
}
