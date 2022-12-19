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


        juegaPC();

        mostrarGanadores();
        /*
        Comprobar por cada jugador si ha ganado o ha perdido.
         */

    }

    private void mostrarGanadores() {
        for(Jugador jugador : jugadores)
            if(jugador.getPuntuacion()> pc.getPuntuacion())
                System.out.println(jugador.getNombre() + " ha ganado");
            else
                System.out.println(jugador.getNombre() + " ha perdido");
    }

    private void juegaPC() {


        System.out.println("Le toca jugar a " + pc.getNombre());

        do {
            pc.addCard(baraja.getDown());
            System.out.println(pc);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (deboPedirCarta());
    }

    private boolean deboPedirCarta(){

        if(pc.getPuntuacion()==-1)
            return false;

        int puntuacionMaxima = 0;

        for(Jugador jugador:jugadores)
            if(jugador.getPuntuacion()>puntuacionMaxima)
                puntuacionMaxima= jugador.getPuntuacion();

        return puntuacionMaxima>pc.getPuntuacion()?true:false;

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
