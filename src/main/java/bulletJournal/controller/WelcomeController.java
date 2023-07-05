package bulletJournal.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import bulletJournal.model.FileOpen;
import bulletJournal.model.FileReader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

/**
 * The welcome screen controller.
 */
public class WelcomeController implements ControllerInterface {

  @FXML
  public Button newWeekButton;

  @FXML
  public MenuButton comboBox;

  private Stage stage;

  /**
   * Welcome controller constructor.
   *
   * @param stage the stage to display the screen.
   */
  public WelcomeController(Stage stage) {
    this.stage = stage;
  }

  @Override
  public void run() {

    ScreenController controller = new ScreenController(stage);

    //set the action of the new week button
    newWeekButton.setOnAction(event -> controller.welcomeScreen());

    //Add each previously saved week
    Path path = Paths.get("src/main/resources");
    FileReader reader = new FileReader();
    try {
      Files.walkFileTree(path, reader);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    for (Path bujoFile : reader.getBujoFiles()) {
      MenuItem menuItem = new MenuItem(bujoFile.getFileName().toString());
      comboBox.getItems().add(menuItem);
      menuItem.setOnAction(event -> setMenuAction(bujoFile));
    }
  }


  /**
   * sets the menu action
   *
   * @param bujoFile the bujo file
   */
  private void setMenuAction(Path bujoFile) {
    comboBox.setText(bujoFile.getFileName().toString());
    final FileOpen opener = new FileOpen(stage, bujoFile);
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Enter Password");
    dialog.setHeaderText(null);
    dialog.setContentText("Please enter your password:");

    opener.getFileAttributes();

    String savedPassword = opener.getPassword();
    //System.out.println(opener.getPassword());

    // Show the password prompt and retrieve the entered password
    Optional<String> result = dialog.showAndWait();
    result.ifPresent(password -> {
      if (password.equals(savedPassword)) {
        // Password is correct, show the password setup screen
        opener.openPreviousWeek();
      } else {
        // Password is incorrect, show an error message
        showErrorAlert("Incorrect password. Please try again.");
      }
    });
  }

  /**
   * shows an error
   *
   * @param message to be shown
   */
  public void showErrorAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
