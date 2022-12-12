package es.ieslavereda.Punto;

public class Main {

    public static void main(String[] args) {

        Punto punto1 = new Punto();
        Punto punto2 = new Punto(1,1);

        Rectangulo rectangulo = new Rectangulo(punto1,punto2);

        System.out.println(rectangulo);

    }
}
