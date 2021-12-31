package edu.fiuba.algo3.View.layouts;

import edu.fiuba.algo3.Controller.App;
import edu.fiuba.algo3.View.scenes.CiudadScene;
import edu.fiuba.algo3.View.scenes.ImagenPortada;
import edu.fiuba.algo3.Model.AlgoThief;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;

public class ViajeLayout extends VBox {
    public ViajeLayout(Stage window, App app, AlgoThief algoThief) {

        AudioClip audioClip = new AudioClip(Paths.get("rsc/sounds/avion.mp3").toUri().toString());
        audioClip.play();

        this.setBackground(ImagenPortada.crearFondo("rsc/images/fotoavion.jpg"));
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                audioClip.stop();
                Platform.runLater(() -> {
                    CiudadLayout ciudadLayout = new CiudadLayout(window,app, algoThief);
                    CiudadScene ciudadScene = new CiudadScene(window,ciudadLayout, algoThief);
                    window.setScene(ciudadScene);
                    return;
                });
            }
        }, 3000);
    }
}
