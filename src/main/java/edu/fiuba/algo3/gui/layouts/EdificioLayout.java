package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.scenes.CiudadScene;
import edu.fiuba.algo3.gui.scenes.ImagenPortada;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

import static java.awt.Color.BLACK;


public class EdificioLayout extends VBox {
    public EdificioLayout(Stage window, App app, AlgoThief algoThief,String ubicacionArchivo, String pista) {

        Text pistaLabel = new Text(pista);
        pistaLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        VBox cajapista = new VBox();
        cajapista.getChildren().addAll(pistaLabel);
        cajapista.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        cajapista.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        BorderPane cajaInferior=new BorderPane();
        setBackground(ImagenPortada.crearFondo(ubicacionArchivo));
        cajaInferior.setBackground(ImagenPortada.crearFondo("rsc/images/computadoraFondo.png"));


        Button botonSalir= new Button("Volver");
        botonSalir.setMinSize(40,40);
        botonSalir.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        botonSalir.setOnAction(e-> {
            CiudadLayout ciudadLayout = new CiudadLayout(window, app, algoThief);
            CiudadScene ciudadScene = new CiudadScene(window, ciudadLayout, algoThief);
            window.setScene(ciudadScene);
        });

        HBox cerrar = new HBox(botonSalir);
        //setBackground(new Background(new BackgroundImage()));
        cerrar.setLayoutX(200);
        getChildren().addAll(cerrar,cajapista,cajaInferior);
    }
}
