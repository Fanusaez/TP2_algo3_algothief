package edu.fiuba.algo3.Model.computadora;

import edu.fiuba.algo3.Model.CosasDelincuente.Delincuente;

import java.util.ArrayList;

public class Filtrador {

    public static ArrayList<String> filtrar(ArrayList<String> listaCaracteristicas, ArrayList<Delincuente> listaSospechosos){
        ArrayList<String> listaDeCoincidintes = new ArrayList<String>();
        for(Delincuente sospechoso: listaSospechosos){
            if (sospechoso.cumpleLasCaracteristicas2(listaCaracteristicas)){
                listaDeCoincidintes.add(sospechoso.getNombre());
            }
        }
        return listaDeCoincidintes;
    }
}
