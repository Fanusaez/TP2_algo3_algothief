package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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



    }

}
