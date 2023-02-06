package es.ieslavereda.Cartas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BarajaArray {
    private Carta[] cartas;

    public BarajaArray(){
        cartas = new Carta[Valor.values().length*Palo.values().length];
        int j=0;
        for(Palo palo : Palo.values()){
            for(Valor valor : Valor.values())
                cartas[j++] = new Carta(valor,palo);
        }

    }

    public void shuffle(){
        List<Carta> cartaList = Arrays.asList(cartas);
        Collections.shuffle(cartaList);
        cartaList.toArray(cartas);
    }

    public Carta getUp(){
        if(cartas.length==0)
            return null;

        Carta carta = cartas[cartas.length-1];
        Carta[] aux = new Carta[cartas.length-1];

        for(int i=0;i<aux.length;i++)
            aux[i]=cartas[i];

        cartas = aux;
        return carta;
    }

    public Carta getDown(){

        if(cartas.length==0)
            return null;

        Carta carta = cartas[0];
        Carta[] aux = new Carta[cartas.length-1];

        for(int i=0;i<aux.length;i++)
            aux[i]=cartas[i+1];

        cartas = aux;
        return carta;
    }

    public Carta showUp(){
        if(cartas.length>0)
            return cartas[cartas.length-1];
        else
            return null;
    }

    public Carta showDown(){
        if(cartas.length>0)
            return cartas[0];
        else
            return null;
    }

    @Override
    public String toString(){
        String salida = "";

        for(int i=0;i< cartas.length;i++)
            salida += cartas[i] +" ";

        return salida;
    }

    public int getSize() {
        return cartas.length;
    }
}

