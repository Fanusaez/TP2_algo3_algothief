
package edu.fiuba.algo3.View.scenes;

import edu.fiuba.algo3.View.layouts.ComputadoraLayout;
import edu.fiuba.algo3.Model.AlgoThief;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComputadoraScene extends Scene {

    public ComputadoraScene(Stage window, ComputadoraLayout unComputadoraLayout, AlgoThief algoThief) {
        super(unComputadoraLayout,640,480);

    }
}
