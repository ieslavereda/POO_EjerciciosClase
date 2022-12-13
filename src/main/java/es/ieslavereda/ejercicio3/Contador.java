package es.ieslavereda.ejercicio3;

public class Contador {

    private int valor;

    public void incremento(){
        valor++;
    }
    public void decremento(){
        valor--;
    }

    public void setValor(int valor){
        this.valor=valor;
    }
    public int getValor(){
        return valor;
    }
}
