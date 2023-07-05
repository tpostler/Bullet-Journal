package cs3500.pa05.view;

import cs3500.pa05.controller.ControllerInterface;
import javafx.fxml.FXMLLoader;

/**
 * The GUI view class.
 */
public class GuiViewMain extends GuiViewAbstract {

  /**
   * represents the constructor of the main scene
   *
   * @param controller the controller.
   */
  public GuiViewMain(ControllerInterface controller) {
    super(controller);
    // look up and store the layout
    this.loader.setLocation(getClass().getClassLoader().getResource("PA05Calender.fxml"));
  }
}
