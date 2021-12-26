package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.scenes.CiudadScene;
import edu.fiuba.algo3.gui.scenes.ImagenPortada;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class StartGameLayout extends BorderPane {

    private Label labelVariable;

    public StartGameLayout(Stage window, App app, AlgoThief algoThief) {

        this.setBackground(ImagenPortada.crearFondo("rsc/images/computadoraFondo.png"));

        AudioClip audioClip = new AudioClip(Paths.get("rsc/sounds/maquinaEscribir.mp3").toUri().toString());
        audioClip.setVolume(0.3);
        audioClip.play();

        String[] lista = algoThief.desplegarTextoInicial().split("\n");
        VBox cajaOraciones = new VBox();
        cajaOraciones.setTranslateX(73);
        cajaOraciones.setTranslateY(50);

        for (String oracion : lista){
            Text textodeoracion= new Text(oracion);
            cajaOraciones.getChildren().addAll(textodeoracion);
            textodeoracion.setFont(Font.font("Verdana", FontPosture.ITALIC, 18));
            textodeoracion.setFill(Color.GREEN);
            textodeoracion.setVisible(false);
            textodeoracion.setWrappingWidth(490);
        }
        Text clickParaContinuar =new Text("Click para saltar la presentacion");
        clickParaContinuar.setFill(Color.GRAY);
        clickParaContinuar.setTranslateX(148);
        clickParaContinuar.setTranslateY(50);
        cajaOraciones.getChildren().addAll(clickParaContinuar);


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int indice=0;
            @Override
            public void run() {

                Platform.runLater(() -> {

                    cajaOraciones.getChildren().get(indice).setVisible(true);
                    indice+=1;
                    if (indice>= cajaOraciones.getChildren().size()){
                        timer.cancel();}
                });
            }
        }, 0,1100);




        setOnMousePressed(e->{
            audioClip.stop();
            CiudadLayout ciudadLayout = new CiudadLayout(window,app, algoThief);
            CiudadScene ciudadScene = new CiudadScene(window,ciudadLayout, algoThief);
            window.setScene(ciudadScene);

        });


        setCenter(cajaOraciones);

    }
}
