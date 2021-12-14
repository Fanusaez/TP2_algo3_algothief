package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.scenes.BorderPaneScene;
import edu.fiuba.algo3.gui.scenes.CiudadScene;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartGameLayout extends VBox {

    private Label labelVariable;

    public StartGameLayout(Stage window, App app, AlgoThief algoThief) {

        Label label = new Label(algoThief.desplegarTextoInicial());

        labelVariable = new Label("");


        Button buttonContinuar = new Button("Continuar");
        buttonContinuar.setOnAction(e->{
            CiudadLayout ciudadLayout = new CiudadLayout(window,app, algoThief);
            CiudadScene ciudadScene = new CiudadScene(window,ciudadLayout, algoThief);
            window.setScene(ciudadScene);

        });

        Button buttonExit = new Button("Exit");
        buttonExit.setOnAction(e->{window.close();});






        getChildren().addAll(label,labelVariable,buttonContinuar,buttonExit);


    }

    public void setTextoVariable(String textoVariable) {

        this.labelVariable.setText(textoVariable);
    }
}
