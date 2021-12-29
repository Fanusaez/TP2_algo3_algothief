package edu.fiuba.algo3.Model.CosasDelincuente;

public class Cuchillo implements Arma{
    int cantidadDeAtaques;
    int dañoCuchillo;

    public Cuchillo(){
        cantidadDeAtaques = 0;
        dañoCuchillo = 2;
    }

    @Override
    public int atacar() {
        if(cantidadDeAtaques >= 1)
        {
            return dañoCuchillo - 1;
        }

        cantidadDeAtaques++;
        return dañoCuchillo;
    }
}
