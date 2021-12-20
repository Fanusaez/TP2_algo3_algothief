package edu.fiuba.algo3.modelo.fakes;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Mapa;

public class MapaFake extends Mapa {
    public MapaFake(String rutaArchivoCiudades) {
        super(rutaArchivoCiudades);
    }

    //Metodos para tests **************************************************************************

    public Ciudad obtenerUltimaCiudadDelincuente(){
        int n = this.ciudadesRecorridasPorDelincuente.size();
        return this.ciudadesRecorridasPorDelincuente.get(n-1);
    }

    public Ciudad buscarCiudad(String nombre) {
        for (Ciudad ciudad : ciudadesNoRecorridasPorDelincuente){
            if(ciudad.obtenerDato("City").equals(nombre)){return ciudad;}
        }
        for (Ciudad ciudad : ciudadesRecorridasPorDelincuente) {
            if(ciudad.obtenerDato("City").equals(nombre)){return ciudad;};
        }
        //return algo
        return new Ciudad();
    }
}
