package edu.fiuba.algo3.modelo;

//import edu.fiuba.algo3.modelo.CosasDelincuente.CreadorDelincuentes;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.computadora.Computadora;
import edu.fiuba.algo3.modelo.dificultad.DificultadJuego;
import edu.fiuba.algo3.modelo.dificultad.DificultadNovato;
import edu.fiuba.algo3.modelo.policia.Policia;


import java.util.ArrayList;

public class AlgoThief implements AlgoThiefInterfaz{
    public Policia policia;
    private Reloj reloj;
    public Mapa mapa;
    private Delincuente delincuente;
    private String nombre;
    private Computadora computadora;
    private DificultadJuego dificultadJuego;
    public EstadoJuegoInterfaz estadoJuego;

    public AlgoThief(String rutaArchivoCiudades, String rutaArchivoDelincuentes) {

        dificultadJuego= new DificultadNovato();
        this.mapa = new Mapa(rutaArchivoCiudades);
        this.computadora = new Computadora(rutaArchivoDelincuentes, dificultadJuego);
        this.delincuente = computadora.ObtenerDelincuenteRandom();
        this.mapa.establecerPistasEnElRecorrido(this.delincuente);
        this.mapa.establecerOpcionesDeViaje();
        this.policia = new Policia(mapa.obtenerCiudadInicial());
        this.reloj = new Reloj();
        estadoJuego = new EstadoJugando();
    }

    public void ingresarUsuario(String unNombre){
        this.nombre=unNombre;
    }

    public String desplegarTextoInicial(){ // deberia ser una clase?
        Ciudad ciudadDelRobo = mapa.obtenerCiudadInicial();
        String nombreCiudadDelRobo = ciudadDelRobo.obtenerDato("City");
        String tesoroRobado = ciudadDelRobo.obtenerDato("Treasure");
        String sexoDelincuente = delincuente.getSexo();
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

    public String obtenerHorario(){ return reloj.obtenerHorario();}

    public String obtenerInformacionCiudad(){
        return policia.obtenerInformacionCiudad();
    }

    public String entrarAAeropuerto(){
        reloj.aumentarHoras(policia.getDemoraTiempoVisitarAeropuerto());
        String mensajeRetornado = policia.entrarAAeropuerto();
        actualizarEstadoDeJuego();
        return mensajeRetornado;
    }

    public String entrarABanco(){
        reloj.aumentarHoras(policia.getDemoraTiempoVisitarBanco());
        String mensajeRetornado = policia.entrarABanco();
        actualizarEstadoDeJuego();
        return mensajeRetornado;
    }

    public String entrarABiblioteca(){
        reloj.aumentarHoras(policia.getDemoraTiempoVisitarBiblioteca());
        String mensajeRetornado = policia.entrarABiblioteca();
        actualizarEstadoDeJuego();
        return mensajeRetornado;
    }

    public ArrayList<Ciudad> verOpcionesDeViaje() {return policia.mostrarOpcionesViaje();}

    public void viajar(Ciudad destinoSeleccionado) {
        reloj.aumentarHoras(policia.viajar(destinoSeleccionado));
        actualizarEstadoDeJuego();
    }

    public String ciudadActual() {
        return policia.ciudadActual();
    }

    public ArrayList<String> siguientePelo(){
        return computadora.siguientePelo();
    }
    public ArrayList<String> siguienteSex(){
        return computadora.siguienteSex();
    }
    public ArrayList<String> siguienteCar(){
        return computadora.siguienteCar();
    }
    public ArrayList<String> siguienteFeature(){
        return computadora.siguienteFeature();
    }
    public ArrayList<String> siguienteHobby(){
        return computadora.siguienteHobby();
    }



    public void actualizarEstadoDeJuego(){
        estadoJuego = estadoJuego.cambiarA(reloj.tiempoAgotado());
        estadoJuego = estadoJuego.cambiarA(realizarArresto());
    }
    public EstadoJuegoInterfaz getEstadoDeJuego(){
        return estadoJuego;
    }

    public EstadoJuegoInterfaz realizarArresto() {
        return policia.modificarEstadoDeJuego(computadora);
    }



    public ArrayList<String> mostrarAtriutosDelincuenteSeleccionados(){
        return computadora.mostrarOpcionesSeleccionadas();
    }

    public ArrayList<String> filtrarSospechosos(){
        reloj.aumentarHoras(1);
        actualizarEstadoDeJuego();
        return computadora.filtrar();
    }

    public String getSexoSeleccionado() {
        return computadora.getSexoSeleccionado();
    }

    public String getHobbySeleccionado() {
        return computadora.getHobbySeleccionado();
    }

    public String getHairSeleccionado() {
        return computadora.getHairSeleccionado();
    }

    public String getFeatureSeleccionado() {
        return computadora.getFeatureSeleccionado();
    }

    public String getCarSeleccionado() {
        return computadora.getCarSeleccionado();
    }
}