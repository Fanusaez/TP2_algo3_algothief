package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.gui.ConfirmBox;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainMenuLayout extends VBox {

    String gameVersion = "V1.0";
    String imagePath = "rsc\\images\\detective.jpg";

    public MainMenuLayout(Stage window, StartGameScene startGameScene) {

        // Text
        Label label = new Label("TP2 Algoritmos III - Ingeniería Informática FIUBA");
        Text t = new Text("AlgoThief " + gameVersion);
        t.setFont(Font.font("Verdana", FontWeight.BOLD, 70));

        // Image
        ImageView imageView = new ImageView();
        try {
            FileInputStream fileInputStream = new FileInputStream(imagePath);
            Image image = new Image(fileInputStream);
            //Setting the image view
            imageView = new ImageView(image);
            //Setting the position of the image
            imageView.setX(50);
            imageView.setY(25);
            //setting the fit height and width of the image view
            imageView.setFitHeight(240);
            imageView.setFitWidth(240);
            //Setting the preserve ratio of the image view
            imageView.setPreserveRatio(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        TextField nombreUsuario = new TextField();
        nombreUsuario.setPromptText("Ingrese un nombre");

        // buttons
        Button buttonStart = new Button("Comenzar juego");
        buttonStart.setOnAction(e->window.setScene(startGameScene));

        Button buttonExit = new Button("Exit");
        buttonExit.setOnAction(e->{
            if(ConfirmBox.display("Are you sure?", "Exit?") == true)  window.close();
        });


        getChildren().addAll(nombreUsuario,label,t,imageView,buttonStart,buttonExit);

    }
}
