package edu.fiuba.algo3.View.scenes;

import edu.fiuba.algo3.View.layouts.FinDeJuegoLayout;
import edu.fiuba.algo3.Model.AlgoThief;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FinDeJuegoScene extends Scene {

    public FinDeJuegoScene(Stage window, FinDeJuegoLayout unFinDeJuegoLayout, AlgoThief algoThief) {
        super(unFinDeJuegoLayout,640,480);

    }
}
