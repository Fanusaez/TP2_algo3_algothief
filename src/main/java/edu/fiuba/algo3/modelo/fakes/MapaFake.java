package edu.fiuba.algo3.modelo.fakes;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.Mapa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
            if(ciudad.obtenerDato("city")==nombre){return ciudad;}
        }
        for (Ciudad ciudad : ciudadesRecorridasPorDelincuente) {
            if(ciudad.obtenerDato("city")==nombre){return ciudad;};
        }
        //return algo
        return new Ciudad();
    }
}
