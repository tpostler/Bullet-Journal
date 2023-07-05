package bulletJournal.view;


import bulletJournal.controller.ControllerInterface;

/**
 * represents the gui for the fifth theme
 */
public class GuiViewTheme5 extends GuiViewAbstract {

  /**
   * Sets the loader to the fifth theme.
   *
   * @param controller the controller.
   */
  public GuiViewTheme5(ControllerInterface controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Theme5.fxml"));
  }
}
