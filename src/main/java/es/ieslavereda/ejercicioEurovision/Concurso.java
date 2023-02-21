package es.ieslavereda.ejercicioEurovision;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Concurso {

//    private static final String[][] datos = {
//            {"España", "Blanca Paloma"},
//            {"Alemania", "SubenStruhenBajem"},
//            {"Francia", "La Zarra"},
//            {"Italia", "Marco Mengoni"},
//            {"Reino Unido", "Los Brexit"},
//            {"Ucrania", "Tvorchi"},
//            {"Azerbaiyan", "Nombre Impronunciable"},
//            {"Croacia", "Let 3"},
//            {"Finlandia", "Uno cualquiera"},
//            {"Irlada", "Wild Youth"},
//            {"Israel", "Noa kirel"},
//            {"Letonia", "Sudden Lights"},
//            {"Malta", "The Buster"},
//            {"Noruega", "Alessandra"},
//            {"Albania", "Albina Kelmendi"},
//            {"Armenia","Brunette"}
//    };

    private Set<Pais> paises;

    public Concurso() {
        paises = new TreeSet<>();

    }

    public void rellenarPaises(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String linea = "";
            while((linea=br.readLine())!=null){
                // "España;Paloma".split(";")[0] -> "España"
                // "España;Paloma".split(";")[1] -> "Paloma"
                paises.add(new Pais(linea.split(";")[0],linea.split(";")[1]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
    public List<Pais> obtenerListadoPaisesPuntuacion(){

        List<Pais> aux = new ArrayList<>(paises);
        aux.sort(new Comparator<Pais>() {
            @Override
            public int compare(Pais o1, Pais o2) {
                return o1.obtenerPuntuacion()-o2.obtenerPuntuacion();
            }
        });
        return aux;


//        return paises.stream()
//                    .sorted(Comparator.comparingInt(Pais::obtenerPuntuacion).reversed())
//                    .collect(Collectors.toList());
    }

//    public List<Pais> obtenerListadoPaisesPuntuacion(){
//        List<Pais> paisList = new ArrayList<>(paises);
//
//        paisList.sort(Comparator.comparingInt(Pais::obtenerPuntuacion).reversed());
//
//        return paisList;
//    }
    public List<Pais> obtenerListadoPaisesAlfabeticamente(){
        return paises.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    public Map<Pais,Map<Integer,Pais>> obtenerListadoPaisesPuntEmitidas(){
        Map<Pais,Map<Integer,Pais>> aux = new TreeMap<>(
                (p1,p2)->p2.obtenerPuntuacion()-p1.obtenerPuntuacion()
            );

        for(Pais p : paises)
            aux.put(p,p.devolverVotos());

        return aux;
    }

//    public List<String> obtenerListadoCantantesAlfabeticamente(){
//        return paises.stream()
//                .map((p)->p.getCantante())
//                .sorted()
//                .collect(Collectors.toList());
//    }
    public List<String> obtenerListadoCantantesAlfabeticamente() {
        List<String> cantantes = new ArrayList<>();
        for(Pais p : paises)
            cantantes.add(p.getCantante());

//        Collections.sort(cantantes);
//        cantantes.sort((n1,n2)->n1.compareTo(n2));
        cantantes.sort(String::compareTo);
        return cantantes;
    }

    @Override
    public String toString() {
        return "Concurso{\n" +
                "paises=\n" + paises +
                '}';
    }
}
