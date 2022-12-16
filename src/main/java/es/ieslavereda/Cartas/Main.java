package es.ieslavereda.Cartas;

public class Main {
    public static void main(String[] args) {

        Baraja baraja = new Baraja();
        Jugador jugador = new Jugador("Manolo");

        baraja.shuffle();

        jugador.addCard(baraja.getUp());



    }
}