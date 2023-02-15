package es.ieslavereda.oposicion;

import java.util.*;

public class Bombo {

    private Set<Bola> bolas;

    public Bombo() {
        bolas = new LinkedHashSet<>();
    }

    public void reiniciar(){
        bolas = new LinkedHashSet<>();
        rellenar();
    }

    public void rellenar(){
        for(int i=1;i<=80;i++)
            bolas.add(new Bola(i));
        for(int i=1;i<=80;i++)
            bolas.add(new Bola(i));

    }

    public void remover(){
        List<Bola> aux = new ArrayList<>(bolas);
        Collections.shuffle(aux);
        bolas = new LinkedHashSet<>(aux);
    }

    public Bola sacarBola(){
        Iterator<Bola> iterator = bolas.iterator();
        if(iterator.hasNext()){
            Bola bola = iterator.next();
            iterator.remove();
            return bola;
        }
        return null;
    }


    @Override
    public String toString() {
        return "Bombo{" +
                "bolas=" + bolas +
                '}';
    }
}
