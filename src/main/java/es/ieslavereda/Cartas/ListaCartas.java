package es.ieslavereda.Cartas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListaCartas {

    private int size;
    private Node head;


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
            return "Node{" +
                    "info=" + info +
                    ", next=" + next +
                    '}';
        }
    }

}
