package edu.fiuba.algo3.View.scenes;

import edu.fiuba.algo3.Controller.App;
import edu.fiuba.algo3.View.layouts.MainMenuLayout;
import edu.fiuba.algo3.Model.AlgoThief;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuScene extends Scene {

    public MainMenuScene(Stage window, App app, AlgoThief algoThief) {
        super(new MainMenuLayout(window,app,algoThief), 640,480);
    }


}
