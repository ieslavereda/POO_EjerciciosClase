package es.ieslavereda.Cartas;

public class Game {

    private Baraja baraja;
    private Jugador[] jugadores;
    private Jugador pc;

    public Game(Jugador... jugadores) {
        this.baraja = new Baraja();
        this.pc = new Jugador("PC");
        this.jugadores = jugadores;
    }

    public void start() {

        baraja.shuffle();

        for (Jugador jugador : jugadores)
            juegaJugador(jugador);



        /*
        barajar
        cada jugador pide carta hasta diga basta o se pase
        juega Pc
            - Solicita siempre carta mientras no se haya pasado y su puntuacin sea inferior
               a todos los jugadores

        Comprobar por cada jugador si ha ganado o ha perdido.
         */

    }

    private void juegaJugador(Jugador jugador) {

        System.out.println("Le toca jugar a " + jugador.getNombre());
        String opcion = "";
        do {
            jugador.addCard(baraja.getDown());
            System.out.println(jugador);
            if (jugador.getPuntuacion() != -1)
                opcion = Entrada.getOption("Quieres otra carta? [Y|N]");
            else System.out.println("Te has pasado");
        } while (jugador.getPuntuacion() != -1 && opcion.equals(Entrada.YES));

    }

}
