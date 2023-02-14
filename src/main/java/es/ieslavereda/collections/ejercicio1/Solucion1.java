package es.ieslavereda.collections.ejercicio1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solucion1 {
    public static void main(String[] args) {

        // Map<Pais,Set<Trabajador>> personal = new HashMap<>();
        Map<Trabajador, Pais> personal = new HashMap<>();

        personal.put(new Trabajador("Joaquin", 45), new Pais("España"));
        personal.put(new Trabajador("Joaquin", 43), new Pais("Alemania"));
        personal.put(new Trabajador("Luis", 22), new Pais("España"));
        personal.put(new Trabajador("Carlos", 40), new Pais("Alemania"));
        personal.put(new Trabajador("Carmen", 35), new Pais("Suiza"));
        personal.put(new Trabajador("Sofia", 31), new Pais("Suiza"));
        personal.put(new Trabajador("Roberto", 32), new Pais("Suiza"));
        personal.put(new Trabajador("Pedro", 41), new Pais("Francia"));
        personal.put(new Trabajador("Teresa", 55), new Pais("Portugal"));
        personal.put(new Trabajador("Manolo", 25), new Pais("Portugal"));

//        for(Trabajador t : personal.keySet())
//            System.out.println(t);

        // a)
        System.out.println("\na)");
        for (Pais pais : new HashSet<>(personal.values()))
            System.out.println(pais);

        // b)
        System.out.println("\nb)");
        Set<Trabajador> trabajadors = new TreeSet<>(personal.keySet());
        System.out.println(trabajadors);

        List<Trabajador> t = new ArrayList<>(personal.keySet());
        // t.sort(Trabajador::compareTo);
        t.sort(Trabajador.SORT_BY_NAME);
        System.out.println(t);

        personal.keySet().stream()
                .sorted((o1,o2)->o1.getEdad()-o2.getEdad())
                .forEach(System.out::println);

        List<Trabajador> myList = personal.keySet().stream()
                        .sorted((o1,o2)->o1.getEdad()-o2.getEdad())
                        .peek(System.out::println)
                        .collect(Collectors.toList());

        // c)
        // Map<Trabajador,Pais> -> Map<Pais,Set<Trabajador>>
        //      personal                    aux
        System.out.println("\nc)");
        Map<Pais, Set<Trabajador>> aux = new TreeMap<>();
        Pais pais;
        for (Trabajador trabajador : personal.keySet()) {
            pais = personal.get(trabajador);

            if (aux.containsKey(pais)) {
                aux.get(pais).add(trabajador);
            } else {
                Set<Trabajador> trabajadores = new TreeSet<>(Trabajador.SORT_BY_AGE);
                trabajadores.add(trabajador);
                aux.put(pais, trabajadores);
            }
        }
        for (Pais p : aux.keySet()) {
            System.out.println(p);
            for (Trabajador trabajador : aux.get(p))
                System.out.println("  " + trabajador);
        }

        // d)
        // Map<Trabajador,Pais>
        //         K        V
        System.out.println("\nd)");
        Set<Trabajador> trabajadorSet = personal.keySet();
        List<Trabajador> trabajadorList = new ArrayList<>();
        Iterator<Trabajador> iterator = trabajadorSet.iterator();

        Trabajador trabajador;
        while (iterator.hasNext()) {
            trabajador = iterator.next();
            if (trabajador.getEdad() > 50)
                trabajadorList.add(trabajador);
        }

        personal.keySet().stream()
                .filter((tra)->tra.getEdad()>50)
                .forEach(System.out::println);

        System.out.println("Trabajadores de mas de 50 años:"
                + trabajadorList);

        ////////////////////////////
        // Map<Pais,Set<Trabajador>>
        List<Trabajador> trabajadorList2 = new ArrayList<>();
        for (Set<Trabajador> set : aux.values()) {
            iterator = set.iterator();
            while (iterator.hasNext()) {
                trabajador = iterator.next();
                if (trabajador.getEdad() > 50)
                    trabajadorList2.add(trabajador);
            }
        }

        System.out.println("Trabajadores de mas de 50 años:"
                + trabajadorList2);

        aux.values().stream()
                .flatMap((Function<Set<Trabajador>, Stream<Trabajador>>) trabajadors1 -> trabajadors1.stream())
                .filter((tra)->tra.getEdad()>50)
                .forEach((trab)-> System.out.println("Trabajadores de mas de 50 años:"+trab));




    }
}
