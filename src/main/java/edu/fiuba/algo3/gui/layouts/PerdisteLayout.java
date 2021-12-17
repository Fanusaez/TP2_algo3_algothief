package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PerdisteLayout extends BorderPane {
    public PerdisteLayout(Stage window, App app, AlgoThief algoThief) {
        BorderPane border = new BorderPane();
        Text texto = new Text("Perdiste perdiste No hay nadie peor que vos");
        texto.setFont(Font.font("Verdana", FontPosture.REGULAR, 20));
        setCenter(texto);


    }
}
