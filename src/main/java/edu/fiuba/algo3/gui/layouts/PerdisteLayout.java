package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.Parent;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;

public class PerdisteLayout extends BorderPane {
    public PerdisteLayout(Stage window, App app, AlgoThief algoThief) {
        Text texto = new Text("You lost!");
        Button botonReiniciar = new Button("Restart level");
        texto.setFont(Font.font("Verdana", FontPosture.REGULAR, 20));
        BorderPane caja = new BorderPane();
        caja.setCenter(botonReiniciar);
        setCenter(texto);
        setBottom(caja);


    }
}
