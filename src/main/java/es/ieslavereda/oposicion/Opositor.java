package es.ieslavereda.oposicion;

import java.util.HashSet;
import java.util.Set;

public class Opositor {

    Set<Bola> temas;

    public Opositor(int numero) {

        temas = new HashSet<>();

        while(temas.size()<numero)
            temas.add(new Bola(getRandom(1, 80)));

    }

    private int getRandom(int inf,int sup){
        return (int)(Math.random()*(sup-inf+1)+1);
    }

    @Override
    public String toString() {
        return "Opositor{" +
                "temas=" + temas +
                '}';
    }

    public boolean controlaTema(Bola bola) {
        return temas.contains(bola);
    }
}
