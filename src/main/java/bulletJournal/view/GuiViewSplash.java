package bulletJournal.view;


import bulletJournal.controller.ControllerInterface;

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
