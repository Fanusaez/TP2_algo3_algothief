package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.BarraAcciones;
import edu.fiuba.algo3.gui.DescripcionCiudad;
import edu.fiuba.algo3.gui.ImagenParaBoton;
import edu.fiuba.algo3.gui.scenes.SeleccionEdificiosBox;
import edu.fiuba.algo3.gui.scenes.SeleccionViajeBox;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CiudadLayout extends BorderPane {
    public CiudadLayout(Stage window, App app, AlgoThief algoThief){
        //Detalles
        DropShadow dropShadow1 = new DropShadow(1, 3, 3, Color.web("#333333"));
        BorderStroke borderStroke =
                new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(1),
                        new BorderWidths(3)
                );
        Border border = new Border(borderStroke);

        BorderPane ladoIzquierdo= new BorderPane();
        BorderPane ladoDerecho= new BorderPane();

        BorderPane cajaGenerica = new BorderPane();
        cajaGenerica.setEffect(dropShadow1);
        cajaGenerica.setBorder(border);
        cajaGenerica.setStyle("-fx-background-radius: 6;" +
                "-fx-background-color: rgb(45, 45, 50), rgb(60, 60, 65);" +
                "-fx-background-insets: 0, 0 1 1 0;");
        cajaGenerica.setMaxSize(300,140);
        cajaGenerica.setVisible(false);
        ladoDerecho.setCenter(cajaGenerica);

        Text labelHorario = new Text(algoThief.ciudadActual() + "\n" + algoThief.obtenerHorario());
        labelHorario.setFont(Font.font("Monospaced Bold", FontWeight.EXTRA_BOLD, 20));

        BorderPane boxHorario = new BorderPane();
        boxHorario.setBorder(border);
        boxHorario.setCenter(labelHorario);

        Text textoInfoCiudad =new Text(algoThief.obtenerInformacionCiudad());

        textoInfoCiudad.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            textoInfoCiudad.setFill(Color.BLACK);
        VBox descripcionCiudad= new DescripcionCiudad(textoInfoCiudad);
        descripcionCiudad.setMinSize(0,250);

        //Opciones de edicifico
        Button botonVisitar = new Button();
        botonVisitar.setOnAction(i -> {
            cajaGenerica.getChildren().clear();
            SeleccionEdificiosBox.agregarOpcionesEdificio(cajaGenerica,app);
            cajaGenerica.setVisible(!cajaGenerica.isVisible());
        });

        //Opciones de viaje
        Button botonViajar = new Button();
        botonViajar.setOnAction(i -> {
            cajaGenerica.getChildren().clear();
            SeleccionViajeBox.agregarOpcionesViaje(app,algoThief,cajaGenerica);
            cajaGenerica.setVisible(!cajaGenerica.isVisible());
        });

        //Computar
        Button botonComputadora = new Button();
        botonComputadora.setOnAction(e -> {
            app.abrirLaComputadora();
        });

        //Ver Opciones de Viaje
        Button botonOpciones = new Button();


        //Ordenar Layout
        BarraAcciones barraAcciones = new BarraAcciones(botonOpciones, botonViajar, botonVisitar, botonComputadora);
        ladoDerecho.setBottom(barraAcciones);
        ladoDerecho.setTop(descripcionCiudad);



        VBox imagenCiudad = new VBox();
        imagenCiudad.setMinSize(300, 400);
        imagenCiudad.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, new Insets(5))));

        ladoIzquierdo.setTop(boxHorario);
        ladoIzquierdo.setBottom(imagenCiudad);

        this.setLeft(ladoIzquierdo);
        this.setRight(ladoDerecho);
    }
}