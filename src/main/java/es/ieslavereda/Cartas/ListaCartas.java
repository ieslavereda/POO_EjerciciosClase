package es.ieslavereda.Cartas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListaCartas {

    private int size;
    private Node head;


    public Carta showFirst(){
        if(head==null)
            return null;
        return head.getInfo();
    }
    public Carta getFirst(){
        Carta c = null;
        if(head!=null){
            c=head.info;
            head = head.next;
            size--;
        }
        return c;
    }
    public void shuffle(){
        Carta[] cartas = toArray();
        List<Carta> cartaList = Arrays.asList(cartas);
        Collections.shuffle(cartaList);
        cartaList.toArray(cartas);

        clear();

        for(Carta c : cartas)
            add(c);
    }
    public void add(Carta c){
        Node node = new Node(c);

        if(head==null) {
            head = node;
        }else {
            node.setNext(head);
            head=node;
        }
        size++;
    }

    private void clear() {
        size=0;
        head=null;
    }

    public Carta[] toArray(){
        Carta[] aux = new Carta[size];
        Node n = head;
        int i=0;
        while(n!=null){
            aux[i]=n.info;
            n=n.next;
            i++;
        }
        return aux;
    }

    @Override
    public String toString() {
        return "{ size: "+size +", Values: " +((head==null)?"}":head);
    }

    private class Node {
        private Carta info;
        private Node next;

        public Node(Carta info) {
            this.info = info;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Carta getInfo() {
            return info;
        }

        @Override
        public String toString() {
            return info + ((next!=null)?", "+next:" }");
        }
    }

}
