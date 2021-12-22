package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.App;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SeleccionEdificiosBox {
    public static void agregarOpcionesEdificio(VBox caja, App app){


        Button botonEntrarABanco = new Button("Entrar a Banco");
        botonEntrarABanco.setOnAction(e -> {
            app.abrirEscenaEdificio("rsc/images/bancofoto.jpg",0);

        });
        Button botonEntrarAAeropuerto = new Button("Entrar a Aeropuerto");
        botonEntrarAAeropuerto.setOnAction(e -> {
            app.abrirEscenaEdificio("rsc/images/aeropuerto.jpg",2);

        });
        Button botonEntrarABiblioteca = new Button("Entrar a Biblioteca");
        botonEntrarABiblioteca.setOnAction(e -> {
            app.abrirEscenaEdificio("rsc/images/biblioteca.jpg",1);

        });

        caja.getChildren().addAll(botonEntrarAAeropuerto, botonEntrarABanco, botonEntrarABiblioteca);

    }
}
