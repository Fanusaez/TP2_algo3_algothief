package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.gui.ConfirmBox;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartGameLayout extends VBox {
    public StartGameLayout() {

        Label label = new Label("Juego!!!");

        getChildren().addAll(label);

    }
}
