package bulletJournal.controller;

import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

/**
 * Switches scenes.
 */
public class SceneSwitcher {

  @FXML
  public Button doneButton;


  /**
   * switches to main screen depending on button user clicked
   *
   * @param item button that was clicked
   * @throws IOException erro wwhen reading the resource
   */
  public void switchToMainScene(MenuBar item) throws IOException {
    Scene loader = FXMLLoader.load(
        Objects.requireNonNull(getClass().getClassLoader().getResource("PA05Calender.fxml")));
    Stage stage = (Stage) item.getScene().getWindow();
    stage.setScene(loader);
    stage.show();
  }
}
