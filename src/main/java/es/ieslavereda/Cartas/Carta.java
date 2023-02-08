package es.ieslavereda.Cartas;

public class Carta implements Comparable<Carta>{

    private Palo palo;
    private Valor valor;

    public Carta(Valor valor, Palo palo) {

        this.palo = palo;
        this.valor = valor;
    }

    public Valor getValor(){
        return valor;
    }

    public Palo getPalo() {
        return palo;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Carta){
            Carta c = (Carta) o;
            return c.palo==palo && c.valor==valor;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return palo.hashCode();
    }

    @Override
    public String toString() {
        return valor + palo.toString();
    }

    @Override
    public int compareTo(Carta c) {

        if(palo!=c.palo){
            return palo.ordinal()-c.palo.ordinal();
        }else{
            return valor.ordinal()-c.valor.ordinal();
        }
    }
}



























