package bulletJournal.view;


import bulletJournal.controller.ControllerInterface;

/**
 * represnts the gui for the weekly starter
 */
public class GuiViewWeeklyStarter extends GuiViewAbstract {
  /**
   * constructor for the gui view
   *
   * @param controller the controller
   */
  public GuiViewWeeklyStarter(ControllerInterface controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("WeeklyStarters.fxml"));
  }
}
