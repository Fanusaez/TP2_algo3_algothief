package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;

public class Brujula {

    private Ciudad origen;
    private Ciudad destino;

    public int calcularDistanciaEntre(Ciudad ciudadActual,Ciudad destinoSeleccionado  ) {

        if (ciudadActual.obtenerDato("Continent").equals(destinoSeleccionado.obtenerDato("Continent"))){
            return 1800;
        }
        HashMap hashPrimerContinente = (HashMap) hashDistancias.get(ciudadActual.obtenerDato("Continent"));
        int variable= (int) hashPrimerContinente.get(destinoSeleccionado.obtenerDato("Continent"));
        return variable;

    }


}
