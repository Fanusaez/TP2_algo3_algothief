package edu.fiuba.algo3.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;

import java.util.List;

public class BarraAcciones extends HBox {

    public BarraAcciones(Button b1, Button b2, Button b3, Button b4){
        DropShadow dropShadow = new DropShadow(1, 4, 4, Color.BLACK);

        b1.setEffect(dropShadow);
        b2.setEffect(dropShadow);
        b3.setEffect(dropShadow);
        b4.setEffect(dropShadow);

        ImageView viewOpciones = new ImagenParaBoton("rsc/images/opciones.png", 50, 50);
        b1.setGraphic(viewOpciones);

        ImageView viewAvion = new ImagenParaBoton("rsc/images/avion.png", 50, 50);
        b2.setGraphic(viewAvion);

        ImageView viewLupa = new ImagenParaBoton("rsc/images/lupa.png", 50, 50);
        b3.setGraphic(viewLupa);

        ImageView viewComputadora = new ImagenParaBoton("rsc/images/computadora.png", 50, 50);
        b4.setGraphic(viewComputadora);

        this.getChildren().addAll(b1, b2, b3, b4);
        this.setSpacing(8);
        this.setPadding(new Insets(3));


        BorderStroke borderStroke =
                new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(1),
                        new BorderWidths(3)
                );
        Border border = new Border(borderStroke);
        b1.setBorder(border);
        b2.setBorder(border);
        b3.setBorder(border);
        b4.setBorder(border);
    }

}
