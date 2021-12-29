package edu.fiuba.algo3.View;

import edu.fiuba.algo3.Controller.App;
import edu.fiuba.algo3.View.layouts.StartGameLayout;
import edu.fiuba.algo3.View.scenes.MainMenuScene;
import edu.fiuba.algo3.Model.AlgoThief;
import javafx.stage.Stage;

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
