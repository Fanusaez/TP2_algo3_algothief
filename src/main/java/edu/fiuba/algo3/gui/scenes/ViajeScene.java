package edu.fiuba.algo3.gui.scenes;

import edu.fiuba.algo3.gui.layouts.ViajeLayout;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViajeScene extends Scene {

    ViajeLayout viajeLayout;

    public ViajeScene(Stage window, ViajeLayout viajeLayout, AlgoThief algoThief) {
        super(viajeLayout,640,480);

        this.viajeLayout = viajeLayout;
    }

    public ViajeLayout getViajeLayout() {
        return viajeLayout;
    }

    public void setViajeLayout(ViajeLayout viajeLayout) {
        this.viajeLayout = viajeLayout;
    }
}