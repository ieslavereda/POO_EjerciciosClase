package es.ieslavereda.ejercicioEurovision;

import java.util.*;
import java.util.stream.Collectors;

public class Pais implements Comparable<Pais>{

    private static final int[] PUNTOS = {1,2,3,4,5,6,7,8,9,10,12};
    private String nombre;
    private String cantante;

    private Map<Pais,Integer> puntucionRecibida;
    private Map<Integer,Pais> puntuacionEmitida;

    public Pais(String nombre, String cantante) {
        this.nombre = nombre;
        this.cantante = cantante;
        puntucionRecibida = new HashMap<>();
        puntuacionEmitida = new TreeMap<>();
    }

    public void recibirVoto(Integer puntuacion, Pais pais){
        puntucionRecibida.put(pais,puntuacion);
    }

    public void votar(Set<Pais> paises){

        List<Pais> paisList = new ArrayList<>(paises);
        Collections.shuffle(paisList);

        for(int punto : PUNTOS)
           puntuacionEmitida.put(punto, paisList.remove(0));

    }
    public int obtenerPuntuacionStreams(){
     return puntucionRecibida.values().stream()
             .collect(Collectors.summingInt(Integer::intValue));
    }
    public int obtenerPuntuacionStreams2(){
        return puntucionRecibida.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
    public int obtenerPuntuacionIterator(){
        int suma = 0;

        Iterator<Integer> iterator = puntucionRecibida.values().iterator();
        while (iterator.hasNext())
            suma+=iterator.next();

        return suma;
    }
    public int obtenerPuntuacion(){
        int suma = 0;

        for(Integer punto : puntucionRecibida.values())
            suma+=punto;

        return suma;
    }

    public Map<Integer,Pais> devolverVotos(){
        return puntuacionEmitida;
    }

    @Override
    public int compareTo(Pais o) {
        return nombre.compareToIgnoreCase(o.nombre);
    }

    @Override
    public String toString(){
        return nombre + "\n"+
                "Puntucion: " + obtenerPuntuacion();
    }
}
