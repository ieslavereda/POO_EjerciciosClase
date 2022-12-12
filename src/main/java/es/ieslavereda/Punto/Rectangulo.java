package es.ieslavereda.Punto;

public class Rectangulo {

    private Punto inferiorIzquierda;
    private Punto inferiorDerecha;
    private Punto superiorIzquierda;
    private Punto superiorDerecha;

    public Rectangulo(Punto inferiorIzquierda,Punto superiorDerecha){
        this.inferiorIzquierda = inferiorIzquierda;
        this.superiorDerecha= superiorDerecha;
        this.superiorIzquierda = new Punto(inferiorIzquierda.getX(),superiorDerecha.getY());
        this.inferiorDerecha = new Punto(superiorDerecha.getX(),inferiorIzquierda.getY());
    }

    public Rectangulo(Punto inferiorIzquierda, int base,int altura){
      this.inferiorIzquierda = inferiorIzquierda;
      this.inferiorDerecha = inferiorIzquierda.getRight(base);
      this.superiorDerecha = inferiorDerecha.getUp(altura);
      this.superiorIzquierda = inferiorIzquierda.getUp(altura);
    }

    public void moveUp(int distance){
        inferiorIzquierda.moveUp(distance);
        inferiorDerecha.moveUp(distance);
        superiorDerecha.moveUp(distance);
        superiorIzquierda.moveUp(distance);
    }

    public void moveDown(int distance){
        moveUp(-distance);
    }
    public int getBase(){
        return (int)(inferiorIzquierda.getDistance(inferiorDerecha));
    }
    public int getHight(){
        return (int)(inferiorDerecha.getDistance(superiorDerecha));
    }
    public int perimeter(){
        return 2*(getBase()+getHight());
    }

    public int area(){
        return getBase()*getHight();
    }

    @Override
    public String toString(){
        return inferiorIzquierda +","+ superiorIzquierda +","+ superiorDerecha +","+ inferiorDerecha;
    }
}
