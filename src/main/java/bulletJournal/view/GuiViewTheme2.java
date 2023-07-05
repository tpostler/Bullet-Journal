package bulletJournal.view;


import bulletJournal.controller.ControllerInterface;

/**
 * represents the gui for the second scene
 */
public class GuiViewTheme2 extends GuiViewAbstract {

  /**
   * Sets the loader to the second theme.
   *
   * @param controller the controller.
   */
  public GuiViewTheme2(ControllerInterface controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Theme2.fxml"));
  }
}
