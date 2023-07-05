package cs3500.pa05.controller;

import cs3500.pa05.model.JsonUtils;
import cs3500.pa05.model.PasswordJson;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 * sets up the password
 */
public class SetupPasswordController implements ControllerInterface {

  private Stage stage;
  @FXML
  public PasswordField passwordField;
  @FXML
  public PasswordField confirmPasswordField;
  @FXML
  public Button resetButton;
  @FXML
  public Button saveButton;

  /**
   * constructor
   *
   * @param stage stage
   */
  public SetupPasswordController(Stage stage) {
    this.stage = stage;
  }

  @Override
  public void run() {
    // Set event handlers programmatically
    resetButton.setOnAction(event -> resetPassword());
    saveButton.setOnAction(event -> savePassword());
  }

  /**
   * resets the pass word
   */
  private void resetPassword() {
    passwordField.clear();
    confirmPasswordField.clear();
  }


  /**
   * saves the password
   */
  private void savePassword() {
    PasswordJson passwordJson = new PasswordJson(passwordField.getText());
    ControllerAbstract.fileAttributeNodes.add(JsonUtils.serializeRecord(passwordJson));
    String password = passwordField.getText();
    String confirmPassword = confirmPasswordField.getText();

    if (!password.isEmpty() && password.equals(confirmPassword)) {
      // Save the password or perform any necessary action
      showSuccessAlert("Password saved successfully!");
    } else {
      showErrorAlert("Passwords do not match. Please try again.");
    }
    ScreenController controller = new ScreenController(stage);
    controller.weeklyStarters();
  }

  /**
   * shows the success alert
   *
   * @param message to be displayed
   */
  private void showSuccessAlert(String message) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Success");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }

  /**
   * shows the error message
   *
   * @param message to be displayed
   */
  public void showErrorAlert(String message) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
