package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
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

        ArrayList<Ciudad> listaOpciones = algoThief.verOpcionesDeViaje();
        Collections.shuffle(listaOpciones);
        String ciudad1 = listaOpciones.get(0).obtenerDato("city");
        String ciudad2 = listaOpciones.get(1).obtenerDato("city");
        String ciudad3 = listaOpciones.get(2).obtenerDato("city");

        Button botonViajar1 = new Button( ciudad1);
        botonViajar1.setMinSize(80,60);
        botonViajar1.setOnAction(e -> {
            app.viajarACiudad(0);


        });
        Button botonViajar2 = new Button( ciudad2);
        botonViajar2.setMinSize(80,60);
        botonViajar2.setOnAction(e -> {
            app.viajarACiudad(1);

        });
        Button botonViajar3 = new Button(ciudad3);
        botonViajar3.setMinSize(80,60);
        botonViajar3.setOnAction(e -> {
            app.viajarACiudad(2);

        });
        ToolBar barraOpciones = new ToolBar();
        barraOpciones.setPadding(new Insets(20,20,20,20));
        barraOpciones.getItems().addAll(botonViajar1,botonViajar2,botonViajar3);
        barraOpciones.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));

        Text viajarAtexto = new Text("Travel to:");
        viajarAtexto.setFill(Color.WHITE);
        viajarAtexto.setFont(Font.font("Verdana", FontWeight.BOLD, 20));


        caja.setTop(viajarAtexto);
        caja.setCenter(barraOpciones);

    }
}
