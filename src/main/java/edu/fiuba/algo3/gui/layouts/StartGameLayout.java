package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.gui.ConfirmBox;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartGameLayout extends VBox {

    private String pista;
    public StartGameLayout(Stage window) {

        Label label = new Label("Juego!!!");

        Text t = new Text(pista);

        Button button = new Button("Se cierra!");
        button.setOnAction(e->{window.close();});

        getChildren().addAll(label,t,button);

    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }
}
