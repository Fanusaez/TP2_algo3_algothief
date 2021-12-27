package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;

public class SeleccionViajeBox {

    public static void agregarOpcionesViaje( App app, AlgoThief algoThief,BorderPane caja){

        ArrayList<Ciudad> listaOpciones = algoThief.verOpcionesDeViaje();
        Collections.shuffle(listaOpciones);
        String ciudad1 = listaOpciones.get(0).obtenerDato("city");
        String ciudad2 = listaOpciones.get(1).obtenerDato("city");
        String ciudad3 = listaOpciones.get(2).obtenerDato("city");

        Button botonViajar1 = new Button("Travel to " + ciudad1);
        botonViajar1.snapSpaceY(20);
        botonViajar1.setOnAction(e -> {
            app.viajarACiudad(0);

        });
        Button botonViajar2 = new Button("Travel to " + ciudad2);
        botonViajar2.setOnAction(e -> {
            app.viajarACiudad(1);

        });
        Button botonViajar3 = new Button("Travel to " + ciudad3);
        botonViajar3.setOnAction(e -> {
            app.viajarACiudad(2);

        });

        caja.setLeft(botonViajar1);
        caja.setCenter(botonViajar2);
        caja.setRight(botonViajar3);

    }

    public static void mostrarOpcionesViaje(App app, AlgoThief algoThief, BorderPane cajaGenerica) {

        ArrayList<Ciudad> opcionesDeViaje= algoThief.verOpcionesDeViaje();
        ListView listView = new ListView();
        Text opcion0 = new Text(opcionesDeViaje.get(0).obtenerDato("city"));
        opcion0.setFont(Font.font("Monospaced Bold", FontWeight.EXTRA_BOLD, 24));
        Text opcion1 = new Text(opcionesDeViaje.get(1).obtenerDato("city"));
        opcion1.setFont(Font.font("Monospaced Bold", FontWeight.EXTRA_BOLD, 24));
        Text opcion2 = new Text(opcionesDeViaje.get(2).obtenerDato("city"));
        opcion2.setFont(Font.font("Monospaced Bold", FontWeight.EXTRA_BOLD, 24));
        listView.getItems().add(opcion0);
        listView.getItems().add(opcion1);
        listView.getItems().add(opcion2);

        BorderStroke borderStroke =
                new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(1),
                        new BorderWidths(2)
                );
        listView.setBorder(new Border(borderStroke));
        cajaGenerica.setCenter(listView);
    }
}
