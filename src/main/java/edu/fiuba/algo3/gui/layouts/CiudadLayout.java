package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.scenes.EdificioScene;
import edu.fiuba.algo3.gui.scenes.ViajeScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.text.Element;
import javax.tools.Tool;
import java.awt.*;
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
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("rsc/images/lupa.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image img = new Image(fileInputStream);
        ImageView view = new ImageView(img);
        view.setFitHeight(40);
        view.setFitWidth(40);
        Button botonVisitar = new Button();
        botonVisitar.setGraphic(view);
        botonVisitar.setOnAction(i -> {
            Stage windowSeleccion = new Stage();

            Button botonEntrarABanco = new Button("Entrar a Banco");
            botonEntrarABanco.setOnAction(e -> {
                app.abrirEscenaEdificio("rsc/images/bancofoto.jpg",0);
                windowSeleccion.close();
            });
            Button botonEntrarAAeropuerto = new Button("Entrar a Biblioteca");
            botonEntrarAAeropuerto.setOnAction(e -> {
                app.abrirEscenaEdificio("rsc/images/aeropuerto.jpg",1);
                windowSeleccion.close();
            });
            Button botonEntrarABiblioteca = new Button("Entrar a Aeropuerto");
            botonEntrarABiblioteca.setOnAction(e -> {
                app.abrirEscenaEdificio("rsc/images/biblioteca.jpg",2);
                windowSeleccion.close();
            });

            VBox layout = new VBox(10);
            layout.getChildren().addAll(botonEntrarAAeropuerto, botonEntrarABanco, botonEntrarABiblioteca);

            Scene scene = new Scene(layout);

            windowSeleccion.setScene(scene);
            windowSeleccion.showAndWait();
        });

        //Opciones de viaje
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream("rsc/images/avion.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image img1 = new Image(fileInputStream1);
        ImageView view1 = new ImageView(img1);
        view1.setFitHeight(40);
        view1.setFitWidth(40);
        Button botonViajar = new Button();
        botonViajar.setGraphic(view1);
        botonViajar.setOnAction(i -> {
            Stage windowSeleccion = new Stage();

            ArrayList<Ciudad> listaOpciones = algoThief.verOpcionesDeViaje();
            String ciudad1 = listaOpciones.get(0).obtenerDato("city");
            String ciudad2 = listaOpciones.get(1).obtenerDato("city");
            String ciudad3 = listaOpciones.get(2).obtenerDato("city");

            Button botonViajar1 = new Button("Viajar a " + ciudad1);
            botonViajar1.setOnAction(e -> {
                app.viajarACiudad(0);
                windowSeleccion.close();
            });
            Button botonViajar2 = new Button("Viajar a " + ciudad2);
            botonViajar2.setOnAction(e -> {
                app.viajarACiudad(1);
                windowSeleccion.close();
            });
            Button botonViajar3 = new Button("Viajar a " + ciudad3);
            botonViajar3.setOnAction(e -> {
                app.viajarACiudad(2);
                windowSeleccion.close();
            });

            VBox layout = new VBox(10);
            layout.getChildren().addAll(botonViajar1, botonViajar2, botonViajar3);

            Scene scene = new Scene(layout);

            windowSeleccion.setScene(scene);
            windowSeleccion.showAndWait();
        });

        //Computar
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream("rsc/images/computadora.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image img2 = new Image(fileInputStream2);
        ImageView view2 = new ImageView(img2);
        view2.setFitHeight(40);
        view2.setFitWidth(40);
        Button botonComputadora = new Button();
        botonComputadora.setGraphic(view2);
        botonComputadora.setOnAction(e -> {
            app.abrirLaComputadora();
        });

        toolBarMadre.getItems().addAll(botonViajar, botonVisitar, botonComputadora);
        //botonComputadora.setTranslateX(160);

        this.setTop(inicio);
        this.setBottom(toolBarMadre);


    }
}