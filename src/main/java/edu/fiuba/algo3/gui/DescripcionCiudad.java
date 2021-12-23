package edu.fiuba.algo3.gui;

import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;

import java.util.List;

public class DescripcionCiudad extends VBox{

    public DescripcionCiudad(Text descripcion){

        BorderStroke borderStroke =
                new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(1),
                        new BorderWidths(3)
                );
        Border border = new Border(borderStroke);
        descripcion.setWrappingWidth(300);
        this.getChildren().add(descripcion);
        this.setBorder(border);
        this.setPadding(new Insets(10));
    }
}
