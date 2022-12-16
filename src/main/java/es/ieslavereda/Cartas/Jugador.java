package es.ieslavereda.Cartas;

public class Jugador {
    private String nombre;
    private Carta[] mano;

    public Jugador(String nombre){
        this.nombre=nombre;
        mano = new Carta[0];
    }

    public void addCard(Carta carta){
        Carta[] aux = new Carta[mano.length+1];
        for(int i=0;i<mano.length;i++)
            aux[i] = mano[i];
        aux[aux.length-1]=carta;
        mano=aux;
    }

    public int getPuntuacion(){
        int puntuacion = 0;

        for(Carta carta : mano)
            puntuacion += carta.getValor().getPuntuacion()[0];

        return puntuacion;
    }
}
