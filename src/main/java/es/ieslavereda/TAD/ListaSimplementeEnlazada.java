package es.ieslavereda.TAD;

import java.lang.reflect.Array;

public class ListaSimplementeEnlazada<T> {

    private int size;
    private Node<T> cabeza;
    private Node<T> cola;

    public ListaSimplementeEnlazada() {
        size = 0;
        cabeza = null;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    public int size() {
        return size;
    }


    public T[] asArray(Class<T> c) {

        T[] aux =  (T[]) Array.newInstance(c, size);

        Node<T> n = cabeza;
        int i = 0;
        while (n != null) {
            aux[i] = n.getInfo();
            n = n.getNext();
            i++;
        }

        return aux;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ListaSimplementeEnlazada){
            ListaSimplementeEnlazada l = (ListaSimplementeEnlazada) obj;
            if(l.size!=size)
                return false;

            boolean encontrado = false;
            Node aux1 = cabeza;
            Node aux2 = l.cabeza;
            while (aux1!=null && !encontrado){
                if(!aux1.equals(aux2))
                    encontrado=true;

                aux1 = aux1.getNext();
                aux2 = aux2.getNext();
            }

            return !encontrado;
        }

        return false;
    }

    public T remove(int index) {
        if (index >= size || index < 0)
            return null;

        T value = null;

        if (index == 0) {
            value = cabeza.getInfo();
            cabeza = cabeza.getNext();
        } else {
            Node<T> aux1 = cabeza;
            Node<T> aux2 = cabeza.getNext();

            while (index > 1) {
                aux1 = aux2;
                aux2 = aux2.getNext();
                index--;
            }
            value = aux2.getInfo();
            aux1.setNext(aux2.getNext());

        }

        size--;
        return value;
    }

    public void addHead(T numero) {
        Node<T> node = new Node<>(numero);

        if (cabeza == null) {
            cabeza = node;
            cola = node;
        } else {
            node.setNext(cabeza);
            cabeza = node;
        }

        size++;
    }

    public boolean contains(T numero) {

        boolean encontrado = false;

        Node aux = cabeza;

        while (aux != null && !encontrado)
            if (aux.getInfo().equals(numero))
                encontrado = true;
            else
                aux = aux.getNext();

        return encontrado;
    }

    public T get(int index) {
        if (index >= size || index < 0)
            return null;

        Node<T> aux = cabeza;
        while (index > 0) {
            aux = aux.getNext();
            index--;
        }

        return aux.getInfo();
    }

    public boolean addAll(ListaSimplementeEnlazada<T> lista) {
        boolean modificado = false;

        Node<T> aux = lista.cabeza;
        for (int i = 0; i < lista.size; i++) {
            addTail(aux.getInfo());
            aux = aux.getNext();
            modificado = true;
        }
//        while (aux!=null){
//            modificado=true;
//            addTail(aux.getInfo());
//            aux=aux.getNext();
//        }

        return modificado;
    }

    public void clear() {
        cabeza = null;
        cola = null;
        size = 0;
    }

    public void addTail(T numero) {
        Node<T> node = new Node<>(numero);

        if (cabeza == null) {
            cabeza = node;
            cola = node;
        } else {
            cola.setNext(node);
            cola = node;
        }
        size++;
    }

    @Override
    public String toString() {
        return "{ size: " + size + ", Values: " + ((cabeza == null) ? "}" : cabeza.toString());
    }

    public static class Node<T> {

        private T info;
        private Node<T> next;

        public Node(T info) {
            this.info = info;
            this.next = null;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Node){
                Node aux = (Node)obj;
                return aux.info.equals(info);
            }
            return false;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getInfo() {
            return info;
        }

        public Node<T> getNext() {
            return next;
        }

        @Override
        public String toString() {
            return info + ((next != null) ? ", " + next : " }");
        }
    }
}