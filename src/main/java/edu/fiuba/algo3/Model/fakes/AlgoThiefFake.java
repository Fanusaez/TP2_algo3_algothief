package edu.fiuba.algo3.Model.fakes;
import edu.fiuba.algo3.Model.*;
import edu.fiuba.algo3.Model.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.Model.ciudad.Ciudad;
import edu.fiuba.algo3.Model.computadora.Computadora;
import edu.fiuba.algo3.Model.computadora.OrdenDeArresto;
import edu.fiuba.algo3.Model.dificultad.DificultadJuego;
import edu.fiuba.algo3.Model.dificultad.DificultadNovato;
import edu.fiuba.algo3.Model.policia.Rango;

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
    private Ciudad ciudadIncial;
    final String directorioArchivoCiudades;
    final String directorioArchivoDelincuentes;

    public AlgoThiefFake(String rutaArchivoCiudades, String rutaArchivoDelincuentes, DificultadJuego dificultad ) {

        directorioArchivoCiudades=rutaArchivoCiudades;
        directorioArchivoDelincuentes=rutaArchivoDelincuentes;
        //dificultadJuego= new DificultadNovato();
        dificultadJuego = dificultad;
        this.mapa = new MapaFake(rutaArchivoCiudades);
        this.computadora = new Computadora(rutaArchivoDelincuentes, dificultadJuego);
        this.delincuente = computadora.ObtenerDelincuenteRandom();
        this.mapa.establecerPistasEnElRecorrido(this.delincuente);
        this.mapa.establecerOpcionesDeViaje();
        this.policia = new PoliciaFake(mapa.obtenerCiudadInicial());
        this.reloj = new Reloj();
        estadoJuego = new EstadoJugando();
    }

    public void SetearDificultadJuego(DificultadJuego unaDificultad){
        dificultadJuego = unaDificultad;
    }

    public void siguienteNivel(){
        if (policia.categoriaGanada()) {
            dificultadJuego = dificultadJuego.aumentarDificultad();
        }
        crearNivel(dificultadJuego);
    }

    private void crearNivel(DificultadJuego dificultad) {
        dificultadJuego= dificultad;
        this.mapa = new MapaFake(directorioArchivoCiudades);
        this.computadora = new Computadora(directorioArchivoDelincuentes, dificultadJuego);
        this.delincuente = computadora.ObtenerDelincuenteRandom();
        this.mapa.establecerPistasEnElRecorrido(this.delincuente);
        this.mapa.establecerOpcionesDeViaje();
        this.policia.setearCiudadIncial(mapa.obtenerCiudadInicial());
        if (estadoJuego instanceof EstadoPerdido){ //ver
            this.policia.reiniciarArrestos();}
        this.reloj = new Reloj();
        estadoJuego = new EstadoJugando();

    }

    public void ingresarUsuario(String unNombre){
        this.nombre=unNombre;
    }


    public String desplegarTextoInicial(){ // deberia ser una clase?

        String nombreCiudadDelRobo = ciudadIncial.obtenerDato("City");
        String tesoroRobado = ciudadIncial.obtenerDato("Treasure");
        String sexoDelincuente = delincuente.getNombre();
        String pronombre;
        String adjetivo;
        if (sexoDelincuente.equals("Male")){
            pronombre = "him";
            adjetivo = "his";
        }
        else{
            pronombre = "her";
            adjetivo = "her";
        }
        String texto = "***FLASH***\n" +
                "National treasure stolen from " +nombreCiudadDelRobo+ ".\n" +
                "The treasure has been identified as an "+ tesoroRobado+ ".\n" +
                ""+sexoDelincuente+ " suspect reported at the scene of the crime.\n"+
                "Your assignment:\n" +
                "Track the thief from " +nombreCiudadDelRobo+" to "+ adjetivo+" " +
                "hideout and arrest " + pronombre+" !\n" +
                "You must apprehend the thief by Sunday, 5pm.\n" +
                "Good luck,"+ this.nombre+ "\n" +
                "\n";
        return texto;
    }


    public void setearDelincuente(Delincuente delincuente){
        this.delincuente = delincuente;
    }

    public void setearCiudadInicial(Ciudad ciudad){
        this.ciudadIncial = ciudad;
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

    public String tiempoTranscurrido(){
        return reloj.tiempoTranscurrido();
    }

    public EstadoJuegoInterfaz realizarArresto() {
        return policia.modificarEstadoDeJuego(computadora);
    }

    public String entrarABanco(){
        reloj.aumentarHoras(policia.getDemoraTiempoVisitarBanco());
        String mensajeRetornado = policia.entrarABanco();
        actualizarEstadoDeJuego();
        return mensajeRetornado;
    }
    public String entrarAAeropuerto(){
        reloj.aumentarHoras(policia.getDemoraTiempoVisitarAeropuerto());
        String mensajeRetornado = policia.entrarAAeropuerto();
        actualizarEstadoDeJuego();
        return mensajeRetornado;
    }
    public String entrarABiblioteca(){
        reloj.aumentarHoras(policia.getDemoraTiempoVisitarBiblioteca());
        String mensajeRetornado = policia.entrarABiblioteca();
        actualizarEstadoDeJuego();
        return mensajeRetornado;
    }

    public EstadoJuegoInterfaz realizarArresto(Computadora computadora) {
        return policia.modificarEstadoDeJuego(computadora);
    }

    public void actualizarEstadoDeJuego(){
        estadoJuego = reloj.tiempoAgotado();
        estadoJuego = estadoJuego.cambiarA(realizarArresto(computadora));
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


    public DificultadJuego getDificultadJuego(){
        return dificultadJuego;
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
