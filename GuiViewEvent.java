package cs3500.pa05.view;

import cs3500.pa05.controller.ControllerInterface;
import javafx.fxml.FXMLLoader;

/**
 * represents the gui of the event
 */
public class GuiViewEvent extends GuiViewAbstract {

  /**
   * the constructor
   *
   * @param controller the controller.
   */
  public GuiViewEvent(ControllerInterface controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Event.fxml"));
  }
}
