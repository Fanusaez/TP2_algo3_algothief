package edu.fiuba.algo3;

import edu.fiuba.algo3.gui.scenes.MainMenuScene;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    Stage window;

    @Override
    public void start(Stage stage) {
        window = stage;
        MainMenuScene mainMenu = new MainMenuScene(window,new StartGameScene(window));
        window.setScene(mainMenu);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }

}