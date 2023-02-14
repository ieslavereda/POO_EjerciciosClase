package es.ieslavereda.collections.ejercicio3;

public class Main {
    public static void main(String[] args) {
        MemoryPeliculaDAO mpdao = new MemoryPeliculaDAO();

        mpdao.add(new PeliculaTO("Terminator"));
        mpdao.add(new PeliculaTO("Terminator II"));
        mpdao.add(new PeliculaTO("Terminator III"));
        mpdao.add(new PeliculaTO("Terminator IV"));
        mpdao.add(new PeliculaTO("Los puentes de Madison"));
        mpdao.add(new PeliculaTO("Los Mercenarios"));
        mpdao.add(new PeliculaTO("It"));
        mpdao.add(new PeliculaTO("ET"));
        mpdao.add(new PeliculaTO("Benhur"));

        //System.out.println(mpdao.getDisponibles());
        System.out.println(mpdao.removeById(111));
        System.out.println(mpdao.getDisponibles());
        //System.out.println(mpdao.getDisponiblesOrdenadas());


    }
}
