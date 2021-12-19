package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.scenes.CiudadScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ComputadoraLayout extends BorderPane {
    public ComputadoraLayout(Stage window, App app, AlgoThief algoThief) {
        Text texto = new Text("Soy la computadora");
        texto.setFont(Font.font("Verdana", FontPosture.REGULAR, 20));
        setTop(texto);
        ListView list = app.CrearListadoDeLaComputadora();

        VBox cajaParaLista = new VBox();
        cajaParaLista.getChildren().addAll(list);
        setCenter(cajaParaLista);
        Button botonSalir= new Button("Volver");
        botonSalir.setMinSize(40,40);
        botonSalir.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        botonSalir.setOnAction(e-> {
            CiudadLayout ciudadLayout = new CiudadLayout(window, app, algoThief);
            CiudadScene ciudadScene = new CiudadScene(window, ciudadLayout, algoThief);
            window.setScene(ciudadScene);
        });
        HBox cerrar = new HBox(botonSalir);
        cerrar.setLayoutX(200);
        setTop(cerrar);
        Button botonComputar= new Button("Computar");
        botonComputar.setOnAction(e->{
            for(String delincuente :algoThief.filtrarSospechosos()){
                System.out.println(delincuente);
            }
        });
        setBottom(botonComputar);

    }

}
