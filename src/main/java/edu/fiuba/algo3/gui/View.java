package edu.fiuba.algo3.gui;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.layouts.StartGameLayout;
import edu.fiuba.algo3.gui.scenes.MainMenuScene;
import edu.fiuba.algo3.gui.scenes.StartGameScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.stage.Stage;

import java.lang.reflect.Method;

public class View {

    private StartGameLayout startGameLayout;
    private Stage stage;

    public View(Stage stage) {
        this.stage=stage;
    }

    public void initView(Stage window, App app, AlgoThief algoThief){
        // Comienza el juego
        MainMenuScene mainMenu = new MainMenuScene(window,app,algoThief);
        //startGameLayout = new StartGameLayout(window,app, algoThief);
        //StartGameScene startGameScene = new StartGameScene(window,startGameLayout, algoThief);
        window.setScene(mainMenu);
        window.show();
    }

    public StartGameLayout getStartGameLayout() {
        return startGameLayout;
    }
}
