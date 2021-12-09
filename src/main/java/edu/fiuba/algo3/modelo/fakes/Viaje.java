package edu.fiuba.algo3.modelo.fakes;

import edu.fiuba.algo3.modelo.CiudadProductiva;

public class Viaje {

    private CiudadProductiva origen;
    private CiudadProductiva destino;


    public int calcularDistanciaDeViaje(CiudadProductiva ciudadActual, CiudadProductiva destinoSeleccionado) {
        return 1800;
    }

    public double distancia() {
        double lat1 = origen.getLatitud();
        double lat2 = destino.getLatitud();

        double lon1 = origen.getLongitud();
        double lon2 = destino.getLongitud();

        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 3956;

        // calculate the result
        return (c * r);
    }
}
