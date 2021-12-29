package edu.fiuba.algo3.View.scenes;

import edu.fiuba.algo3.View.layouts.EdificioLayout;
import edu.fiuba.algo3.Model.AlgoThief;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EdificioScene extends Scene {

    EdificioLayout edificioLayout;

    public EdificioScene(Stage window, EdificioLayout edificioLayout, AlgoThief algoThief) {
        super(edificioLayout,640,480);

        this.edificioLayout = edificioLayout;
    }

    public EdificioLayout getEdificioLayout() {
        return edificioLayout;
    }

    public void setEdificioLayout(EdificioLayout edificioLayout) {
        this.edificioLayout = edificioLayout;
    }
}