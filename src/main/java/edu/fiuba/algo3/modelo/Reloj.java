package edu.fiuba.algo3.modelo;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Reloj {
    private LocalDateTime dateTime;

    public Reloj(){
        this.dateTime = LocalDateTime.of(1989, Month.JANUARY, 2, 7, 0, 0);
    }

    public String obtenerHorario() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("EEEE HH:mm"); //.withLocale( Locale.ENGLISH );
        return this.dateTime.format(df);
    }


    public void aumentarHoras(int aumento){
        this.dateTime = this.dateTime.plusHours(aumento);

        if (this.dateTime.getHour() >= 22 || this.dateTime.getHour() < 6 ){
            this.dateTime = this.dateTime.plusHours(8);
            System.out.println("Voy a dormir");
            System.out.println("zzz");
        }
    }
}