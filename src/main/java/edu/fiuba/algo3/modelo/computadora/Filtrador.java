package edu.fiuba.algo3.modelo.computadora;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

import java.util.ArrayList;

public class Filtrador {

    public ArrayList<Delincuente> filtrar(ArrayList<ArrayList<String>> listaCaracteristicas,ArrayList<Delincuente> listaSospechosos){
        ArrayList<Delincuente> listaDeCoincidintes = new ArrayList<Delincuente>();
        for(Delincuente sospechoso: listaSospechosos){
            if (sospechoso.cumpleLasCaracteristicas(listaCaracteristicas)){
                listaDeCoincidintes.add(sospechoso); //asi?
            }
        }
        return listaDeCoincidintes;
    }
}
