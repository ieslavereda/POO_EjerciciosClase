package es.ieslavereda.TAD;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        ListaSimplementeEnlazada lista = new ListaSimplementeEnlazada();

        lista.addHead(3);
        lista.addHead(6);
        lista.addHead(7);

        System.out.println(lista);
        System.out.println(lista.remove(2));
        System.out.println(lista.remove(0));
        System.out.println(lista);
    }

}
