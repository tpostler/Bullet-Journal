package bulletJournal.controller;

import bulletJournal.model.Warnings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * Settings controller handles setting the warnings
 */
public class SettingsController implements ControllerInterface {

  // the spinner itself
  @FXML
  public Spinner<Integer> eventSpinner;
  @FXML
  public Spinner<Integer> taskSpinner;
  // the values in the spinner
  private SpinnerValueFactory<Integer> eventValueFactory =
      new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 28, 1);
  private SpinnerValueFactory<Integer> taskValueFactory =
      new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 28, 1);

  @FXML
  public Button doneButton;

  private ScreenController controller;

  // warnings that will be updated with spinner
  private Warnings warnings;

  /**
   * creates an instance of setting controller, setting it up
   *
   * @param controller screen controller
   * @param warnings   warnings class that will be updated
   */
  public SettingsController(ScreenController controller, Warnings warnings) {
    this.controller = controller;
    this.warnings = warnings;
  }

  /**
   * setting up the spinners and done button
   */
  public void run() {
    // adding the values to the spinners
    eventSpinner.setValueFactory(eventValueFactory);
    taskSpinner.setValueFactory(taskValueFactory);

    doneButton.setOnAction(event1 -> setEverythingAndClose());
  }

  /**
   * returning to the main screen, updating all the max values
   */
  private void setEverythingAndClose() {
    // gets the final values in spinner and updates the max totals
    warnings.updateEventMax(eventSpinner.getValue());
    warnings.updatedTaskMax(taskSpinner.getValue());
    // returns to the main stage
    controller.activateMain();
  }
}
