package es.ieslavereda.Cartas;

public class Baraja {
    private Carta[] cartas;

    public Baraja(){
        cartas = new Carta[Valor.values().length*Palo.values().length];
        int j=0;
        for(Palo palo : Palo.values()){
            for(Valor valor : Valor.values())
                cartas[j++] = new Carta(valor,palo);
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

