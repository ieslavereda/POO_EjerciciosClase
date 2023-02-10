package es.ieslavereda.collections;

import es.ieslavereda.Cartas.Carta;
import es.ieslavereda.Cartas.Palo;
import es.ieslavereda.Cartas.Valor;

import java.util.*;
import java.util.stream.Collectors;

public class SetExample {

    public static void main(String[] args) {

        Set<Carta> mySet = new HashSet<>();

        mySet.add(new Carta(Valor.A, Palo.HEART));
        mySet.add(new Carta(Valor.Q, Palo.HEART));
        mySet.add(new Carta(Valor.DOS, Palo.DIAMOND));
        mySet.add(new Carta(Valor.TRES, Palo.CLUB));
        mySet.add(new Carta(Valor.K, Palo.SPADE));
        mySet.add(new Carta(Valor.DOS, Palo.SPADE));
        mySet.add(new Carta(Valor.CUATRO, Palo.CLUB));
        mySet.add(new Carta(Valor.DOS, Palo.HEART));
        mySet.add(new Carta(Valor.DOS, Palo.CLUB));
        mySet.add(new Carta(Valor.OCHO, Palo.HEART));
        mySet.add(new Carta(Valor.J, Palo.HEART));

        Set<Carta> otroSet = new TreeSet<>(mySet);

        Set<Carta> otroSetCompar = new TreeSet<>((o1,o2) -> {
          if(o1.getValor()==o2.getValor()){
              return o1.getPalo().ordinal()-o2.getPalo().ordinal();
          }else
              return o1.getValor().ordinal()-o2.getValor().ordinal();
        } );

        Set<Carta> otroSetCompar2 = new TreeSet<>(Carta.comparatorPorPalo);

        Set<Carta> otroSetCompar3 = new TreeSet<>(new Comparator<Carta>() {
            @Override
            public int compare(Carta o1, Carta o2) {
                if(o1.getValor()==o2.getValor()){
                    return o1.getPalo().ordinal()-o2.getPalo().ordinal();
                }else
                    return o1.getValor().ordinal()-o2.getValor().ordinal();
            }
        });

        otroSetCompar.addAll(mySet);
        System.out.println(otroSetCompar);



//        List<Carta> myLista = new ArrayList<>(otroSet);

        //System.out.println(myLista);

//        for(Carta c : otroSet){
//            System.out.println(c);
//        }
//        otroSet.remove(new Carta(Valor.OCHO, Palo.HEART));
//
//        System.out.println(mySet);
//        System.out.println("-----");
//        System.out.println(otroSet);
//
        Set<Carta> ases = mySet.stream()
                        .filter(
                                (c)->c.getValor()==Valor.A)
                        .collect(Collectors.toSet());
        System.out.println(ases);

    }
}











