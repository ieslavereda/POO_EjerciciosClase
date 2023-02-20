package es.ieslavereda.ejercicioEurovision;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Concurso {

    private static final String[][] datos = {
            {"España", "Blanca Paloma"},
            {"Alemania", "SubenStruhenBajem"},
            {"Francia", "La Zarra"},
            {"Italia", "Marco Mengoni"},
            {"Reino Unido", "Los Brexit"},
            {"Ucrania", "Tvorchi"},
            {"Azerbaiyan", "Nombre Impronunciable"},
            {"Croacia", "Let 3"},
            {"Finlandia", "Uno cualquiera"},
            {"Irlada", "Wild Youth"},
            {"Israel", "Noa kirel"},
            {"Letonia", "Sudden Lights"},
            {"Malta", "The Buster"},
            {"Noruega", "Alessandra"},
            {"Albania", "Albina Kelmendi"},
            {"Armenia","Brunette"}
    };

    private Set<Pais> paises;

    public Concurso() {
        paises = new TreeSet<>();
        rellenarPaises();
    }

    private void rellenarPaises() {
        for(String[] dato : datos)
            paises.add(new Pais(dato[0],dato[1]));
    }

    public void votar(){
        for(Pais p : paises){
            p.votar(paises);
        }

        for(Pais p : paises){
            Map<Integer,Pais> votos = p.devolverVotos();
            for(Integer puntuacion : votos.keySet()){
                Pais pais = votos.get(puntuacion);
                pais.recibirVoto(puntuacion,p);
            }
        }
    }

    @Override
    public String toString() {
        return "Concurso{\n" +
                "paises=" + paises +
                '}';
    }
}
