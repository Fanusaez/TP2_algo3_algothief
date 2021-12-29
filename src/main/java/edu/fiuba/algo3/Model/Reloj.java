package edu.fiuba.algo3.Model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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

        return String.format("You work it with %d days and %d hours, congratulations.",
                TimeUnit.MILLISECONDS.toDays(millis),
                TimeUnit.MILLISECONDS.toHours(millis) -
                        TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millis)));
    }


    public EstadoJuegoInterfaz tiempoAgotado() {
        if (dateTime.isAfter(LocalDateTime.of(1989, Month.JANUARY, 8, 15, 0, 0)) ){
            return new EstadoPerdido();
        }
        return new EstadoJugando();
    }
}