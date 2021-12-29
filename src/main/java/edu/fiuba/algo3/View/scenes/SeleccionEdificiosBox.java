package edu.fiuba.algo3.View.scenes;

import edu.fiuba.algo3.Controller.App;
import edu.fiuba.algo3.View.ImagenParaBoton;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class SeleccionEdificiosBox {
    public static void agregarOpcionesEdificio(BorderPane caja, App app){


        Button botonEntrarABanco = new Button("banco");
        botonEntrarABanco.setGraphic(new ImagenParaBoton("rsc/images/banco.png", 80, 80));
        botonEntrarABanco.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));

        botonEntrarABanco.setOnAction(e -> {
            app.abrirEscenaEdificioBanco("rsc/images/bancofoto.jpg");

        });
        Button botonEntrarAAeropuerto = new Button();
        botonEntrarAAeropuerto.setGraphic(new ImagenParaBoton("rsc/images/aeropuerto.png", 80, 80));
        botonEntrarAAeropuerto.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
        botonEntrarAAeropuerto.setOnAction(e -> {
            app.abrirEscenaEdificioAeropuerto("rsc/images/aeropuerto.jpg");

        });
        Button botonEntrarABiblioteca = new Button();
        botonEntrarABiblioteca.setGraphic(new ImagenParaBoton("rsc/images/libros.png", 80, 80));
        botonEntrarABiblioteca.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
        botonEntrarABiblioteca.setOnAction(e -> {
            app.abrirEscenaEdificioBiblioteca("rsc/images/biblioteca.jpg");

        });

        //caja.getChildren().addAll(botonEntrarAAeropuerto, botonEntrarABanco, botonEntrarABiblioteca);
        caja.setLeft(botonEntrarAAeropuerto);
        caja.setCenter(botonEntrarABanco);
        caja.setRight(botonEntrarABiblioteca);

    }
}
