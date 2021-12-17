package edu.fiuba.algo3.modelo.fakes;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.computadora.Computadora;
import edu.fiuba.algo3.modelo.computadora.OrdenDeArresto;
import edu.fiuba.algo3.modelo.dificultad.DificultadJuego;
import edu.fiuba.algo3.modelo.dificultad.DificultadNovato;
import edu.fiuba.algo3.modelo.policia.Rango;

import java.util.ArrayList;

public class AlgoThiefFake  implements AlgoThiefInterfaz {
    public PoliciaFake policia;
    private Reloj reloj;
    public OrdenDeArresto ordenArresto;
    public MapaFake mapa;
    private Delincuente delincuente;
    private Computadora computadora;
    private DificultadJuego dificultadJuego;
    private EstadoJuegoInterfaz estadoJuego;
    private String nombre;

    public AlgoThiefFake(String rutaArchivoCiudades, String rutaArchivoDelincuentes) {

        dificultadJuego= new DificultadNovato();
        this.mapa = new MapaFake(rutaArchivoCiudades);
        this.computadora = new Computadora(rutaArchivoDelincuentes, dificultadJuego);
        this.delincuente = computadora.ObtenerDelincuenteRandom();
        this.mapa.establecerPistasEnElRecorrido(this.delincuente);
        this.mapa.establecerOpcionesDeViaje();
        this.policia = new PoliciaFake(mapa.obtenerCiudadInicial());
        this.reloj = new Reloj();
        estadoJuego = new EstadoJugando();
    }

    public void ingresarUsuario(String unNombre){
        this.nombre=unNombre;
    }

    public String desplegarTextoInicial(){
        String texto = "***FLASH***\n" +
                "National treasure stolen from Port Moresby.\n" +
                "The treasure has been identified as an ancient\n" +
                "tribal totem." +
                "Female suspect reported at the scene of the crime.\n" +
                "Your assignment:\n" +
                "Track the thief from Port Moresby to her\n" +
                "hideout and arrest her!\n" +
                "You must apprehend the thief by Sunday, 5pm.\n" +
                "Good luck,"+ this.nombre+ "\n" +
                "\n";
        return texto;
    }







    public String getDelincuenteNombre(){
        return delincuente.getNombre();
    }

    public EstadoJuegoInterfaz getEstadoJuego(){
        return estadoJuego;
    }

    public String obtenerHorario(){

        return reloj.obtenerHorario();
    }

    public String estadoJuegoComoString(){
        return estadoJuego.devolverComoString();
    }

    public void realizarArresto(){
        estadoJuego =computadora.realizarArresto();
    }
    public String obtenerInformacionCiudad(){
        return policia.obtenerInformacionCiudad();
    }

    public String entrarAEdificio(int indice) {
        reloj.aumentarHoras(policia.getDemoraTiempoVisitar(indice));
        String mensajeRetornado = policia.entrarAEdificio(indice);
        actualizarEstadoDeJuego();
        return mensajeRetornado;
    }


    public EstadoJuegoInterfaz modificarEstadoDeJuego(Computadora computadora) {
        return policia.modificarEstadoDeJuego(computadora);
    }

    public void actualizarEstadoDeJuego(){
        estadoJuego= reloj.tiempoAgotado();
        estadoJuego = estadoJuego.cambiarA(modificarEstadoDeJuego(computadora));
    }




    public ArrayList<Ciudad> verOpcionesDeViaje() {
        return policia.mostrarOpcionesViaje();
    }

    public void viajar(Ciudad destinoSeleccionado) {
        reloj.aumentarHoras(policia.viajar(destinoSeleccionado));
    }

    public String ciudadActual() {
        return policia.ciudadActual();
    }

    public void crearOrdenDeArrestoPara(String unDelincuente){
        computadora.crearOrdenDeArrestoPara(unDelincuente);
    }









    //este boton computar lo unico que hace es mostrarte los nombres, no te hace ganar ni perder
    public ArrayList<String> computar(){
        ArrayList<String> listadoNombresSospechosos = computadora.filtrar();
        return listadoNombresSospechosos;
    }


    public Ciudad getCiudadPolicia(){
        return policia.getCiudadActual();
    }

    public void setearCiudad(Ciudad ciudadSeleccionada){policia.setearCiudad(ciudadSeleccionada);}

    public Ciudad obtenerUltimaCiudad(){
        return this.mapa.obtenerUltimaCiudadDelincuente();
    }

    public Ciudad obtenerCiudad(String ciudad) {
        return mapa.buscarCiudad(ciudad);
    }

    public void ascenederPolicia(Rango rangoNuevo){
        policia.ascender(rangoNuevo);
    }

    public void aumentarHorario(int i) {
        reloj.aumentarHoras(i);
    }
}
