package edu.fiuba.algo3.View.layouts;

import edu.fiuba.algo3.Controller.App;
import edu.fiuba.algo3.Model.AlgoThief;
import edu.fiuba.algo3.View.scenes.CiudadScene;
import edu.fiuba.algo3.View.scenes.ImagenPortada;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;

public class SiguienteNivelLayout extends BorderPane {

    public SiguienteNivelLayout(Stage window, App app, AlgoThief algoThief) {
        this.setBackground(ImagenPortada.crearFondo("rsc/images/computadoraFondo.png"));


        AudioClip audioClip = new AudioClip(Paths.get("rsc/sounds/maquinaEscribir.mp3").toUri().toString());
        audioClip.setVolume(0.3);

        VBox cajaOraciones = new VBox();
        cajaOraciones.setTranslateX(73);
        cajaOraciones.setTranslateY(35);

            String[] lista = algoThief.desplegarTextoInicial().split("\n");
            for (String oracion : lista) {
                Text textodeoracion = new Text(oracion);
                textodeoracion.setFont(Font.font("OCR A Extended", FontPosture.REGULAR, 18));
                textodeoracion.setFill(Color.GREEN);
                textodeoracion.setVisible(false);
                textodeoracion.setWrappingWidth(490);
                cajaOraciones.getChildren().addAll(textodeoracion);
            }
            Text clickParaContinuar = new Text("Click to skip the intro");
            clickParaContinuar.setFont(Font.font("OCR A Extended", FontPosture.REGULAR, 24));
            clickParaContinuar.setFill(Color.WHITE);
            this.setBottom(clickParaContinuar);

            audioClip.play();

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                int indice = 0;

                @Override
                public void run() {

                    Platform.runLater(() -> {

                        cajaOraciones.getChildren().get(indice).setVisible(true);
                        indice += 1;
                        if (indice >= cajaOraciones.getChildren().size()) {
                            timer.cancel();
                        }
                    });
                }
            }, 0, 800);

            setOnMousePressed(i -> {
                audioClip.stop();
                CiudadLayout ciudadLayout = new CiudadLayout(window, app, algoThief);
                CiudadScene ciudadScene = new CiudadScene(window, ciudadLayout, algoThief);
                window.setScene(ciudadScene);
            });

        setCenter(cajaOraciones);
    }
}
