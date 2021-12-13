package edu.fiuba.algo3.gui.layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPaneLayout extends BorderPane {

    public BorderPaneLayout(Stage window) {
        super();
        ToolBar toolbar = new ToolBar();
        Button button1 = new Button("Button 1");
        toolbar.getItems().add(button1);
        Button button2 = new Button("Button 2");
        toolbar.getItems().add(button2);
        HBox statusbar = new HBox();
        statusbar.getChildren().add(new Label("Hola soy un statusbar!"));
        VBox appContent = new VBox();
        appContent.getChildren().add(new Label("Hola soy un borderPane!"));
        ListView list = new ListView();
        list.getItems().add("Item 1");
        list.getItems().add("Item 2");
        list.getItems().add("Item 3");
        this.setAlignment(list, Pos.TOP_LEFT);
        this.setMargin(list, new Insets(12,12,12,12));
        ListView list2 = new ListView();
        list2.getItems().add("Item 1");
        list2.getItems().add("Item 2");
        list2.getItems().add("Item 3");
        this.setAlignment(list2, Pos.CENTER);
        this.setMargin(list2, new Insets(20,20,20,20));

        this.setRight(list2);
        this.setLeft(list);
        this.setTop(toolbar);
        this.setCenter(appContent);
        this.setBottom(statusbar);
    }


}
