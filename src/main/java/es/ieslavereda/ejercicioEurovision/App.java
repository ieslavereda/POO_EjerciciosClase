package es.ieslavereda.ejercicioEurovision;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        Concurso c = new Concurso();
        c.rellenarPaises("/home/jalonso/informacion.txt");
        c.votar();

        Map<Pais,Map<Integer,Pais>> aux = c.obtenerListadoPaisesPuntEmitidas();
        for(Pais p : aux.keySet()){
            System.out.println(p);
            Map<Integer,Pais> votos = aux.get(p);
            for(Integer i : votos.keySet())
                System.out.print(i + " -> " + votos.get(i).getNombre() +", ");
            System.out.println();
        }


    }
}
