package es.ieslavereda.collections.ejercicio1;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solucion2 {
    // Map<Pais,Set<Trabajador>>
    public static void main(String[] args) {
        Map<Pais, Set<Trabajador>> personal = new TreeMap<>();

        Set<Trabajador> spain, alemania, suiza, francia, portugal;
        spain = new HashSet<>();
        spain.add(new Trabajador("Joaquin", 45));
        spain.add(new Trabajador("Luis", 22));
        spain.add(new Trabajador("Joaquin", 45));
        personal.put(new Pais("España"),spain);

        alemania = new HashSet<>();
        alemania.add(new Trabajador("Joaquin", 43));
        alemania.add(new Trabajador("Carlos", 40));
        personal.put(new Pais("Alemania"),alemania);

        suiza = new HashSet<>();
        suiza.add(new Trabajador("Carmen", 35));
        suiza.add(new Trabajador("Sofia", 31));
        suiza.add(new Trabajador("Roberto", 32));
        personal.put(new Pais("Suiza"),suiza);

        francia = new HashSet<>();
        francia.add(new Trabajador("Pedro", 41));
        personal.put(new Pais("Francia"),francia);

        portugal = new HashSet<>();
        portugal.add(new Trabajador("Teresa", 55));
        portugal.add(new Trabajador("Manolo", 25));
        personal.put(new Pais("Portugal"),portugal);




    }
}
