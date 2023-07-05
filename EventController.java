package cs3500.pa05.controller;

import com.fasterxml.jackson.databind.JsonNode;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.EventJson;
import cs3500.pa05.model.JsonUtils;
import cs3500.pa05.model.Weekday;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Event Controller, will handle creating an event
 */
public class EventController implements ControllerInterface {

  // the user inputting their data for the event
  @FXML
  public TextField eventTitle;
  @FXML
  public TextArea eventDescription;
  @FXML
  public TextField enterHour;
  @FXML
  public TextField enterMinute;
  @FXML
  public Button doneButton;

  @FXML
  public MenuButton dayButton;

  // the days which the user can pick
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

  @FXML
  public CheckBox am;
  @FXML
  public CheckBox pm;

  @FXML
  public Button cancelButton;


  private ScreenController controller;

  private EventJson eventJson;

  private Stage stage;

  private ControllerAbstract controllerAbstract;

  /**
   * creates an instance of EventController
   *
   * @param controller         the screen controller
   * @param stage              stage which the user is on
   * @param controllerAbstract controller that handles
   */
  public EventController(ScreenController controller, Stage stage,
                         ControllerAbstract controllerAbstract) {
    this.controller = controller;
    this.stage = stage;
    this.controllerAbstract = controllerAbstract;
  }

  /**
   * runs the controller, so anytime the event button pressed this will execute
   */
  @FXML
  public void run() {
    Event event = new Event();
    setDay(event);
    // need to close down scene when the done button is pressed
    doneButton.setOnAction(e -> setEverythingAndClose(event));
    setMenuItemAction(monday, event);
    setMenuItemAction(tuesday, event);
    setMenuItemAction(wednesday, event);
    setMenuItemAction(thursday, event);
    setMenuItemAction(friday, event);
    setMenuItemAction(saturday, event);
    setMenuItemAction(sunday, event);
    cancelButton.setOnAction(e -> cancelButtonAction());
  }

  /**
   * Sets the selected day for the task and updates the prompt text of dayButton
   *
   * @param menuItem The MenuItem associated with the week day
   * @param e        The event to update
   */
  private void setMenuItemAction(MenuItem menuItem, Event e) {
    menuItem.setOnAction(event -> {
      Weekday selectedDay = getWeekDayFromMenuItem(menuItem);
      e.setWeekDay(selectedDay);
      dayButton.setText(selectedDay.toString());
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

  public void setLinkList() {

  }

  /**
   * closes down the dialog and returns it back to the main screen
   *
   * @param event represents an event
   */
  public void setEverythingAndClose(Event event) {
    event.setName(eventTitle.getText());
    event.setDescription(eventDescription.getText());
    event.setStartTime(enterHour.getText() + ":" + enterMinute.getText());


    // Get the AM CheckBox from FXML or UI element reference
    CheckBox amCheckBox = am;
    // Get the PM CheckBox from FXML or UI element reference
    CheckBox pmCheckBox = pm;

    // setting am pm to task json
    if (amCheckBox.isSelected() && !pmCheckBox.isSelected()) {
      event.setTimeOfDay("AM");
    } else if (!amCheckBox.isSelected() && pmCheckBox.isSelected()) {
      event.setTimeOfDay("PM");
    } else {
      // Handle the case where neither AM nor PM is selected
      // You can throw an exception or set a default value
    }
    eventJson = new EventJson(event.getName(), event.getDescription(), event.getDay(),
        event.getTimeOfDay(), event.getStartTime(), event.getLinks());
    JsonNode node = JsonUtils.serializeRecord(eventJson);
    // ControllerAbstract.tasksAndEvents.add(node);
    addEvent();
    controller.activateMain();
  }

  /**
   * adds the event to the week
   */
  public void addEvent() {
    controllerAbstract.addEventToWeek(eventJson);
  }

  /**
   * getting the event json
   *
   * @return event json
   */
  public EventJson getEventJson() {
    return eventJson;
  }

  /**
   * helper method to set the day
   *
   * @param event button being clicked
   */
  private void setDay(Event event) {
    monday.setOnAction(e -> event.setWeekDay(Weekday.MONDAY));
    tuesday.setOnAction(e -> event.setWeekDay(Weekday.TUESDAY));
    wednesday.setOnAction(e -> event.setWeekDay(Weekday.WEDNESDAY));
    thursday.setOnAction(e -> event.setWeekDay(Weekday.THURSDAY));
    friday.setOnAction(e -> event.setWeekDay(Weekday.FRIDAY));
    saturday.setOnAction(e -> event.setWeekDay(Weekday.SATURDAY));
    sunday.setOnAction(e -> event.setWeekDay(Weekday.SUNDAY));
  }

  /**
   * goes back to the main scene
   */

  @FXML
  public void cancelButtonAction() {
    controller.activateMain();
  }
}
