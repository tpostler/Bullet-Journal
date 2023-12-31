package bulletJournal.view;

import bulletJournal.controller.ControllerInterface;
import javafx.fxml.FXMLLoader;

/**
 * represents the class for the task gui
 */
public class GuiViewTask extends GuiViewAbstract {

  /**
   * represents the constructor for the task gui
   *
   * @param controller the controller.
   */
  public GuiViewTask(ControllerInterface controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Task.fxml"));
  }
}
