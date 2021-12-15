package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.scenes.BorderPaneScene;
import edu.fiuba.algo3.gui.scenes.CiudadScene;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class StartGameLayout extends VBox {

    private Label labelVariable;

    public StartGameLayout(Stage window, App app, AlgoThief algoThief) {
        //setBackground(new BackgroundFill(Color.GRAY));
        Text presentacion = new Text(algoThief.desplegarTextoInicial());
        presentacion.setFont(Font.font("Verdana", FontPosture.ITALIC, 16));
        BorderPane panePresentacion = new BorderPane();
        panePresentacion.setCenter(presentacion);


        Button buttonContinuar = new Button("Continuar");
        buttonContinuar.setOnAction(e->{
            CiudadLayout ciudadLayout = new CiudadLayout(window,app, algoThief);
            CiudadScene ciudadScene = new CiudadScene(window,ciudadLayout, algoThief);
            window.setScene(ciudadScene);

        });

        getChildren().addAll(panePresentacion,buttonContinuar);

    }
}
