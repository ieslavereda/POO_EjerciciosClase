package es.ieslavereda.Cartas;

import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {

        int cantidadJugadores = Entrada.getInt("Cuantos jugadores quieren jugar.");
        Jugador[] jugadors = new Jugador[cantidadJugadores];

        for(int i=0;i<cantidadJugadores;i++)
            jugadors[i] = new Jugador(Entrada.getString("Nombre para el jugador " + (i+1)));

        Game game = new Game(jugadors);

        game.start();

    }
}