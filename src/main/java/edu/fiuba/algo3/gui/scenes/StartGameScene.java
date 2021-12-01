package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.gui.layouts.StartGameLayout;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartGameScene extends Scene {

    StartGameLayout startGameLayout;

    public StartGameScene(Stage window, StartGameLayout startGameLayout) {
        super(startGameLayout,640,480);
        this.startGameLayout = startGameLayout;
    }

    public StartGameLayout getStartGameLayout() {
        return startGameLayout;
    }

    public void setStartGameLayout(StartGameLayout startGameLayout) {
        this.startGameLayout = startGameLayout;
    }
}
