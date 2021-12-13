package edu.fiuba.algo3;

import edu.fiuba.algo3.gui.View;
import edu.fiuba.algo3.gui.layouts.StartGameLayout;
import edu.fiuba.algo3.gui.scenes.MainMenuScene;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.application.Application;
import javafx.stage.Stage;

import java.lang.reflect.Method;

public class App extends Application {

    private Stage window;
    private AlgoThief algoThief;
    private View view;

    public static void main(String[] args) {
        launch();
        System.out.println("El main se está llamando luego de cerrar el window! q onda?");
    }

    @Override
    public void start(Stage stage){
        System.out.println("Inicializacion");
        window = stage;
        window.setTitle("AlgoThief");
        algoThief = new AlgoThief("src\\main\\java\\edu\\fiuba\\algo3\\modelo\\data.txt");
        view = new View(window);
        view.initView(window,this, algoThief);
    }

    public void gameLogic(){
        System.out.println("El juego !!!");
        view.getStartGameLayout().setTextoVariable(algoThief.entrarAEdificio(0));
    }
}
