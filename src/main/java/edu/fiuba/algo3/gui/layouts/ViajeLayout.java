package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.scenes.CiudadScene;
import edu.fiuba.algo3.gui.scenes.ImagenPortada;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;

public class ViajeLayout extends VBox {
    public ViajeLayout(Stage window, App app, AlgoThief algoThief) {

        AudioClip audioClip = new AudioClip(Paths.get("rsc/sounds/fiumba.mp3").toUri().toString());
        audioClip.play();

        this.setBackground(ImagenPortada.crearFondo("rsc/images/fotoavion.jpg"));
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
