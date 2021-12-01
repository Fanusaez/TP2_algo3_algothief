package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.gui.ConfirmBox;
import edu.fiuba.algo3.gui.layouts.MainMenuLayout;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuScene extends Scene {

    VBox layout;

    public MainMenuScene(Stage window,StartGameScene startGameScene) {
        super(new MainMenuLayout(window,startGameScene), 640,480);
    }


}
