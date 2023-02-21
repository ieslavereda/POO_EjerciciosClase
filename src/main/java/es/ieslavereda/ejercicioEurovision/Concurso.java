package es.ieslavereda.ejercicioEurovision;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Concurso implements Serializable{

    private Set<Pais> paises;

    public Concurso() {
        paises = new TreeSet<>();
    }
    public Concurso(String path) {
        load(path);
    }

    public void rellenarPaises(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String linea = "";
            while ((linea = br.readLine()) != null) {
                // "España;Paloma".split(";")[0] -> "España"
                // "España;Paloma".split(";")[1] -> "Paloma"
                paises.add(new Pais(linea.split(";")[0], linea.split(";")[1]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(String path){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){

            oos.writeObject(this);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void save2(String path){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){

            oos.writeObject(paises);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void load(String path){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){

            Concurso c = (Concurso) ois.readObject();
            paises = c.paises;

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void load2(String path){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){

            Set<Pais> p = (Set<Pais>) ois.readObject();
            paises = p;

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void votar() {
        for (Pais p : paises) {
            p.votar(paises);
        }

        for (Pais p : paises) {
            Map<Integer, Pais> votos = p.devolverVotos();
            for (Integer puntuacion : votos.keySet()) {
                Pais pais = votos.get(puntuacion);
                pais.recibirVoto(puntuacion, p);
            }
        }
    }

    public List<Pais> obtenerListadoPaisesPuntuacion() {

        List<Pais> aux = new ArrayList<>(paises);
        aux.sort(new Comparator<Pais>() {
            @Override
            public int compare(Pais o1, Pais o2) {
                return o1.obtenerPuntuacion() - o2.obtenerPuntuacion();
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
    public void imprimirListadoPaisesAlfabeticamente(String path) {
        imprimir(obtenerListadoPaisesAlfabeticamente(), path, "Listado de paises alfabeticamente");
    }

    public void imprimirListadoPaisesPuntuacion(String path) {
        imprimir(obtenerListadoPaisesPuntuacion(), path, "Listado de paises puntuacion");
    }

    private void imprimir(List<Pais> paises, String path, String cabecera) {

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path)))) {

            pw.println(cabecera);
            pw.println("---------------------");
            for (Pais p : paises)
                pw.println(p.getNombre() + " -> " + p.obtenerPuntuacion());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public List<Pais> obtenerListadoPaisesAlfabeticamente() {
        return paises.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Map<Pais, Map<Integer, Pais>> obtenerListadoPaisesPuntEmitidas() {
        Map<Pais, Map<Integer, Pais>> aux = new TreeMap<>(
                (p1, p2) -> p2.obtenerPuntuacion() - p1.obtenerPuntuacion()
        );

        for (Pais p : paises)
            aux.put(p, p.devolverVotos());

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
        for (Pais p : paises)
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

    public void imprimirListadoPaisesPuntEmitidas(String path) {

        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path)))) {
            pw.println("Listado de paises por puntuacion y votos emitidos");
            pw.println("-------------------------------------------------");
            Map<Pais, Map<Integer, Pais>> aux = obtenerListadoPaisesPuntEmitidas();
            for (Pais p : aux.keySet()) {
                pw.println(p);
                Map<Integer, Pais> votos = aux.get(p);
                for (Integer i : votos.keySet())
                    pw.print(i + " -> " + votos.get(i).getNombre() + ", ");
                pw.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
