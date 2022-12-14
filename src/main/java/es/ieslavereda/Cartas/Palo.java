package es.ieslavereda.Cartas;

import static com.diogonunes.jcolor.Ansi.colorize;

public enum Palo {
    HEART("♥",Color.RED),
    SPADE("\u2660",Color.BLACK),
    DIAMOND("\u2666",Color.RED),
    CLUB("\u2663",Color.BLACK);

    private Color color;
    private String shape;

    Palo(String shape,Color color){
        this.color = color;
        this.shape = shape;
    }

    @Override
    public String toString(){
        return colorize(shape, color.getColor());
    }
}
