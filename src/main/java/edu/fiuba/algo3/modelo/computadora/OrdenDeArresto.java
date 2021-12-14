package edu.fiuba.algo3.modelo.computadora;

import edu.fiuba.algo3.modelo.CosasDelincuente.Delincuente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class OrdenDeArresto {
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
    LinkedList ll;

    public OrdenDeArresto(){
        hair = new ArrayList<>(Arrays.asList("???","Brown", "Blond", "Red", "Black"));
        auto = new ArrayList<>(Arrays.asList("???","Convertible", "Limousine", "Race car", "Motorcycle"));
        hobby = new ArrayList<>(Arrays.asList("???","Tennis", "Music", "Mountain Climbing", "Skydiving","Swimming","Croquet"));
        feature = new ArrayList<>(Arrays.asList("???", "Limps","Ring","Tattoo","Scar","Jewelry"));
        sex = new ArrayList<>(Arrays.asList("???", "Male", "Female"));


    }



}
