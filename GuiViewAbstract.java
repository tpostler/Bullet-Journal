package cs3500.pa05.view;

import cs3500.pa05.controller.ControllerInterface;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * represents the abstract gui view
 */
public abstract class GuiViewAbstract implements GuiView {

  FXMLLoader loader;

  /**
   * constructor for the gui view
   *
   * @param controller the controller
   */
  public GuiViewAbstract(ControllerInterface controller) {
    loader = new FXMLLoader();
    this.loader.setController(controller);
  }

  /**
   * loads the layout
   *
   * @return scene
   */
  @Override
  public Scene load() {
    // load the layout
    try {
      return this.loader.load();
    } catch (IOException exc) {
      exc.printStackTrace(System.out);
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
