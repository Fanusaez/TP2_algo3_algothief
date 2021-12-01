package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.gui.layouts.StartGameLayout;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartGameScene extends Scene {

    public StartGameScene(Stage window) {
        super(new StartGameLayout(window),640,480);
    }
}
