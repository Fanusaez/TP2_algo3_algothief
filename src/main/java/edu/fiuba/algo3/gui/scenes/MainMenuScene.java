package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.ConfirmBox;
import edu.fiuba.algo3.gui.layouts.MainMenuLayout;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuScene extends Scene {

    public MainMenuScene(Stage window, App app, AlgoThief algoThief) {
        super(new MainMenuLayout(window,app,algoThief), 640,480);
    }


}
