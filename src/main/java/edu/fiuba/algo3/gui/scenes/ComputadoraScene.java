
package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.gui.layouts.ComputadoraLayout;
import edu.fiuba.algo3.gui.layouts.PerdisteLayout;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComputadoraScene extends Scene {

    public ComputadoraScene(Stage window, ComputadoraLayout unComputadoraLayout, AlgoThief algoThief) {
        super(unComputadoraLayout,640,480);

    }
}
