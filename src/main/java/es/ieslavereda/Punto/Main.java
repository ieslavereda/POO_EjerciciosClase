package es.ieslavereda.Punto;

public class Main {

    public static void main(String[] args) {

        Punto punto = new Punto();
        Punto punto2 = new Punto(3,1);

        System.out.println(punto.getDistance(punto2));

    }
}
