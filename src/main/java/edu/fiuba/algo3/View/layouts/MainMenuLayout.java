package edu.fiuba.algo3.View.layouts;

import edu.fiuba.algo3.Controller.App;
import edu.fiuba.algo3.View.ImagenParaBoton;
import edu.fiuba.algo3.View.scenes.ImagenPortada;
import edu.fiuba.algo3.View.scenes.StartGameScene;
import edu.fiuba.algo3.Model.AlgoThief;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class MainMenuLayout extends VBox {


    public MainMenuLayout(Stage window, App app, AlgoThief algoThief) {

        AudioClip audioClip = new AudioClip(Paths.get("rsc/sounds/musicaDeFondo.mp3").toUri().toString());
        audioClip.setVolume(0.12);
        audioClip.setCycleCount(300);
        audioClip.play();



        this.setBackground(ImagenPortada.crearFondo("rsc/images/carmenSanDiego.png"));

        //TextField nombreUsuario = new TextField();
        //nombreUsuario.setMaxWidth(100);
        //nombreUsuario.setPromptText("Insert a name");
        // buttons
        Button buttonStart = new Button();
        buttonStart.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
        buttonStart.setGraphic(new ImagenParaBoton("rsc/images/play.png", 100, 100));
        buttonStart.setOnAction(e->{
            //algoThief.ingresarUsuario(nombreUsuario.getText());
            StartGameLayout startGameLayout = new StartGameLayout(window,app, algoThief);
            StartGameScene startGameScene = new StartGameScene(window,startGameLayout, algoThief);
            window.setScene(startGameScene);
        });

        HBox barraInicio = new HBox(buttonStart);
        barraInicio.setAlignment(Pos.CENTER);
        barraInicio.setTranslateY(400);
        getChildren().addAll(barraInicio);
    }
}
