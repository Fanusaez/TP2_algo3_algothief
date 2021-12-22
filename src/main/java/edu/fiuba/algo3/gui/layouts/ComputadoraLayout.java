package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.scenes.CiudadScene;
import edu.fiuba.algo3.gui.scenes.ImagenPortada;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ComputadoraLayout extends VBox {
    String sospechosos="";

    public ComputadoraLayout(Stage window, App app, AlgoThief algoThief) {

        this.setBackground(ImagenPortada.crearFondo("rsc/images/computadoraFondo.png"));


        ListView list = app.CrearListadoDeLaComputadora();
        list.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY)));
        list.setTranslateY(30);
        list.setTranslateX(70);
        list.setMaxSize(499,160);
        list.setMinSize(499,160);


        VBox cajaParaResultados= new VBox();
        cajaParaResultados.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        Text textoSospechosos=new Text();
        textoSospechosos.setFont(Font.font("Verdana", FontPosture.REGULAR, 20));
        cajaParaResultados.getChildren().addAll(textoSospechosos);
        cajaParaResultados.setTranslateX(70);
        cajaParaResultados.setTranslateY(30);
        cajaParaResultados.setMinSize(499,143);
        cajaParaResultados.setMaxSize(499,143);



        VBox cajaParaLista = new VBox();
        cajaParaLista.getChildren().addAll(list);

        Button botonSalir= new Button("Volver");
        botonSalir.setMinSize(20,20);
        botonSalir.setTranslateY(0);
        botonSalir.setTranslateX(0);
        botonSalir.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        botonSalir.setOnAction(e-> {
            CiudadLayout ciudadLayout = new CiudadLayout(window, app, algoThief);
            CiudadScene ciudadScene = new CiudadScene(window, ciudadLayout, algoThief);
            window.setScene(ciudadScene);
        });

        Button botonComputar= new Button("Computar");

        botonComputar.setOnAction(e->{
            sospechosos="Los sospechosos son: ";
            sospechosos+=algoThief.filtrarSospechosos().stream().collect(Collectors.joining(", "));
            sospechosos+=".";
            textoSospechosos.setText(sospechosos);
            textoSospechosos.setWrappingWidth(490);
            if(algoThief.filtrarSospechosos().isEmpty()){
                textoSospechosos.setText("No hay sospechosos con esas caracteristicas.");}
            });


        ToolBar botonera= new ToolBar();
        botonera.getItems().addAll(botonComputar,botonSalir);
        botonera.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        botonera.setTranslateX(60);
        botonera.setTranslateY(133);
        getChildren().addAll(cajaParaLista,cajaParaResultados,botonera);
    }

}
