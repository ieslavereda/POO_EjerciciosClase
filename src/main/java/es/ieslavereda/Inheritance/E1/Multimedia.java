package es.ieslavereda.Inheritance.E1;

public class Multimedia {
    private String titulo;
    private String  autor;
    private Formato formato;
    private int duracion;

    public Multimedia(String titulo, String autor, Formato formato, int duracion) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Formato getFormato() {
        return formato;
    }

    /**
     * Metodo para obtener la duracion en segundos.
     * @return duracion en segundos
     */
    public int getDuracion() {
        return duracion;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Multimedia){
            Multimedia m = (Multimedia) obj;
            return m.titulo.compareToIgnoreCase(titulo)==0 && m.autor == autor;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", formato=" + formato +
                ", duracion=" + duracion +
                '}';
    }
}
