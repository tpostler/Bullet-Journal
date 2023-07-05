package bulletJournal.view;

import bulletJournal.controller.ControllerInterface;
import javafx.scene.Scene;

/**
 * represents the vertical view of the gui
 */

public class GuiViewVertical extends GuiViewAbstract {

  /**
   * constructor for the gui view
   *
   * @param controller the controller
   */
  public GuiViewVertical(ControllerInterface controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("VerticalCalender.fxml"));
  }
}
