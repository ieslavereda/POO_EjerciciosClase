package es.ieslavereda.TAD;

public class MyList<T> {
    private int size;
    private Node<T> head;

    public MyList() {
        size = 0;
        head = null;
    }

    public void addHead(T element) {
        Node<T> aux = new Node<>(element);
        aux.setNext(head);
        head = aux;
        size++;
    }

    public void addTail(T element) {
        // (1)
        if (head == null)
            addHead(element);

        // (2)
        Node<T> aux = head;
        while (aux.getNext() != null)
            aux = aux.getNext();

        // (3)
        aux.setNext(new Node<T>(element));
        size++;
    }

    public boolean remove(int index) {
        // (1)
        if (index >= size || index < 0)
            return false;
        // (2)
        if (index == 0) {
            head = head.getNext();
            size--;
            return true;
        }
        // (3)
        Node<T> aux = head;
        while (--index > 0)
            aux = aux.getNext();

        aux.setNext(aux.getNext().getNext());
        size--;
        return true;
    }

    public String toString() {
        return "size: " + size + "\n" + head.toString();
    }

   private class Node<T> {

        private T inf;
        private Node<T> next;

        Node(T inf){
            this.inf = inf;
            this.next = null;
        }
        Node<T> getNext(){
            return next;
        }
        void setNext(Node<T> node){
            this.next = node;
        }
        public String toString(){
            return inf.toString() + ((next!=null)?" " + next:"\n");
        }
    }
}