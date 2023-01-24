package es.ieslavereda.TAD;

public class Node {

    private int info;
    private Node next;

    public Node(int info){
        this.info = info;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getInfo() {
        return info;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        return info + ((next!=null)?" "+next.toString():"");
    }
}
