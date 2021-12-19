package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.App;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SeleccionEdificiosBox {
    public static void display(String titulo, App app){

        Stage windowSeleccion = new Stage();
        windowSeleccion.initModality(Modality.APPLICATION_MODAL); // block UI with other windows
        windowSeleccion.setTitle(titulo);
        // windowSeleccion.setMinWidth(500);

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
        layout.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.getChildren().addAll(botonEntrarAAeropuerto, botonEntrarABanco, botonEntrarABiblioteca);

        Scene scene = new Scene(layout);

        windowSeleccion.setScene(scene);
        windowSeleccion.showAndWait();
    }
}