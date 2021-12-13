package edu.fiuba.algo3.modelo.CosasDelincuente;

public class Pistola implements Arma{

    private int dañoPistola;

    public Pistola(){
        dañoPistola = 4;
    }

    @Override
    public int atacar() {
        return dañoPistola;
    }
}
