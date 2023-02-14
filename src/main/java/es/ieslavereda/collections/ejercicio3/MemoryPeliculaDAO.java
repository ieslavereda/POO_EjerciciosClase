package es.ieslavereda.collections.ejercicio3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryPeliculaDAO {
    List<PeliculaTO> peliculas;

    public MemoryPeliculaDAO() {
        this.peliculas = new LinkedList<>();
    }

    public void add(PeliculaTO peliculaTO){
        if(!peliculas.contains(peliculaTO))
            peliculas.add(peliculaTO);
    }

    public List<PeliculaTO> getDisponibles(){
        return new ArrayList<>(peliculas);
    }

    public List<PeliculaTO> getDisponiblesOrdenadas(){
        return peliculas.stream()
                .sorted()
                .collect(Collectors.toList());
    }


    public void remove(PeliculaTO peliculaTO){
        peliculas.remove(peliculaTO);
    }

    public PeliculaTO removeById(int id){

        Iterator<PeliculaTO> iterator = peliculas.listIterator();
        PeliculaTO peliculaTO;

        while (iterator.hasNext()){
            peliculaTO = iterator.next();
            if(peliculaTO.getId()==id){
                iterator.remove();
                return peliculaTO;
            }
        }

        return null;
    }

}
