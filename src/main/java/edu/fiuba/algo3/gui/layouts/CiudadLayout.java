package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
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

        BorderPane ladoIzquierdo= new BorderPane();
        BorderPane ladoDerecho= new BorderPane();

        Text labelHorario = new Text(algoThief.ciudadActual() + "\n" + algoThief.obtenerHorario());
        labelHorario.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

        //Text estadoJuego=new Text(algoThief.estadoJuegoComoString());

        HBox boxHorario = new HBox();
        boxHorario.getChildren().addAll(labelHorario);

        Text textoInfoCiudad =new Text(algoThief.obtenerInformacionCiudad());
        textoInfoCiudad.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        textoInfoCiudad.setFill(Color.WHITE);
        VBox descripcionCiudad= new DescripcionCiudad(textoInfoCiudad);
        descripcionCiudad.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        //Opciones de edicifico
        ImageView viewLupa = new ImagenParaBoton("rsc/images/lupa.png");
        Button botonVisitar = new Button();
        botonVisitar.setGraphic(viewLupa);
        botonVisitar.setOnAction(i -> {
            SeleccionEdificiosBox.display("Choce building", app);
        });

        //Opciones de viaje
        ImageView viewAvion = new ImagenParaBoton("rsc/images/avion.png");
        Button botonViajar = new Button();
        botonViajar.setGraphic(viewAvion);
        botonViajar.setOnAction(i -> {
            SeleccionViajeBox.display("unTitulo", app, algoThief);
        });

        //Computar
        ImageView viewComputadora = new ImagenParaBoton("rsc/images/computadora.png");
        Button botonComputadora = new Button();
        botonComputadora.setGraphic(viewComputadora);
        botonComputadora.setOnAction(e -> {
            app.abrirLaComputadora();
        });

        //Ver Opciones de Viaje
        ImageView viewOpciones = new ImagenParaBoton("rsc/images/opciones.png");
        Button botonOpciones = new Button();
        botonOpciones.setGraphic(viewOpciones);


        //Ordenar Layout
        HBox barraAcciones = new HBox(5, botonOpciones, botonViajar, botonVisitar, botonComputadora);
        ladoDerecho.setBottom(barraAcciones);
        ladoDerecho.setCenter(descripcionCiudad);

        ladoIzquierdo.setTop(boxHorario);

        //FileInputStream fileInputStream = null;
        //try {
        //    fileInputStream = new FileInputStream("rsc/images/opciones.png");
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}
        //Image img = new Image(fileInputStream);
        //ImageView view = new ImageView(img);
        //view.setImage(img);
        VBox imagenCiudad = new VBox();
        imagenCiudad.setMinSize(320, 400);
        imagenCiudad.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        ladoIzquierdo.setCenter(imagenCiudad);

        this.setLeft(ladoIzquierdo);
        this.setRight(ladoDerecho);
    }
}