package es.ieslavereda.Cartas;

public class Baraja {

    private static final String[] PALOS = {"O","E","C","B"};
    private Carta[] cartas;

    public Baraja(){
        cartas = new Carta[48];
        int j=0;
        for(String palo : PALOS){
            for(int i=1;i<=12;i++)
                cartas[j++] = new Carta(palo,i);
        }
    }

    @Override
    public String toString(){
        String salida = "";

        for(int i=0;i< cartas.length;i++)
            salida += cartas[i] +"\n";

        return salida;
    }
}

