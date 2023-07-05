package cs3500.pa05.view;

import cs3500.pa05.controller.ControllerInterface;

/**
 * Opens a new welcome screen.
 */
public class GuiViewWelcome extends GuiViewAbstract {
  /**
   * constructor for the gui view
   *
   * @param controller the controller
   */
  public GuiViewWelcome(ControllerInterface controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Welcome.fxml"));
  }
}
