package es.ieslavereda.ejercicio3;

public class Main {
    public static void main(String[] args) {
        Contador contador1 = new Contador();
        Contador contador2 = new Contador();

        contador1.incremento();
        contador1.incremento();
        contador1.incremento();
        contador1.incremento();
        contador1.incremento();

        contador2.decremento();

        System.out.println(contador1.getValor());
        System.out.println(contador2.getValor());
    }
}
