package cs3500.pa05.view;

import cs3500.pa05.controller.ControllerInterface;

/**
 * represents the gui for the third theme
 */
public class GuiViewTheme3 extends GuiViewAbstract {

  /**
   * Sets the loader to the third theme.
   *
   * @param controller the controller.
   */
  public GuiViewTheme3(ControllerInterface controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Theme3.fxml"));
  }
}
