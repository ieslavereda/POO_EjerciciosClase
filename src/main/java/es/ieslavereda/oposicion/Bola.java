package es.ieslavereda.oposicion;

public class Bola {

    private int numero;

    public Bola(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Bola))
            return false;
        Bola b = (Bola) obj;
        return b.numero == numero;
    }

    @Override
    public int hashCode() {
        return numero;
    }

    @Override
    public String toString() {
        return String.valueOf(numero) ;
    }
}
