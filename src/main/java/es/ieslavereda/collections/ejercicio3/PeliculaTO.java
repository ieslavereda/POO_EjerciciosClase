package es.ieslavereda.collections.ejercicio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeliculaTO implements Comparable<PeliculaTO>{

    private static int nextValue = 0;
    private int id;
    private String titulo;
    // private Map<Actor,Personaje> actores;
    private Map<String,String> actores;
    private List<String> directores;

    public PeliculaTO(int id,String titulo) {
        this.id= id;
        this.titulo = titulo;
        actores = new HashMap<>();
        directores = new ArrayList<String>();
        id  = ++nextValue;
    }

    public PeliculaTO(String titulo) {
        this.titulo = titulo;
        actores = new HashMap<>();
        directores = new ArrayList<String>();
        id  = ++nextValue;
    }

    public Map<String,String> getActores() {
        return actores;
    }

    public void addActor(String actor,String personaje) {
        actores.put(actor,personaje);
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof PeliculaTO))
            return false;
        PeliculaTO p = (PeliculaTO) obj;
        return p.id==id;
    }

    @Override
    public String toString() {
        return "PeliculaTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    @Override
    public int compareTo(PeliculaTO o) {
        return titulo.compareToIgnoreCase(o.titulo);
    }
}
