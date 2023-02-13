package es.ieslavereda.collections.ejercicio1;

import java.util.Comparator;

public class Trabajador implements Comparable<Trabajador>{

    public final static Comparator<Trabajador> SORT_BY_AGE = new Comparator<Trabajador>() {
        @Override
        public int compare(Trabajador o1, Trabajador o2) {
            return o1.edad- o2.edad;
        }
    };

    public final static Comparator<Trabajador> SORT_BY_NAME = new Comparator<Trabajador>() {
        @Override
        public int compare(Trabajador o1, Trabajador o2) {
            return o1.nombre.compareToIgnoreCase(o2.nombre);
        }
    };

    private String nombre;
    private int edad;

    public Trabajador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int hashCode() {
        return edad;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Trabajador))
            return false;

        Trabajador t = (Trabajador) obj;

        return t.nombre.compareToIgnoreCase(nombre)==0 && t.edad==edad;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                " edad='" + edad + '\'';
    }

    @Override
    public int compareTo(Trabajador o) {
        return nombre.compareToIgnoreCase(o.nombre);
    }
}

