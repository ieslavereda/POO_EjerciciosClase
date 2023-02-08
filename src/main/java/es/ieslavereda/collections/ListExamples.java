package es.ieslavereda.collections;

import es.ieslavereda.Cartas.Carta;
import es.ieslavereda.Cartas.Palo;
import es.ieslavereda.Cartas.Valor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListExamples {

    public static void main(String[] args) {

        List<Carta> myList = new LinkedList<>();

        myList.add(new Carta(Valor.A, Palo.HEART));
        myList.add(new Carta(Valor.J, Palo.CLUB));
        myList.add(new Carta(Valor.DOS, Palo.DIAMOND));
        myList.add(new Carta(Valor.Q, Palo.SPADE));

        Iterator<Carta> iterator = myList.listIterator();
        Carta c;
        while (iterator.hasNext()){
            c=iterator.next();
            if(c.getValor()==Valor.A)
                iterator.remove();

        }

        for(Carta ca : myList)
            System.out.println(ca);


//      Error en tiempo de ejecucion
//        for(Integer i : myList) {
//            if(i%2==0)
//                myList.remove(i);
//        }


    }
}
