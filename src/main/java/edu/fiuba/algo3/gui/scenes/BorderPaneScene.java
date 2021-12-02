package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.gui.layouts.BorderPaneLayout;
import edu.fiuba.algo3.gui.layouts.MainMenuLayout;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BorderPaneScene extends Scene {

    public BorderPaneScene(Stage window) {
        super(new BorderPaneLayout(window), 640,480);
    }
}
