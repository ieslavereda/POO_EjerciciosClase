package es.ieslavereda.Cartas;

public enum Valor {
    UNO("A"),
    DOS("2"),
    TRES("3"),
    CUATRO("4"),
    CINCO("5"),
    SEIS("6"),
    SIETE("7"),
    OCHO("8"),
    NUEVE("9"),
    DIEZ("J"),
    ONCE("Q"),
    DOCE("K");

    private String shape;

    Valor(String shape){
        this.shape=shape;
    }

    @Override
    public String toString(){
        return shape;
    }
}
