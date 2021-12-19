package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.ConfirmBox;
import edu.fiuba.algo3.gui.scenes.BorderPaneScene;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import edu.fiuba.algo3.modelo.AlgoThief;
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
    String imagePath = "algo3_tp2_algoThief/rsc/images/detective.jpg";

    public MainMenuLayout(Stage window, App app, AlgoThief algoThief) {

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
        buttonStart.setOnAction(e->{
            //if (nombreUsuario.getText().equals("")){return;}
            algoThief.ingresarUsuario(nombreUsuario.getText());
            StartGameLayout startGameLayout = new StartGameLayout(window,app, algoThief);
            StartGameScene startGameScene = new StartGameScene(window,startGameLayout, algoThief);
            window.setScene(startGameScene);
        });

        Button buttonBorderPane = new Button("abrir pane");
        buttonBorderPane.setOnAction(e->{
            algoThief.ingresarUsuario(nombreUsuario.getText());
            BorderPaneLayout borderPaneLayout = new BorderPaneLayout(window);
            BorderPaneScene borderPaneScene = new BorderPaneScene(window);
            window.setScene(borderPaneScene);
        });



        Button buttonExit = new Button("Exit");
        buttonExit.setOnAction(e->{
            if(ConfirmBox.display("Are you sure?", "Exit?") == true)  window.close();
        });


        getChildren().addAll(label,t,imageView,nombreUsuario,buttonStart,buttonExit);

    }
}
