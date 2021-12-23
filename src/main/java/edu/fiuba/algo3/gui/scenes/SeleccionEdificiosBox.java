package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.ImagenParaBoton;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SeleccionEdificiosBox {
    public static void agregarOpcionesEdificio(BorderPane caja, App app){


        Button botonEntrarABanco = new Button("banco");
        botonEntrarABanco.setGraphic(new ImagenParaBoton("rsc/images/banco.png", 80, 80));
        botonEntrarABanco.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));

        botonEntrarABanco.setOnAction(e -> {
            app.abrirEscenaEdificio("rsc/images/bancofoto.jpg",0);

        });
        Button botonEntrarAAeropuerto = new Button();
        botonEntrarAAeropuerto.setGraphic(new ImagenParaBoton("rsc/images/aeropuerto.png", 80, 80));
        botonEntrarAAeropuerto.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
        botonEntrarAAeropuerto.setOnAction(e -> {
            app.abrirEscenaEdificio("rsc/images/aeropuerto.jpg",2);

        });
        Button botonEntrarABiblioteca = new Button();
        botonEntrarABiblioteca.setGraphic(new ImagenParaBoton("rsc/images/libros.png", 80, 80));
        botonEntrarABiblioteca.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
        botonEntrarABiblioteca.setOnAction(e -> {
            app.abrirEscenaEdificio("rsc/images/biblioteca.jpg",1);

        });

        //caja.getChildren().addAll(botonEntrarAAeropuerto, botonEntrarABanco, botonEntrarABiblioteca);
        caja.setLeft(botonEntrarAAeropuerto);
        caja.setCenter(botonEntrarABanco);
        caja.setRight(botonEntrarABiblioteca);

    }
}
