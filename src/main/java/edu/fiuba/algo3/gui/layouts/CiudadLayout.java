package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.ImagenParaBoton;
import edu.fiuba.algo3.gui.scenes.SeleccionEdificiosBox;
import edu.fiuba.algo3.gui.scenes.SeleccionViajeBox;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CiudadLayout extends BorderPane {
    public CiudadLayout(Stage window, App app, AlgoThief algoThief){

        this.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        Text labelHorario = new Text("Horario: " + algoThief.obtenerHorario());
        labelHorario.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        Text ciudadActual = new Text("Ubicacion actual: " + algoThief.ciudadActual());
        ciudadActual.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        Text estadoJuego=new Text(algoThief.estadoJuegoComoString());
        BorderPane borderhorario = new BorderPane();
        BorderPane borderciudadActual = new BorderPane();
        borderhorario.setCenter(labelHorario);
        borderciudadActual.setCenter(ciudadActual);
        VBox inicio= new VBox();
        inicio.getChildren().addAll(borderhorario,borderciudadActual,estadoJuego);
        inicio.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        ToolBar toolBarMadre = new ToolBar();

        //Opciones de edicifico

        ImageView viewLupa = new ImagenParaBoton("rsc/images/lupa.png");
        Button botonVisitar = new Button();
        botonVisitar.setGraphic(viewLupa);
        botonVisitar.setOnAction(i -> {
            SeleccionEdificiosBox.display("Choce building", app);
        });

        //Opciones de viaje

        ImageView viewAvion = new ImagenParaBoton("rsc/images/avion.png");
        Button botonViajar = new Button();
        botonViajar.setGraphic(viewAvion);
        botonViajar.setOnAction(i -> {
            SeleccionViajeBox.display("unTitulo", app, algoThief);
        });

        //Computar
        ImageView viewComputadora = new ImagenParaBoton("rsc/images/computadora.png");
        Button botonComputadora = new Button();
        botonComputadora.setGraphic(viewComputadora);
        botonComputadora.setOnAction(e -> {
            app.abrirLaComputadora();
        });

        toolBarMadre.getItems().addAll(botonViajar, botonVisitar, botonComputadora);
        //botonComputadora.setTranslateX(160);

        this.setTop(inicio);
        this.setBottom(toolBarMadre);


    }
}