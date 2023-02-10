package es.ieslavereda.collections;

import es.ieslavereda.Cartas.Carta;
import es.ieslavereda.Cartas.Palo;
import es.ieslavereda.Cartas.Valor;

import java.util.*;

public class MapExample {

    public static void main(String[] args) {

        Map<String, Carta> myMap = new HashMap<>();

        myMap.put("hola",new Carta(Valor.K, Palo.CLUB));
        myMap.put("coche",new Carta(Valor.A, Palo.HEART));
        myMap.put("coche2",new Carta(Valor.A, Palo.HEART));
        myMap.put("zapato",new Carta(Valor.DOS, Palo.SPADE));
        myMap.put("camion",new Carta(Valor.Q, Palo.DIAMOND));
        myMap.put("abeto",new Carta(Valor.Q, Palo.CLUB));

        for(String key : myMap.keySet())
            System.out.println(key +" -> " +myMap.get(key));

//        myMap.put(6,new Carta(Valor.TRES, Palo.SPADE));
//
//        System.out.println("---------");
//        for(Integer key : myMap.keySet())
//            System.out.println(key +" -> " +myMap.get(key));

        for(Carta c : myMap.values()){
            System.out.println(c);
        }

        List<Carta> myLista = new ArrayList<>(myMap.values());
        Set<Carta> mySet = new HashSet<>(myMap.values());

    }
}
