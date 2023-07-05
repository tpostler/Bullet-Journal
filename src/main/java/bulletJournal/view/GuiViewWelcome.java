package bulletJournal.view;


import bulletJournal.controller.ControllerInterface;

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
