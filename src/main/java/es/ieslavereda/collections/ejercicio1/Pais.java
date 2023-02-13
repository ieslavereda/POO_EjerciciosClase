package es.ieslavereda.collections.ejercicio1;

public class Pais implements Comparable<Pais>{
    private String nombre;

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Pais)) return false;

        Pais p = (Pais) obj;

        return p.nombre.compareToIgnoreCase(nombre)==0;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int compareTo(Pais o) {
        return nombre.compareToIgnoreCase(o.nombre);
    }
}
