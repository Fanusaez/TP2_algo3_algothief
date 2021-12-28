package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.scenes.ImagenPortada;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.EstadoGanado;
import edu.fiuba.algo3.modelo.EstadoPerdido;
import javafx.scene.Parent;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;

public class FinDeJuegoLayout extends BorderPane {
    public FinDeJuegoLayout(Stage window, App app, AlgoThief algoThief)  {

        if(algoThief.estadoJuego instanceof EstadoGanado){
            this.setBackground(ImagenPortada.crearFondo("rsc/images/ganaste.png"));
        }
        if(algoThief.estadoJuego instanceof EstadoPerdido){
            this.setBackground(ImagenPortada.crearFondo("rsc/images/perdiste.png"));
        }




    setOnMousePressed(e->{
        app.siguienteNivel();
    });

    }

}
