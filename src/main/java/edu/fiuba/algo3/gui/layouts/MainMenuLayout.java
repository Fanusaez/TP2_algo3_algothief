package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.gui.ConfirmBox;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuLayout extends VBox {
    public MainMenuLayout(Stage window, StartGameScene startGameScene) {

        Label label = new Label("Bienvenido a AlgoThief!");

        // buttons
        Button buttonStart = new Button("Comenzar juego");
        buttonStart.setOnAction(e->window.setScene(startGameScene));

        Button buttonExit = new Button("Exit");
        buttonExit.setOnAction(e->{
            if(ConfirmBox.display("Are you sure?", "Exit?") == true)  window.close();
        });

        getChildren().addAll(label,buttonStart,buttonExit);

    }
}
