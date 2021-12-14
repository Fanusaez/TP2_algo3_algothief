package edu.fiuba.algo3.modelo.computadora;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

import java.util.ArrayList;

public class Filtrador {

    public ArrayList<String> filtrar(ArrayList<ArrayList<String>> listaCaracteristicas,ArrayList<Delincuente> listaSospechosos){
        ArrayList<String> listaDeCoincidintes = new ArrayList<String>();
        for(Delincuente sospechoso: listaSospechosos){
            if (sospechoso.cumpleLasCaracteristicas(listaCaracteristicas)){
                listaDeCoincidintes.add(sospechoso.obtenerDato("Name")); //asi?
            }
        }
        return listaDeCoincidintes;
    }
}
