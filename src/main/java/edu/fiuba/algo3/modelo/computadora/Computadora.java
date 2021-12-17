package edu.fiuba.algo3.modelo.computadora;

import edu.fiuba.algo3.modelo.EstadoJuegoInterfaz;
import edu.fiuba.algo3.modelo.Parser.ParserArchivo;
import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;
import edu.fiuba.algo3.modelo.dificultad.DificultadJuego;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Computadora {
    private ArrayList<Delincuente> sospechosos;
    private Delincuente delincuente;
    private Filtrador filtrador;
    ArrayList<String> hair;
    int hairIndex;
    ArrayList<String> auto;
    int autoIndex;
    ArrayList<String> sex;
    int sexIndex;
    ArrayList<String> hobby;
    int hobbyIndex;
    ArrayList<String> feature;
    int featureIndex;
    OrdenDeArresto ordenArresto;
    ArrayList<String> filtrados;

    public Computadora(String rutaArchivoDelincuentes, DificultadJuego dificultad){
        this.sospechosos = ParserArchivo.parsearDelincuentes(rutaArchivoDelincuentes, dificultad);
        this.filtrador = new Filtrador();
        this.delincuente = sospechosos.get(new Random().nextInt(sospechosos.size()));
        this.hair = new ArrayList<>(Arrays.asList("???","Brown", "Blond", "Red", "Black"));
        this.auto = new ArrayList<>(Arrays.asList("???","Convertible", "Limousine", "Race car", "Motorcycle"));
        this.hobby = new ArrayList<>(Arrays.asList("???","Tennis", "Music", "Mountain Climbing", "Skydiving","Swimming","Croquet"));
        this.feature = new ArrayList<>(Arrays.asList("???", "Limps","Ring","Tattoo","Scar","Jewelry"));
        this.sex = new ArrayList<>(Arrays.asList("???", "Male", "Female"));
        this.ordenArresto = new OrdenDeArresto();
        filtrados = new ArrayList<String>();
    }
    public ArrayList<ArrayList<String>> siguientePelo(){
        hairIndex+=1;
        if((hair.size()) == hairIndex)
        {
            hairIndex = 0;
        }
        return mostrarOpcionesSeleccionadas();
    }
    public ArrayList<ArrayList<String>>siguienteSex(){
        sexIndex+=1;
        if((sex.size()) == sexIndex)
        {
            sexIndex = 0;
        }
        return mostrarOpcionesSeleccionadas();
    }
    public ArrayList<ArrayList<String>>siguienteSex2(){
        sexIndex+=1;
        return mostrarOpcionesSeleccionadas();
    }
    public ArrayList<ArrayList<String>> siguienteCar(){
        autoIndex+=1;
        if((auto.size()) == autoIndex)
        {
            autoIndex = 0;
        }
        return mostrarOpcionesSeleccionadas();
    }
    public ArrayList<ArrayList<String>> siguienteFeature(){
        featureIndex+=1;
        if((feature.size()) == featureIndex)
        {
            featureIndex = 0;
        }
        return mostrarOpcionesSeleccionadas();
    }
    public ArrayList<ArrayList<String>> siguienteHobby(){
        hobbyIndex+=1;
        if((hobby.size()) == hobbyIndex)
        {
            hobbyIndex = 0;
        }
        return mostrarOpcionesSeleccionadas();
    }



    public ArrayList<ArrayList<String>> mostrarOpcionesSeleccionadas(){
        ArrayList<ArrayList<String>> listaDeSeleccionados= new ArrayList<ArrayList<String>>();
        ArrayList<String> listaSex= new ArrayList<String>();
        listaSex.add("sex"); //1era posicion es la clave de la lista
        listaSex.add(sex.get(sexIndex)); //Obtenes el valor del atributo que elegiste
        listaDeSeleccionados.add(listaSex);

        ArrayList<String> listaHobby= new ArrayList<String>();
        listaHobby.add("hobby");
        listaHobby.add(hobby.get(hobbyIndex));
        listaDeSeleccionados.add(listaHobby);

        ArrayList<String> listaHair= new ArrayList<String>();
        listaHair.add("hair");
        listaHair.add(hair.get(hairIndex));
        listaDeSeleccionados.add(listaHair);

        ArrayList<String> listaFeature = new ArrayList<String>();
        listaFeature.add("feature");
        listaFeature.add(feature.get(featureIndex));
        listaDeSeleccionados.add(listaFeature);

        ArrayList<String> listaAuto= new ArrayList<String>();
        listaAuto.add("auto");
        listaAuto.add(auto.get(autoIndex));
        listaDeSeleccionados.add(listaAuto);

        return listaDeSeleccionados;
    }

    public Delincuente ObtenerDelincuenteRandom(){
        return delincuente;
    }

    public void crearOrdenDeArrestoPara(String unNombreDelincuente){
        ordenArresto.setNombre(unNombreDelincuente);
    }

    //descarta sospechosos en base a los datos que se ingresaron
    public ArrayList<String> filtrar(){
        ArrayList<String> listadoSospechososFiltrados = filtrador.filtrar(mostrarOpcionesSeleccionadas(),sospechosos);
        if(listadoSospechososFiltrados.size() == 1)
        {
            crearOrdenDeArrestoPara(listadoSospechososFiltrados.get(0));
        }

        return listadoSospechososFiltrados;
    }

    public EstadoJuegoInterfaz realizarArresto() {
        return ordenArresto.realizarArresto(delincuente.getNombre());
    }
}
