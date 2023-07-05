package cs3500.pa05.view;

import cs3500.pa05.controller.ControllerInterface;

/**
 *
 */
public class GuiViewDark extends GuiViewAbstract {
  /**
   * constructor for the gui view
   *
   * @param controller the controller
   */
  public GuiViewDark(ControllerInterface controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("noGoals.fxml"));
  }
}
