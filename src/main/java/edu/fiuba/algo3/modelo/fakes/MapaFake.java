package edu.fiuba.algo3.modelo.fakes;

import edu.fiuba.algo3.modelo.CiudadProductiva;
import edu.fiuba.algo3.modelo.Mapa;

public class MapaFake extends Mapa {
    public MapaFake(String rutaArchivoCiudades) {
        super(rutaArchivoCiudades);
    }

    //Metodos para tests **************************************************************************

    public CiudadProductiva obtenerUltimaCiudadDelincuente(){
        int n = this.ciudadesRecorridasPorDelincuente.size();
        return this.ciudadesRecorridasPorDelincuente.get(n-1);
    }
}
