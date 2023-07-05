package cs3500.pa05.controller;

import cs3500.pa05.model.EventJson;
import cs3500.pa05.model.TaskJson;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


/**
 * PopupUtils helper class to show popups to user
 */
public class PopupUtils {

  /**
   * shows an event (used for miniView)
   *
   * @param eventJson event record
   */
  public static void showEventPopup(EventJson eventJson) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Event Information");
    alert.setHeaderText("Name: " + eventJson.getName());

    //System.out.println("get time of day: " + eventJson.getTimeOfDay());
    Label description = new Label("Description: " + eventJson.getDescription() + "\n"
        + "Start Time: " + eventJson.getStartTime() +  eventJson.getTimeOfDay());
    VBox box = new VBox();
    box.getChildren().add(description);
    for (int i = 0; i < eventJson.getLinks().size(); i++) {
      Hyperlink link = new Hyperlink();
      link.setText(eventJson.getLinks().get(i));
      link.setOnAction(event -> {
        Desktop desk = Desktop.getDesktop();
        try {
          desk.browse(new URI(link.getText()));
        } catch (IOException | URISyntaxException e) {
          throw new RuntimeException(e);
        }
      });
      box.getChildren().add(link);
    }
    alert.getDialogPane().setContent(box);
    alert.showAndWait();
  }

  /**
   * shows a task (used for miniView)
   *
   * @param taskJson task record
   */
  public static void showTaskPopup(TaskJson taskJson) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Task Information");
    alert.setHeaderText("Name: " + taskJson.getName());
    alert.setContentText("Description: " + taskJson.getDescription() + "\n"
        + "Day: " + taskJson.getDay());
    alert.showAndWait();
  }
}