package edu.fiuba.algo3.modelo;

//import edu.fiuba.algo3.modelo.CosasDelincuente.CreadorDelincuentes;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.computadora.Computadora;
import edu.fiuba.algo3.modelo.policia.Policia;


import java.util.ArrayList;
import java.util.Random;

public class AlgoThief implements AlgoThiefInterfaz{
    public Policia policia;
    private Reloj reloj;
    public Mapa mapa;
    private Delincuente delincuente;
    private String nombre;
    private Computadora computadora;

    public AlgoThief(String rutaArchivoCiudades, String rutaArchivoDelincuentes) {


        this.computadora = new Computadora(rutaArchivoDelincuentes);
        this.delincuente = computadora.ObtenerDelincuenteRandom();

        this.mapa = new Mapa(rutaArchivoCiudades);
        this.mapa.EstablecerPistasEnElRecorrido(this.delincuente);
        this.mapa.establecerOpcionesDeViaje();
        this.policia = new Policia(mapa.obtenerCiudadInicial());
        this.reloj = new Reloj();
    }



    public void nombreDeUsuario(String unNombre){
        nombre=unNombre;
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
                "Good luck, Rookie"+ nombre+ "\n" +
                "\n";
        return texto;
    }

    public String obtenerHorario(){

        return reloj.obtenerHorario();
    }


    public String entrarAEdificio(int indice) {
        reloj.aumentarHoras(policia.getDemoraTiempoVisitar(indice));
        return policia.entrarAEdificio(indice);
    }


    public ArrayList<Ciudad> verOpcionesDeViaje() {
        return policia.mostrarOpcionesViaje();
    }

    public void viajar(Ciudad destinoSeleccionado) {
        reloj.aumentarHoras(policia.viajar(destinoSeleccionado));
    }



}