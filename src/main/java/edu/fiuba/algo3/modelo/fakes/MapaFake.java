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
}
