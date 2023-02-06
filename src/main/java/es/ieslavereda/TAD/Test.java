package es.ieslavereda.TAD;

import es.ieslavereda.Cartas.Carta;
import es.ieslavereda.Cartas.Palo;
import es.ieslavereda.Cartas.Valor;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        ListaSimplementeEnlazada<Carta> miLista = new ListaSimplementeEnlazada<>();
        ListaSimplementeEnlazada<Carta> miLista2 = new ListaSimplementeEnlazada<>();

        miLista.addTail(new Carta(Valor.A, Palo.HEART));
        miLista.addTail(new Carta(Valor.J, Palo.CLUB));
        miLista.addTail(new Carta(Valor.K, Palo.HEART));

        miLista2.addTail(new Carta(Valor.A, Palo.HEART));
        miLista2.addTail(new Carta(Valor.J, Palo.CLUB));
        miLista2.addTail(new Carta(Valor.K, Palo.HEART));

        System.out.println(miLista.equals(miLista2));
        System.out.println(Arrays.asList(miLista2.asArray(Carta.class)));


    }

}
