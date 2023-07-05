package bulletJournal.view;


import java.io.IOException;

import bulletJournal.controller.ControllerInterface;
import bulletJournal.controller.SetupPasswordController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * gui to request the user for the password
 */
public class GuiViewRequest extends GuiViewAbstract {
  private Stage passwordSetupStage;

  //private String savedPasswor


  /**
   * constructor for the gui view
   *
   * @param controller the controller
   */
  public GuiViewRequest(ControllerInterface controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("PasswordEntry.fxml"));
    SetupPasswordController setupController = new SetupPasswordController(passwordSetupStage);
    loader.setController(setupController);
    Parent root;
    try {
      root = loader.load();
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }

    // Set the password setup scene onto the password setup stage
    Scene passwordSetupScene = new Scene(root);
    passwordSetupStage.setScene(passwordSetupScene);
    passwordSetupStage.show();


  }


}
