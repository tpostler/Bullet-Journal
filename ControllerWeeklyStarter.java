package cs3500.pa05.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * controller for the weekly starter
 */
public class ControllerWeeklyStarter implements ControllerInterface {

  @FXML
  public Button newWeekButton;

  @FXML
  public Button verticalButton;

  @FXML
  public Button darkButton;

  private Stage stage;

  public ControllerWeeklyStarter(Stage stage) {
    this.stage = stage;
  }

  @Override
  public void run() {
    ScreenController controller = new ScreenController(stage);
    newWeekButton.setOnAction(event -> controller.newWeek());
    verticalButton.setOnAction(event -> controller.verticalScreen());
    darkButton.setOnAction(event -> controller.darkScreen());
  }
}
