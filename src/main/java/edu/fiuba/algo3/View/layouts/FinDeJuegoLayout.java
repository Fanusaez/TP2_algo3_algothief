package edu.fiuba.algo3.View.layouts;

import edu.fiuba.algo3.Controller.App;
import edu.fiuba.algo3.View.scenes.ImagenPortada;
import edu.fiuba.algo3.Model.AlgoThief;
import edu.fiuba.algo3.Model.EstadoGanado;
import edu.fiuba.algo3.Model.EstadoPerdido;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FinDeJuegoLayout extends BorderPane {
    public FinDeJuegoLayout(Stage window, App app, AlgoThief algoThief)  {

        if(algoThief.estadoJuego instanceof EstadoGanado){
            Text textoCongratulations=new Text(algoThief.tiempoTranscurrido());
            textoCongratulations.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
            setTop(textoCongratulations);
            
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
