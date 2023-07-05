package cs3500.pa05.view;

import cs3500.pa05.controller.ControllerInterface;

/**
 * represents the gui for the fourth theme
 */
public class GuiViewTheme4 extends GuiViewAbstract {

  /**
   * Sets the loader to the fourth theme.
   *
   * @param controller the controller.
   */
  public GuiViewTheme4(ControllerInterface controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Theme4.fxml"));
  }
}
