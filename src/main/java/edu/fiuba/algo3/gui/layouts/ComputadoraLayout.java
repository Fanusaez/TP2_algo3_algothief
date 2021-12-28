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
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ComputadoraLayout extends VBox {
    String coincidentes ="";

    public ComputadoraLayout(Stage window, App app, AlgoThief algoThief) {

        this.setBackground(ImagenPortada.crearFondo("rsc/images/computadoraFondo.png"));
        BorderStroke borderStroke =
                new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(1),
                        new BorderWidths(4)
                );
        Border border = new Border(borderStroke);

        ListView list = app.CrearListadoDeLaComputadora();
        list.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY)));
        list.setTranslateY(30);
        list.setTranslateX(70);
        list.setMaxSize(499,170);
        list.setMinSize(499,170);


        ListView cajaParaResultados= new ListView();
        cajaParaResultados.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        Text textoSospechosos=new Text();
        textoSospechosos.setFont(Font.font("OCR A Extended", FontPosture.REGULAR, 18));
        cajaParaResultados.getItems().addAll(textoSospechosos);
        cajaParaResultados.setTranslateX(70);
        cajaParaResultados.setTranslateY(30);
        cajaParaResultados.setMaxSize(499, 130);

        VBox cajaParaLista = new VBox();
        cajaParaLista.getChildren().addAll(list);

        Button botonSalir= new Button("Back");
        botonSalir.setFont(Font.font("OCR A Extended", FontWeight.EXTRA_BOLD, 20));
        botonSalir.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        botonSalir.setOnAction(e-> {
            CiudadLayout ciudadLayout = new CiudadLayout(window, app, algoThief);
            CiudadScene ciudadScene = new CiudadScene(window, ciudadLayout, algoThief);
            window.setScene(ciudadScene);
        });

        Button botonComputar= new Button("Compute");
        botonComputar.setFont(Font.font("OCR A Extended", FontWeight.EXTRA_BOLD, 20));
        botonComputar.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        botonComputar.setOnAction(e->{
            ArrayList<String> sospechosos = algoThief.filtrarSospechosos();
            AudioClip audioClip = new AudioClip(Paths.get("rsc/sounds/busquedaComputadora.mp3").toUri().toString());
            audioClip.play();
            audioClip.setVolume(0.08);


            coincidentes ="The suspects are: ";
            if(sospechosos.size() == 1){
                coincidentes ="An arrest warrant has been generated for:";}

            coincidentes += sospechosos.stream().collect(Collectors.joining(" - "));
            coincidentes += ".";
            textoSospechosos.setText(coincidentes);
            textoSospechosos.setWrappingWidth(490);
            if(sospechosos.isEmpty()){
                textoSospechosos.setText("There's not suspects with those characteristics.");}
            });


        ToolBar botonera= new ToolBar();
        botonera.getItems().addAll(botonComputar,botonSalir);
        botonera.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        botonera.setTranslateX(60);
        botonera.setTranslateY(133);
        getChildren().addAll(cajaParaLista,cajaParaResultados,botonera);
    }

}
