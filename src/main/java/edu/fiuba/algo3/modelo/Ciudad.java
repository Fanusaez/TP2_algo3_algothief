package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.ExceptionDatoNoExistente;

import java.util.ArrayList;

public interface Ciudad {

    void agregarDato(String clave,String valor);

    String obtenerDato(String clave);

    void entrarAEdificio(int indice) ;

    //Getter de atributo
    Integer obtenerHorasDemoraAlEntrarEdificio() ;

    //Getter de atributo
    double getLatitud();

    //Getter de atributo
    double getLongitud();

    void agregarComoOpcion(Ciudad destino);

    //Este es un getter de un atributo
    ArrayList<Ciudad> mostrarOpcionesViaje();
    int ataques();
}
}
