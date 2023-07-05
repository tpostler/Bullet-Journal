package cs3500.pa05.view;

import cs3500.pa05.controller.ControllerInterface;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * represents the GUI for the settings popup
 */
public class GuiViewSetting extends GuiViewAbstract {

  /**
   * represents the constructor for the settings gui
   *
   * @param controller controller
   */
  public GuiViewSetting(ControllerInterface controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Settings.fxml"));
  }
}
