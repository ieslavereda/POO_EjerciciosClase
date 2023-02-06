package es.ieslavereda.Cartas;

public class BarajaTAD implements Baraja{
    private ListaCartas cartas;

    public BarajaTAD() {
        cartas = new ListaCartas();
        int j = 0;
        for (Palo palo : Palo.values()) {
            for (Valor valor : Valor.values())
                cartas.add(new Carta(valor, palo));
        }
    }

    public Carta getDown(){
        return cartas.getFirst();
    }

    @Override
    public void add(Carta c) {
        cartas.add(c);
    }

    public Carta showUp(){
        return cartas.showFirst();
    }
    public void shuffle(){
        cartas.shuffle();
    }

    @Override
    public String toString() {
        return cartas.toString();
    }
}
