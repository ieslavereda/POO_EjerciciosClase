package es.ieslavereda.Punto;

public class Rectangulo {

    private Punto inferiorIzquierda;
    private Punto inferiroDerecha;
    private Punto superiorIzquierda;
    private Punto superiorDerecha;

    public Rectangulo(Punto inferiorIzquierda,Punto superiorDerecha){
        this.inferiorIzquierda = inferiorIzquierda;
        this.superiorDerecha= superiorDerecha;
        this.superiorIzquierda = new Punto(inferiorIzquierda.getX(),superiorDerecha.getY());
        this.inferiroDerecha = new Punto(superiorDerecha.getX(),inferiorIzquierda.getY());
    }



    @Override
    public String toString(){
        return inferiorIzquierda +","+ superiorIzquierda +","+ superiorDerecha +","+ inferiroDerecha;
    }
}
