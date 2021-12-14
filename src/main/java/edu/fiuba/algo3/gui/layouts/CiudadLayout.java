package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.ConfirmBox;
import edu.fiuba.algo3.gui.scenes.EdificioScene;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import edu.fiuba.algo3.gui.scenes.ViajeScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Ciudad;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.geometry.Insets;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CiudadLayout extends VBox {
    public CiudadLayout(Stage window, App app, AlgoThief algoThief) {

        Label labelHorario= new Label("Horario: "+ algoThief.obtenerHorario());
        Label ciudadActual= new Label("Ubicacion actual: "+ algoThief.ciudadActual());


        //Opciones de edicifico
        Button botonEntrarAEdificios= new Button("Entrar a Banco");
        botonEntrarAEdificios.setOnAction(e->{
            EdificioLayout viajeLayout = new EdificioLayout(window,app, algoThief,"rsc\\images\\bancofoto.jpg",algoThief.entrarAEdificio(0));
            EdificioScene viajeScene = new EdificioScene(window,viajeLayout, algoThief);
            window.setScene(viajeScene);
        });





        //Opciones de viaje
        ArrayList<Ciudad> listaOpciones =algoThief.verOpcionesDeViaje();
        String ciudad1 = listaOpciones.get(0).obtenerDato("city");
        String ciudad2 = listaOpciones.get(1).obtenerDato("city");
        String ciudad3 = listaOpciones.get(2).obtenerDato("city");
        Button botonViajar1= new Button("Viajar a "+ciudad1);
        botonViajar1.setOnAction(e->{
            ViajeLayout viajeLayout = new ViajeLayout(window,app, algoThief);
            ViajeScene viajeScene = new ViajeScene(window,viajeLayout, algoThief);
            window.setScene(viajeScene);
            algoThief.viajar(algoThief.verOpcionesDeViaje().get(0));
        });
        Button botonViajar2= new Button("Viajar a "+ciudad2);
        botonViajar2.setOnAction(e->{
            ViajeLayout viajeLayout = new ViajeLayout(window,app, algoThief);
            ViajeScene viajeScene = new ViajeScene(window,viajeLayout, algoThief);
            window.setScene(viajeScene);
            algoThief.viajar(algoThief.verOpcionesDeViaje().get(1));
        });
        Button botonViajar3= new Button("Viajar a "+ciudad3);
        botonViajar3.setOnAction(e->{
            ViajeLayout viajeLayout = new ViajeLayout(window,app, algoThief);
            ViajeScene viajeScene = new ViajeScene(window,viajeLayout, algoThief);
            window.setScene(viajeScene);
            algoThief.viajar(algoThief.verOpcionesDeViaje().get(2));
        });

        VBox cajaViajes=new VBox(botonViajar1,botonViajar2,botonViajar3);
        cajaViajes.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        cajaViajes.setStyle("-fx-background-color: " + Color.RED.toString().replace("0x", "#") + ";");
        cajaViajes.setPadding(new Insets(12, 12, 12, 12));
        getChildren().addAll(labelHorario,ciudadActual,cajaViajes,botonEntrarAEdificios);


    }
}
