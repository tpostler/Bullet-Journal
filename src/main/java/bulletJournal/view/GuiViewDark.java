package bulletJournal.view;


import bulletJournal.controller.ControllerInterface;

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
