package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.scenes.EdificioScene;
import edu.fiuba.algo3.gui.scenes.ViajeScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.geometry.Insets;

import java.util.ArrayList;

public class CiudadLayout extends BorderPane {
    public CiudadLayout(Stage window, App app, AlgoThief algoThief) {

        Text labelHorario = new Text("Horario: " + algoThief.obtenerHorario());
        labelHorario.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        Text ciudadActual = new Text("Ubicacion actual: " + algoThief.ciudadActual());
        ciudadActual.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        Text estadoJuego=new Text(algoThief.estadoJuego);
        VBox inicio = new VBox();
        inicio.getChildren().addAll(estadoJuego,labelHorario,ciudadActual);
        inicio.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        ToolBar toolBarMadre = new ToolBar();

        //Opciones de edicifico
        ToolBar toolBarEdificios = new ToolBar();


        Button botonEntrarABanco = new Button("Entrar a Banco");
        botonEntrarABanco.setOnAction(e -> {
            app.abrirEscenaEdificio("rsc\\images\\bancofoto.jpg");
        });
        Button botonEntrarAAeropuerto = new Button("Entrar a Aeropuerto");
        botonEntrarAAeropuerto.setOnAction(e -> {
            app.abrirEscenaEdificio("rsc\\images\\aeropuerto.jpg");
        });
        Button botonEntrarABiblioteca = new Button("Entrar a Biblioteca");
        botonEntrarABiblioteca.setOnAction(e -> {
            app.abrirEscenaEdificio("rsc\\images\\biblioteca.jpg");
        });



        toolBarEdificios.getItems().add(botonEntrarAAeropuerto);
        toolBarEdificios.getItems().add(new Separator());
        toolBarEdificios.getItems().add(botonEntrarABanco);
        toolBarEdificios.getItems().add(new Separator());
        toolBarEdificios.getItems().add(botonEntrarABiblioteca);

        //Opciones de viaje
        ToolBar toolBarViaje = new ToolBar();
        ArrayList<Ciudad> listaOpciones = algoThief.verOpcionesDeViaje();
        String ciudad1 = listaOpciones.get(0).obtenerDato("city");
        String ciudad2 = listaOpciones.get(1).obtenerDato("city");
        String ciudad3 = listaOpciones.get(2).obtenerDato("city");
        Button botonViajar1 = new Button("Viajar a " + ciudad1);
        botonViajar1.setOnAction(e -> {
            ViajeLayout viajeLayout = new ViajeLayout(window, app, algoThief);
            ViajeScene viajeScene = new ViajeScene(window, viajeLayout, algoThief);
            window.setScene(viajeScene);
            algoThief.viajar(algoThief.verOpcionesDeViaje().get(0));
        });
        Button botonViajar2 = new Button("Viajar a " + ciudad2);
        botonViajar2.setOnAction(e -> {
            ViajeLayout viajeLayout = new ViajeLayout(window, app, algoThief);
            ViajeScene viajeScene = new ViajeScene(window, viajeLayout, algoThief);
            window.setScene(viajeScene);
            algoThief.viajar(algoThief.verOpcionesDeViaje().get(1));
        });
        Button botonViajar3 = new Button("Viajar a " + ciudad3);
        botonViajar3.setOnAction(e -> {
            ViajeLayout viajeLayout = new ViajeLayout(window, app, algoThief);
            ViajeScene viajeScene = new ViajeScene(window, viajeLayout, algoThief);
            window.setScene(viajeScene);
            algoThief.viajar(algoThief.verOpcionesDeViaje().get(2));
        });
        toolBarViaje.getItems().add(botonViajar1);
        toolBarViaje.getItems().add(new Separator());
        toolBarViaje.getItems().add(botonViajar2);
        toolBarViaje.getItems().add(new Separator());
        toolBarViaje.getItems().add(botonViajar3);


        toolBarViaje.setOrientation(Orientation.VERTICAL);
        toolBarEdificios.setOrientation(Orientation.VERTICAL);
        toolBarMadre.getItems().add(toolBarViaje);
        toolBarMadre.getItems().add(new Separator());
        toolBarMadre.getItems().add(toolBarEdificios);

        this.setTop(inicio);
        this.setBottom(toolBarMadre);
        this.setAlignment(toolBarMadre,Pos.BOTTOM_RIGHT);


    }
}