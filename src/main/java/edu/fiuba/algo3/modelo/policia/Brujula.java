package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;

public class Brujula {

    private HashMap hashDistancias;
    public Brujula() {
        hashDistancias= new HashMap<String,HashMap<String,Integer>>();
        completarHash(hashDistancias);
    }

    private void completarHash(HashMap hashDistancias) {
        HashMap<String, Integer> america = new HashMap<String,Integer>();
        HashMap<String, Integer> africa = new HashMap<String,Integer>();
        HashMap<String, Integer> europa = new HashMap<String,Integer>();
        HashMap<String, Integer> oceania = new HashMap<String,Integer>();
        HashMap<String, Integer> asia = new HashMap<String,Integer>();

        america.put("Africa",3500 );
        america.put("Europa",3000 );
        america.put("Oceania",4000 );
        america.put("Asia", 5000 );

        europa.put("America", 3000);
        europa.put("Africa",2000 );
        europa.put("Oceania",2800 );
        europa.put("Asia",3200 );

        oceania.put("America",4000 );
        oceania.put("Europa",2800 );
        oceania.put("Africa",3900 );
        oceania.put("Asia",2600);

        africa.put("America",3500 );
        africa.put("Europa",2000 );
        africa.put("Oceania",3900 );
        africa.put("Asia",4500 );

        asia.put("Europa",3200 );
        asia.put("Oceania", 2600);
        asia.put("Africa",4500 );
        asia.put("America",5000 );

        hashDistancias.put("America",america);
        hashDistancias.put("Africa",africa);
        hashDistancias.put("Oceania",oceania);
        hashDistancias.put("Asia",asia);
        hashDistancias.put("Europa",europa);

    }

    public int calcularDistanciaEntre(Ciudad ciudadActual,Ciudad destinoSeleccionado  ) {

        if (ciudadActual.obtenerDato("Continent").equals(destinoSeleccionado.obtenerDato("Continent"))){
            return 1800;
        }
        HashMap hashPrimerContinente = (HashMap) hashDistancias.get(ciudadActual.obtenerDato("Continent"));
        int variable= (int) hashPrimerContinente.get(destinoSeleccionado.obtenerDato("Continent"));
        return variable;

    }


}
