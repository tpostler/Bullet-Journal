package cs3500.pa05.controller;

import com.fasterxml.jackson.databind.JsonNode;
import cs3500.pa05.view.GuiView;
import cs3500.pa05.view.GuiViewDark;
import cs3500.pa05.view.GuiViewMain;
import cs3500.pa05.view.GuiViewPassword;
import cs3500.pa05.view.GuiViewRequest;
import cs3500.pa05.view.GuiViewSplash;
import cs3500.pa05.view.GuiViewVertical;
import cs3500.pa05.view.GuiViewWeeklyStarter;
import cs3500.pa05.view.GuiViewWelcome;
import java.awt.Label;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Screen controllers, will deal with new weeks and what week is showing
 */
public class ScreenController {

  private Scene main;

  private Stage stage;

  private ControllerAbstract controller;

  /**
   * creates an instance of screen controller
   *
   * @param main  main scene that is being shown to the user
   * @param stage stage that is being shown to the user
   */
  public ScreenController(Scene main, Stage stage) {
    this.main = main;
    this.stage = stage;
  }

  /**
   * creates an instance of screen controller
   *
   * @param stage stage that is being shown
   */
  public ScreenController(Stage stage) {
    this.stage = stage;
  }

  /**
   * activates the main stage that is being shown to the user
   */
  public void activateMain() {
    stage.setScene(main);
    stage.show();
  }


  /**
   * creates a new week and loads to show user
   */
  public void newWeek() {
    //passwordScreen();
    ControllerTheme controllerTheme1 = new ControllerTheme(stage, new ArrayList<>(),
        new ArrayList<>(), new ArrayList<>());
    GuiView view = new GuiViewMain(controllerTheme1);
    this.controller = controllerTheme1;
    try {
      // load and place the view's scene onto the stage
      stage.setScene(view.load());
      controllerTheme1.run();

      stage.setTitle("Weekly Event Calender");
      // render the stage
      stage.show();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Returns the current controller.
   *
   * @return a controller.
   */
  public ControllerAbstract getController() {
    return controller;
  }

  /**
   * shows the splash screen
   */
  public void splashScreen() {
    ControllerSplash splashScreen = new ControllerSplash();
    GuiViewSplash splashView = new GuiViewSplash(splashScreen);
    try {
      stage.setScene(splashView.load());
      splashScreen.run();
      stage.setTitle("Welcome!");
      stage.show();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * displays the welcome screen
   */
  public void welcomeScreen() {
    WelcomeController controller = new WelcomeController(stage);
    GuiView view = new GuiViewWelcome(controller);
    ; // Set next screen to passwordScreen
    try {
      stage.setScene(view.load());
      controller.run();
      stage.setTitle("Weekly Event Calendar");
      stage.show();
      controller.comboBox.setOnAction(event -> passWordInput());
      controller.newWeekButton.setOnAction(event -> passwordScreen());
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Shows the password screen to the user, will allow them to login
   * to see their week view
   */
  public void passwordScreen() {
    SetupPasswordController controller = new SetupPasswordController(stage);
    GuiViewPassword view = new GuiViewPassword(controller);
    try {
      stage.setScene(view.load());
      controller.run();
      stage.setTitle("Weekly Event Calendar");
      stage.show();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Shows a weekly starter.
   */
  public void weeklyStarters() {
    ControllerWeeklyStarter weeklyStarter = new ControllerWeeklyStarter(stage);
    GuiViewWeeklyStarter guiViewWeeklyStarter = new GuiViewWeeklyStarter(weeklyStarter);
    try {
      stage.setScene(guiViewWeeklyStarter.load());
      weeklyStarter.run();
      stage.setTitle("Weekly Event Calendar");
      stage.show();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Shows the vertical starter.
   */
  public void verticalScreen() {
    ControllerVertical controllerVertical = new ControllerVertical(stage);
    GuiViewVertical verticalView = new GuiViewVertical(controllerVertical);
    try {
      stage.setScene(verticalView.load());
      controllerVertical.run();
      stage.setTitle("Weekly Event Calendar");
      stage.show();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Loads the dark screen starter.
   */
  public void darkScreen() {
    ControllerDark controllerDark = new ControllerDark(stage);
    GuiViewDark darkView = new GuiViewDark(controllerDark);
    try {
      stage.setScene(darkView.load());
      controllerDark.run();
      stage.setTitle("Weekly Event Calendar");
      stage.show();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Shows the password screen to the user, will allow them to login
   * to see their week view
   */
  public void passWordInput() {
    SetupPasswordController controller = new SetupPasswordController(stage);
    GuiViewRequest view = new GuiViewRequest(controller);

    try {
      stage.setScene(view.load());
      controller.run();
      stage.setTitle("EnterPassword");
      stage.show();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }
}


