package edu.fiuba.algo3.Model.ciudad;
import edu.fiuba.algo3.Model.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.Model.Edificios.Aeropuerto;
import edu.fiuba.algo3.Model.Edificios.Banco;
import edu.fiuba.algo3.Model.Edificios.Biblioteca;
import edu.fiuba.algo3.Model.EstadoJuegoInterfaz;
import edu.fiuba.algo3.Model.Excepciones.ExceptionDatoNoExistente;
import edu.fiuba.algo3.Model.computadora.Computadora;

import java.util.ArrayList;
import java.util.HashMap;

public class Ciudad{
    public Aeropuerto aeropuerto;//0
    public Banco banco; //1
    public Biblioteca biblioteca;//2
    private HashMap <String,String> hash;
    private ArrayList<Ciudad> opcionesDeViaje;
    private EstadoCiudad estado;



    public Ciudad() {

        this.aeropuerto = new Aeropuerto();
        this.banco = new Banco();
        this.biblioteca = new Biblioteca();
        this.hash = new HashMap<String,String>();
        this.opcionesDeViaje = new ArrayList<>();
        this.estado = new Segura();
    }

    public void agregarDato(String clave,String valor) {
        this.hash.put(clave,valor);
    }

    public String obtenerDato(String clave){
        String claveCorregida;
        if (clave.length() >= 2 ) {
            claveCorregida = clave.substring(0, 1).toUpperCase() + clave.substring(1);
        }
        else{claveCorregida=clave.toUpperCase();}

        String dato = this.hash.get(claveCorregida);
        if (dato == null){
            throw new ExceptionDatoNoExistente();
        }

        return dato;
    }

    public EstadoJuegoInterfaz modificarEstadoDeJuego(Computadora computadora){
        return estado.modificarEstadoDeJuego(computadora);
    }

    public String entrarAAeropuerto() {
        return this.estado.entrarAEdificio(aeropuerto);
    }

    public String entrarABanco() {
        return this.estado.entrarAEdificio(banco);
    }

    public String entrarABiblioteca() {
        return this.estado.entrarAEdificio(biblioteca);
    }

    public void generarPista(Ciudad ciudadsiguiente, Delincuente delincuente) {
        aeropuerto.generarPistaEdificio(ciudadsiguiente,delincuente);
        banco.generarPistaEdificio(ciudadsiguiente,delincuente);
        biblioteca.generarPistaEdificio(ciudadsiguiente,delincuente);
    }

    public void agregarComoOpcion(Ciudad destino) {
        if(!opcionesDeViaje.contains(destino)){this.opcionesDeViaje.add(destino);}
    }

    public ArrayList<Ciudad> mostrarOpcionesViaje() {
        return this.opcionesDeViaje;
    }

    public int getDemoraTiempoVisitarBanco() {
        return banco.visitar() + estado.atacar();
    }
    public int getDemoraTiempoVisitarAeropuerto() {
        return banco.visitar() + estado.atacar();
    }
    public int getDemoraTiempoVisitarBiblioteca() {
        return banco.visitar() + estado.atacar();
    }

    public void setEstado(EstadoCiudad unEstado) {
        this.estado = unEstado;
    }

    public String obtenerInformacionCiudad() {
        return obtenerDato("Description");
    }
}

