package edu.fiuba.algo3.View.layouts;

import edu.fiuba.algo3.Controller.App;
import edu.fiuba.algo3.View.scenes.ImagenPortada;
import edu.fiuba.algo3.Model.AlgoThief;
import edu.fiuba.algo3.Model.EstadoGanado;
import edu.fiuba.algo3.Model.EstadoPerdido;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
