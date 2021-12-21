package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.ImagenParaBoton;
import edu.fiuba.algo3.gui.scenes.CiudadScene;
import edu.fiuba.algo3.gui.scenes.ImagenPortada;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ComputadoraLayout extends BorderPane {
    public ComputadoraLayout(Stage window, App app, AlgoThief algoThief) {
        this.setBackground(ImagenPortada.crearFondo("rsc/images/computadoraFondo.png"));

        Text texto = new Text("Soy la computadora");
        texto.setFont(Font.font("Verdana", FontPosture.REGULAR, 20));
        setTop(texto);
        ListView list = app.CrearListadoDeLaComputadora();
        list.setTranslateY(3);
        list.setTranslateX(70);
        list.setMaxSize(499,160);
        list.setMinSize(499,160);
        VBox cajaParaLista = new VBox();
        cajaParaLista.getChildren().addAll(list);
        setCenter(cajaParaLista);
        Button botonSalir= new Button("Volver");
        botonSalir.setMinSize(20,20);
        botonSalir.setTranslateY(444);
        botonSalir.setTranslateX(185);
        botonSalir.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        botonSalir.setOnAction(e-> {
            CiudadLayout ciudadLayout = new CiudadLayout(window, app, algoThief);
            CiudadScene ciudadScene = new CiudadScene(window, ciudadLayout, algoThief);
            window.setScene(ciudadScene);
        });
        HBox cerrar = new HBox(botonSalir);
        cerrar.setLayoutX(200);
        setTop(cerrar);
        Button botonComputar= new Button("Computar");
        botonComputar.setTranslateX(80);
        botonComputar.setTranslateY(-11);
        botonComputar.setOnAction(e->{
            for(String delincuente :algoThief.filtrarSospechosos()){
                System.out.println(delincuente);
            }
        });
      /*  VBox textBox = new VBox();
        Text listadoDelincuentes = new Text();
        //String output = "";
        botonComputar.setOnAction(e->{
            String output = "";
            for(String delincuente :algoThief.filtrarSospechosos()){
                output += delincuente + "\n";
            }

        });
        textBox.getChildren().add(listadoDelincuentes);
        setRight(textBox);*/

        setBottom(botonComputar);

    }

}
