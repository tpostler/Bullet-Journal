package cs3500.pa05;

import cs3500.pa05.controller.ScreenController;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Entry point for the exam
 */
public class Driver extends Application {

  /**
   * @param stage the primary stage for this application, onto which
   *              the application scene can be set.
   *              Applications may create other stages, if needed, but they will not be
   *              primary stages.
   */
  @Override
  public void start(Stage stage) {
    ScreenController controller = new ScreenController(stage);
    controller.splashScreen();
    PauseTransition pause = new PauseTransition(Duration.seconds(1));
    pause.setOnFinished(event ->
        controller.welcomeScreen()
    );
    pause.play();
  }


  /**
   * entry point of the program
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    launch();
  }
}
