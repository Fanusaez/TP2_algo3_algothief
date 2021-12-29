package edu.fiuba.algo3.View.layouts;

import edu.fiuba.algo3.Controller.App;
import edu.fiuba.algo3.View.scenes.CiudadScene;
import edu.fiuba.algo3.View.scenes.ImagenPortada;
import edu.fiuba.algo3.Model.AlgoThief;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class EdificioLayout extends BorderPane {
    public EdificioLayout(Stage window, App app, AlgoThief algoThief,String rutaArchivo, String pista) {

        BorderPane cajaEmpleado = new BorderPane();

        Image image = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(rutaArchivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        image = new Image(fileInputStream);
        BackgroundImage backgroundImage =
                new BackgroundImage(
                        image,
                        BackgroundRepeat.NO_REPEAT,  // repeat X
                        BackgroundRepeat.NO_REPEAT,  // repeat Y
                        BackgroundPosition.CENTER,   // position
                        new BackgroundSize(
                                100,   // width  = 100%
                                100,   // height = 100%
                                true,  // width is percentage
                                true,  // height is percentage
                                true,  // contain image within bounds
                                false  // cover all of Region content area
                        )
                );

        cajaEmpleado.setBackground(new Background(backgroundImage));

        Text pistaLabel = new Text(pista+". Click to return");
        pistaLabel.setWrappingWidth(400);
        pistaLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        setOnMousePressed(e->{
            CiudadLayout ciudadLayout = new CiudadLayout(window, app, algoThief);
            CiudadScene ciudadScene = new CiudadScene(window, ciudadLayout, algoThief);
            window.setScene(ciudadScene);
        });

        this.setCenter(cajaEmpleado);
        this.setBottom(pistaLabel);
    }
}
