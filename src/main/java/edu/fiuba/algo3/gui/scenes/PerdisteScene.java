package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.gui.layouts.CiudadLayout;
import edu.fiuba.algo3.gui.layouts.PerdisteLayout;
import edu.fiuba.algo3.gui.layouts.ViajeLayout;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PerdisteScene extends Scene {

    public PerdisteScene(Stage window, PerdisteLayout unPerdisteLayout, AlgoThief algoThief) {
        super(unPerdisteLayout,640,480);

    }
}
