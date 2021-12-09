package edu.fiuba.algo3.modelo.fakes;

import edu.fiuba.algo3.modelo.CiudadProductiva;
import edu.fiuba.algo3.modelo.Viaje;

public class PoliciaFake {

    CiudadFake ciudadActual;
    public int velocidad;
    public CiudadProductiva ciudadActual;
    public Viaje viaje;

    public PoliciaFake(CiudadProductiva unaCiudad) {
        this.ciudadActual = new CiudadFake();
        this.viaje = new Viaje();
        this.velocidad=900;
    }

    public void setearCiudad(CiudadFake ciudad){
        this.ciudadActual = ciudad;
    }

    public String entrarAEdificio(int indice) {
        return this.ciudadActual.entrarAEdificio(indice);
    }

    public int obtenerHorasDemoraAlEntrarEdificio() {
        return this.ciudadActual.obtenerHorasDemoraAlEntrarEdificio();
    }

    // Metodos de testeos ********************************************************************************

    public CiudadFake getCiudadActual(){
        return ciudadActual;
    }

    public int viajar(CiudadFake destinoSeleccionado) {
        ciudadActual=destinoSeleccionado;
        return viaje.calcularDistanciaDeViaje(ciudadActual,destinoSeleccionado)/velocidad;
    }
}
