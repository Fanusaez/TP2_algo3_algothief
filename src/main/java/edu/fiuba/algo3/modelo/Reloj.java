package edu.fiuba.algo3.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Reloj {
    private LocalDateTime dateTime;

    public Reloj(){
        this.dateTime = LocalDateTime.of(1989, Month.JANUARY, 2, 7, 0, 0);
    }

    public String obtenerHorario() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("EEEE HH:mm").withLocale( Locale.ENGLISH );
        return this.dateTime.format(df);
    }


    public void aumentarHoras(int aumento){
        this.dateTime = this.dateTime.plusHours(aumento);

        if (this.dateTime.getHour() >= 22 || this.dateTime.getHour() < 6 ){
            this.dateTime = this.dateTime.plusHours(8);
        }
    }

    public String tiempoTranscurrido(){
        LocalDateTime localDateTimeIni = LocalDateTime.of(1989, Month.JANUARY, 2, 7, 0, 0);


        Duration dur = Duration.between(localDateTimeIni, dateTime);
        long millis = dur.toMillis();


        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toDays(millis),
                TimeUnit.MILLISECONDS.toHours(millis) -
                        TimeUnit.MILLISECONDS.toHours(TimeUnit.MILLISECONDS.toDays(millis)));
    }


    public EstadoJuegoInterfaz tiempoAgotado() {
        if (dateTime.isAfter(LocalDateTime.of(1989, Month.JANUARY, 8, 15, 0, 0)) ){
            return new EstadoPerdido();
        }
        return new EstadoJugando();
    }
}