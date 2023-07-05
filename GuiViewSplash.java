package cs3500.pa05.view;

import cs3500.pa05.controller.ControllerInterface;

/**
 * represents the gui view for the splash screen
 */
public class GuiViewSplash extends GuiViewAbstract {

  /**
   * constructor for the gui view
   *
   * @param controller the controller
   */
  public GuiViewSplash(ControllerInterface controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Splash.fxml"));
  }
}
