package es.ieslavereda.Punto;

public class Punto {

    private int x;
    private int y;

    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Punto(int x) {
        this.x = x;
        this.y = 0;
    }

    public void moveRight(int distance) {
        this.x += distance;
    }

    public void moveLeft(int distance) {
        this.x -= distance;
    }

    public void moveUp(int distance) {
        this.y += distance;
    }

    public void moveDown(int distance) {
        this.y -= distance;
    }

    public Punto getUp(int distance){
        return new Punto(this.x,this.y+distance);
    }

    public Punto getDown(int distance){
        return new Punto(this.x,this.y-distance);
    }

    public Punto getLeft(int distance){
        return new Punto(this.x-distance,this.y);
    }

    public Punto getRight(int distance){
        return new Punto(x+distance,y);
    }

    public double getDistance(Punto destino){
        int c1 = destino.x - x;
        int c2 = destino.y - y;

        return Math.sqrt(Math.pow(c1,2) + Math.pow(c2,2));
    }


    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
