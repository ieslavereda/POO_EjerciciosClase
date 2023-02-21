package es.ieslavereda.ejercicioEurovision;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        Concurso c = new Concurso();
        c.rellenarPaises("/home/jalonso/informacion.txt");
        c.votar();
        c.save("concurso");
        //c.imprimirListadoPaisesAlfabeticamente("listadoPaisesAlfabeticamente.txt");
        //c.imprimirListadoPaisesPuntuacion("listadoPaisesPuntuacion.txt");
        c.imprimirListadoPaisesPuntEmitidas("listadoPaisesPuntuacionVotosEmitidos.txt");

        Concurso c2 = new Concurso("concurso");
        c2.imprimirListadoPaisesPuntEmitidas("listadoPaisesPuntuacionVotosEmitidos2.txt");

    }
}
