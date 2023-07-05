package bulletJournal.view;


import bulletJournal.controller.ControllerInterface;

/**
 * represents the Gui Password
 */
public class GuiViewPassword extends GuiViewAbstract {

  /**
   * represents the constructor of the main scene
   *
   * @param controller the controller.
   */
  public GuiViewPassword(ControllerInterface controller) {
    super(controller);
    // look up and store the layout
    this.loader.setLocation(getClass().getClassLoader().getResource("Password.fxml"));
  }
}


