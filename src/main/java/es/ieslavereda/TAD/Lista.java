package es.ieslavereda.TAD;

public class Lista {

    private int size;
    private Node cabeza;

    public Lista() {
        size=0;
        cabeza=null;
    }

    public void addHead(int numero){
        Node node = new Node(numero);

        if(cabeza==null)
            cabeza= node;
        else {
            node.setNext(cabeza);
            cabeza=node;
        }

        size++;
    }


    @Override
    public String toString() {
        return "Lista{" +
                "size=" + size +
                ", valores = " + cabeza +
                '}';
    }
}
