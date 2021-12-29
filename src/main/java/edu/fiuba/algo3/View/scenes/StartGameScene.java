package edu.fiuba.algo3.View.scenes;

import edu.fiuba.algo3.View.layouts.StartGameLayout;
import edu.fiuba.algo3.Model.AlgoThief;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartGameScene extends Scene {

    StartGameLayout startGameLayout;

    public StartGameScene(Stage window, StartGameLayout startGameLayout, AlgoThief algoThief) {
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
