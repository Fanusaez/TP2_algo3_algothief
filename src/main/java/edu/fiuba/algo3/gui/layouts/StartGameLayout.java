package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.gui.ConfirmBox;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartGameLayout extends VBox {

    private Label labelVariable;

    public StartGameLayout(Stage window) {

        Label label = new Label("Juego");
        labelVariable = new Label("");

        Button button = new Button("Se cierra!");
        button.setOnAction(e->{window.close();});

        getChildren().addAll(label,labelVariable,button);

    }

    public void setTextoVariable(String textoVariable) {

        this.labelVariable.setText(textoVariable);
    }
}
