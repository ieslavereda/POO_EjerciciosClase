package es.ieslavereda.Cartas;

public interface Baraja {

    void shuffle();
    Carta getDown();
    void add(Carta c);
    default void mostrar(){
        System.out.println("hola");
    };

}
