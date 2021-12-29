package edu.fiuba.algo3.View.layouts;

import edu.fiuba.algo3.Controller.App;
import edu.fiuba.algo3.View.scenes.CiudadScene;
import edu.fiuba.algo3.View.scenes.ImagenPortada;
import edu.fiuba.algo3.Model.AlgoThief;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
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

public class StartGameLayout extends BorderPane {

    private Label labelVariable;

    public StartGameLayout(Stage window, App app, AlgoThief algoThief) {

        this.setBackground(ImagenPortada.crearFondo("rsc/images/computadoraFondo.png"));


        AudioClip audioClip = new AudioClip(Paths.get("rsc/sounds/maquinaEscribir.mp3").toUri().toString());
        audioClip.setVolume(0.3);

        VBox cajaOraciones = new VBox();
        Text textoInicial = new Text("Detective at keyboard, please identify yourself: ");
        textoInicial.setFont(Font.font("OCR A Extended", FontPosture.REGULAR, 18));
        textoInicial.setFill(Color.GREEN);
        textoInicial.setWrappingWidth(490);
        cajaOraciones.setTranslateX(73);
        cajaOraciones.setTranslateY(35);

        TextField nombreUsuario = new TextField();
        nombreUsuario.setMaxWidth(100);
        nombreUsuario.setFont(Font.font("OCR A Extended", FontPosture.REGULAR, 18));
        nombreUsuario.setStyle("-fx-text-fill: green");
        nombreUsuario.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
        cajaOraciones.getChildren().addAll(textoInicial, nombreUsuario);

        //Esto se puede modularizar
        nombreUsuario.setOnAction(e->{
            nombreUsuario.setEditable(false);
            nombreUsuario.setDisable(true);
            algoThief.ingresarUsuario(nombreUsuario.getText());
            String[] lista = algoThief.desplegarTextoInicial().split("\n");
            for (String oracion : lista){
                Text textodeoracion= new Text(oracion);
                textodeoracion.setFont(Font.font("OCR A Extended", FontPosture.REGULAR, 18));
                textodeoracion.setFill(Color.GREEN);
                textodeoracion.setVisible(false);
                textodeoracion.setWrappingWidth(490);
                cajaOraciones.getChildren().addAll(textodeoracion);
            }
            cajaOraciones.getChildren().addAll(new Text("pepito")); // aca iria: new Text(nombreUsuario.getText())
            Text clickParaContinuar =new Text("Click to skip the intro");
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
                        indice+=1;
                        if (indice>= cajaOraciones.getChildren().size()){
                            timer.cancel();}
                    });
                }
            }, 0,800);
        });



        setOnMousePressed(e->{
            if (!nombreUsuario.getText().equals("")) {
                audioClip.stop();
                CiudadLayout ciudadLayout = new CiudadLayout(window, app, algoThief);
                CiudadScene ciudadScene = new CiudadScene(window, ciudadLayout, algoThief);
                window.setScene(ciudadScene);
            }
        });


        setCenter(cajaOraciones);

    }
}
