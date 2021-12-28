package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeleccionViajeBox {

    public static void agregarOpcionesViaje( App app, AlgoThief algoThief,BorderPane caja){
        ListView listView = new ListView();
        ArrayList<Ciudad> listaOpciones = algoThief.verOpcionesDeViaje();
        Collections.shuffle(listaOpciones);
        String ciudad1 = listaOpciones.get(0).obtenerDato("city");
        String ciudad2 = listaOpciones.get(1).obtenerDato("city");
        String ciudad3 = listaOpciones.get(2).obtenerDato("city");

        DropShadow dropShadow = new DropShadow(2, 3, 3, Color.BLACK);
        BorderStroke borderStroke =
                new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(1),
                        new BorderWidths(2)
                );
        Border border = new Border(borderStroke);

        Button botonViajar1 = new Button("Travel to " + ciudad1);
        botonViajar1.setFont(Font.font("Monospaced Bold", FontWeight.EXTRA_BOLD, 14));
        botonViajar1.setEffect(dropShadow);
        botonViajar1.setBorder(border);
        botonViajar1.snapSpaceY(20);
        botonViajar1.setOnAction(e -> {
            app.viajarACiudad(0);

        });
        Button botonViajar2 = new Button("Travel to " + ciudad2);
        botonViajar2.setFont(Font.font("Monospaced Bold", FontWeight.EXTRA_BOLD, 14));
        botonViajar2.setEffect(dropShadow);
        botonViajar2.setBorder(border);
        botonViajar2.setOnAction(e -> {
            app.viajarACiudad(1);

        });
        Button botonViajar3 = new Button("Travel to " + ciudad3);
        botonViajar3.setFont(Font.font("Monospaced Bold", FontWeight.EXTRA_BOLD, 14));
        botonViajar3.setEffect(dropShadow);
        botonViajar3.setBorder(border);
        botonViajar3.setOnAction(e -> {
            app.viajarACiudad(2);

        });
        listView.getItems().addAll(botonViajar1, botonViajar2, botonViajar3);

        listView.setBorder(border);
        caja.setCenter(listView);
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
        listView.getItems().addAll(opcion0, opcion1, opcion2);

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
