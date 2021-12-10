package edu.fiuba.algo3.modelo.fakes;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Policia;

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
}
