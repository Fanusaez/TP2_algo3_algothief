package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.CosasDelincuente.CreadorDelincuentes;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

import java.util.ArrayList;

public class AlgoThief implements AlgoThiefInterfaz{
    public Policia policia;
    private Reloj reloj;

    public Mapa mapa;
    private Delincuente delincuente;
    private CreadorDelincuentes creadorDeDelincuentes;

    public AlgoThief(String rutaArchivoCiudades) {

        this.creadorDeDelincuentes = new CreadorDelincuentes(rutaArchivoCiudades);
        this.delincuente =  this.creadorDeDelincuentes.seleccionarDelincuenteAleatorio();
        this.mapa = new Mapa(rutaArchivoCiudades);
        this.mapa.EstablecerPistasEnElRecorrido(this.delincuente);
        mapa.establecerOpcionesDeViaje();
        CiudadProductiva ciudadInicial = mapa.obtenerCiudadInicial();
        this.policia = new Policia(ciudadInicial);
        this.reloj = new Reloj();
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
                "Good luck, Rookie <nombreUsuario>.\n" +
                "\n";
        return texto;
    }

    public String obtenerHorario(){

        return reloj.obtenerHorario();
    }

    public void chequearAtaque(){
        if (mapa.estaEnUltimaCiudad(policia.ciudadActual)) {
            reloj.aumentarHoras(delincuente.atacar());
        }
    }

    public void entrarAEdificio(int indiceEdificio) {
        reloj.aumentarHoras(policia.obtenerHorasDemoraAlEntrarEdificio());
        this.chequearAtaque();
        policia.entrarAEdificio(indiceEdificio);
    }

    public String entrarAEdificio(int indiceEdificio) {}


    public ArrayList<CiudadProductiva> verOpcionesDeViaje() {
        return mapa.mostrarOpcionesViaje(policia.ciudadActual);
    }

    public void viajar(CiudadProductiva destinoSeleccionado) {
        reloj.aumentarHoras(policia.viajar(destinoSeleccionado));

    }


}