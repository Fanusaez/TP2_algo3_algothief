package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeleccionViajeBox {

    public static void display(String titulo, App app, AlgoThief algoThief){
        Stage windowSeleccion = new Stage();
        windowSeleccion.initModality(Modality.APPLICATION_MODAL); // block UI with other windows

        ArrayList<Ciudad> listaOpciones = algoThief.verOpcionesDeViaje();
        Collections.shuffle(listaOpciones);
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
    }
}
