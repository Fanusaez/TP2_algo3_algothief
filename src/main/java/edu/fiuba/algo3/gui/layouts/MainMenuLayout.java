package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.ConfirmBox;
import edu.fiuba.algo3.gui.scenes.ImagenPortada;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.fakes.PoliciaFake;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainMenuLayout extends VBox {


    public MainMenuLayout(Stage window, App app, AlgoThief algoThief) {

        // Text
        //Label label = new Label("TP2 Algoritmos III - Ingeniería Informática FIUBA");
        //Text t = new Text("AlgoThief " + gameVersion);

        // Image
        this.setBackground(ImagenPortada.crearFondo("rsc/images/carmenSanDiego.png"));

        TextField nombreUsuario = new TextField();
        nombreUsuario.setPromptText("Ingrese un nombre");
        // buttons
        Button buttonStart = new Button("Comenzar juego");
        buttonStart.setOnAction(e->{
            algoThief.ingresarUsuario(nombreUsuario.getText());
            StartGameLayout startGameLayout = new StartGameLayout(window,app, algoThief);
            StartGameScene startGameScene = new StartGameScene(window,startGameLayout, algoThief);
            window.setScene(startGameScene);
        });

        Button buttonExit = new Button("Exit");
        buttonExit.setOnAction(e->{
            if(ConfirmBox.display("Are you sure?", "Exit?") == true)  window.close();
        });

        HBox barraInicio = new HBox(5, nombreUsuario,buttonStart,buttonExit);
        barraInicio.setAlignment(Pos.CENTER);
        barraInicio.setTranslateY(400);
        getChildren().addAll(barraInicio);
    }
}
