package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.scenes.CiudadScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

public class ViajeLayout extends VBox {
    public ViajeLayout(Stage window, App app, AlgoThief algoThief) {
        ImageView fotoavion = new ImageView();
        try {
        FileInputStream fileInputStream = new FileInputStream("rsc\\images\\fotoavion.jpg");
        Image image = new Image(fileInputStream);
        //Setting the image view
        fotoavion = new ImageView(image);
        //Setting the position of the image
        fotoavion.setX(200);
        fotoavion.setY(100);
        //setting the fit height and width of the image view
        fotoavion.setFitHeight(1100);
        fotoavion.setFitWidth(720);
        //Setting the preserve ratio of the image view
        fotoavion.setPreserveRatio(true);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

        getChildren().addAll(fotoavion);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    CiudadLayout ciudadLayout = new CiudadLayout(window,app, algoThief);
                    CiudadScene ciudadScene = new CiudadScene(window,ciudadLayout, algoThief);
                    window.setScene(ciudadScene);
                    return;
                });
            }
        }, 1200);
    }
}
