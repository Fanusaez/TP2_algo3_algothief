package edu.fiuba.algo3.View.layouts;

import edu.fiuba.algo3.Controller.App;
import edu.fiuba.algo3.View.scenes.CiudadScene;
import edu.fiuba.algo3.View.scenes.ImagenPortada;
import edu.fiuba.algo3.Model.AlgoThief;
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
    AlgoThief algoThief;
    App AppController;

    public ComputadoraLayout(Stage window, App app, AlgoThief algoThief) {

        this.algoThief = algoThief;
        this.AppController = app;

        this.setBackground(ImagenPortada.crearFondo("rsc/images/computadoraFondo.png"));
        BorderStroke borderStroke =
                new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(1),
                        new BorderWidths(4)
                );
        Border border = new Border(borderStroke);

        ListView list = CrearListadoDeLaComputadora();
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





    public ListView CrearListadoDeLaComputadora() { //se podria crear una clase a parte
        BorderStroke borderStroke =
                new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(1),
                        new BorderWidths(2)
                );
        Border border = new Border(borderStroke);
        Font fuente = Font.font("OCR A Extended", FontWeight.EXTRA_BOLD, 12);
        Background fondoTransparente = new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY));

        //Sex
        Button botonSiguienteSex = new Button("➜");
        botonSiguienteSex.setBorder(border);
        botonSiguienteSex.setFont(fuente);
        botonSiguienteSex.setBackground(fondoTransparente);
        botonSiguienteSex.setOnAction(e->{
            algoThief.siguienteSex();
            AppController.abrirLaComputadora();
        });
        Text textosex = new Text("Sex" + " : " + algoThief.getSexoSeleccionado());
        textosex.setFont(fuente);
        BorderPane cajaHorizontalsex= new BorderPane();
        cajaHorizontalsex.setLeft(textosex);
        cajaHorizontalsex.setRight(botonSiguienteSex);

        //Hobby
        Button botonSiguienteHobby = new Button("➜");
        botonSiguienteHobby.setBorder(border);
        botonSiguienteHobby.setFont(fuente);
        botonSiguienteHobby.setBackground(fondoTransparente);
        botonSiguienteHobby.setOnAction(e->{
            algoThief.siguienteHobby();
            AppController.abrirLaComputadora();
        });
        Text textohobby = new Text("Hobby"+" : " + algoThief.getHobbySeleccionado());
        textohobby.setFont(fuente);
        BorderPane cajaHorizontalHobby= new BorderPane();
        cajaHorizontalHobby.setLeft(textohobby);
        cajaHorizontalHobby.setRight(botonSiguienteHobby);

        //Pelo
        Button botonSiguientePelo = new Button("➜");
        botonSiguientePelo.setBorder(border);
        botonSiguientePelo.setFont(fuente);
        botonSiguientePelo.setBackground(fondoTransparente);
        botonSiguientePelo.setOnAction(e->{
            algoThief.siguientePelo();
            AppController.abrirLaComputadora();
        });
        Text textopelo = new Text("Hair" + " : " + algoThief.getHairSeleccionado());
        textopelo.setFont(fuente);
        BorderPane cajaHorizontalPelo= new BorderPane();
        cajaHorizontalPelo.setLeft(textopelo);
        cajaHorizontalPelo.setRight(botonSiguientePelo);

        //feature
        Button botonSiguienteFeature = new Button("➜");
        botonSiguienteFeature.setBorder(border);
        botonSiguienteFeature.setBackground(fondoTransparente);
        botonSiguienteFeature.setOnAction(e->{
            algoThief.siguienteFeature();
            AppController.abrirLaComputadora();
        });
        Text textfeature = new Text("Feature" + " : " + algoThief.getFeatureSeleccionado());
        textfeature.setFont(fuente);
        BorderPane cajaHorizontalFeature= new BorderPane();
        cajaHorizontalFeature.setLeft(textfeature);
        cajaHorizontalFeature.setRight(botonSiguienteFeature);

        //auto
        Button botonSiguienteAuto= new Button("➜");
        botonSiguienteAuto.setBorder(border);
        botonSiguienteAuto.setBackground(fondoTransparente);
        Text textauto = new Text("Vehicule" + " : " + algoThief.getCarSeleccionado());
        textauto.setFont(fuente);
        botonSiguienteAuto.setOnAction(e->{
            algoThief.siguienteCar();
            AppController.abrirLaComputadora();
        });
        BorderPane cajaHorizontalAuto= new BorderPane();
        cajaHorizontalAuto.setLeft(textauto);
        cajaHorizontalAuto.setRight(botonSiguienteAuto);
        cajaHorizontalAuto.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));

        ListView listadoView = new ListView();
        listadoView.getItems().addAll(cajaHorizontalsex,cajaHorizontalHobby,cajaHorizontalPelo,cajaHorizontalFeature,cajaHorizontalAuto);
        return listadoView;
    }




}
