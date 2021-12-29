package edu.fiuba.algo3.Model.fakes;

import edu.fiuba.algo3.Model.ciudad.Ciudad;
import edu.fiuba.algo3.Model.policia.Policia;
import edu.fiuba.algo3.Model.policia.Rango;

public class PoliciaFake extends Policia {

    public PoliciaFake(Ciudad unaCiudad) {
        super(unaCiudad);
    }

    public void setearCiudad(Ciudad ciudad){
        this.ciudadActual = ciudad;
    }

    public int obtenerVelocidad(){
        return rango.getVelocidad();
    }

    public void ascender(Rango rangoNuevo){
        this.rango = rangoNuevo;
    }

}
