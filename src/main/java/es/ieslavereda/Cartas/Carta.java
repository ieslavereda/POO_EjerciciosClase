package es.ieslavereda.Cartas;

public class Carta {

    private Palo palo;
    private Valor valor;

    public Carta(Valor valor, Palo palo) {

        this.palo = palo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor + palo.toString();
    }
}
