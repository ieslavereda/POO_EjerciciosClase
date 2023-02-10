package es.ieslavereda.collections.ejercicio1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Map<Pais,Set<Trabajador>> personal = new HashMap<>();
        Map<Trabajador,Pais> personal = new HashMap<>();

        personal.put(new Trabajador("Joaquin",45),new Pais("España"));
        personal.put(new Trabajador("Joaquin",45),new Pais("España"));
        personal.put(new Trabajador("Luis",22),new Pais("España"));
        personal.put(new Trabajador("Carlos",40),new Pais("Alemania"));
        personal.put(new Trabajador("Carmen",35),new Pais("Suiza"));
        personal.put(new Trabajador("Pedro",41),new Pais("Francia"));
        personal.put(new Trabajador("Teresa",55),new Pais("Portugal"));

        for(Trabajador t : personal.keySet())
            System.out.println(t);

        // a)
        for(Pais pais : new HashSet<>(personal.values()))
            System.out.println(pais);

        // b)
        Set<Trabajador> trabajadors = new TreeSet<>(personal.keySet());
        System.out.println(trabajadors);

        List<Trabajador> t = new ArrayList<>(personal.keySet());
        // t.sort(Trabajador::compareTo);
        t.sort(Trabajador.SORT_BY_NAME);
        System.out.println(t);

        // c)

    }
}
