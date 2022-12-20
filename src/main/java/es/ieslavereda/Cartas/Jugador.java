package es.ieslavereda.Cartas;

public class Jugador {
    private final String nombre;
    private Carta[] mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        mano = new Carta[0];
    }

    public String getNombre() {
        return nombre;
    }

    public void addCard(Carta carta) {
        Carta[] aux = new Carta[mano.length + 1];
        System.arraycopy(mano, 0, aux, 0, mano.length);
        aux[aux.length - 1] = carta;
        mano = aux;
    }

    private int getPuntuacionRecursiva(int index, int sum) {

        if (sum > 21) return -1;

        if (index >= mano.length)
            return sum;

        if (mano[index].getValor().getPuntuacion().length == 1)
            return getPuntuacionRecursiva(index + 1, sum + mano[index].getValor().getPuntuacion()[0]);

        return Math.max(
                getPuntuacionRecursiva(index + 1, sum + mano[index].getValor().getPuntuacion()[0]),
                getPuntuacionRecursiva(index + 1, sum + mano[index].getValor().getPuntuacion()[1])
        );

    }

    public int getPuntuacion() {
        return getPuntuacionRecursiva(0, 0);
//        int puntuacion = 0;
//
//        for(Carta carta : mano)
//            puntuacion += carta.getValor().getPuntuacion()[0];
//
//        return puntuacion>21 ? -1 : puntuacion;
    }

    @Override
    public String toString() {

        StringBuilder salida = new StringBuilder("Nombre: " + nombre + "\n");

        salida.append("Cartas: ");
        for (Carta carta : mano)
            salida.append(carta).append(" ");

        salida.append("\nPuntuacion: ").append(getPuntuacion());

        return salida.toString();
    }
}
