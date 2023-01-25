package es.ieslavereda.TAD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaSimplementeEnlazadaTest {
    static ListaSimplementeEnlazada lista;

    @BeforeEach
    public void initialize(){
        lista = new ListaSimplementeEnlazada();
    }
    @Test
    @DisplayName("Testing get method when lista is empty")
    void getEmpty() {
        assertNull(lista.get(0));
        assertNull(lista.get(-1));
    }

    @Test
    @DisplayName("Testing get method when lista isn't empty")
    void getNotEmpty() {
        lista.addHead(3);
        lista.addHead(6);
        lista.addHead(7);
        // 7 6 3
        assertEquals(7,lista.get(0));
        assertEquals(6,lista.get(1));
        assertEquals(3,lista.get(2));
        assertNull(lista.get(3));
        assertNull(lista.get(-1));
    }

    @Test
    @DisplayName("Remove object from the list")
    void remove() {
        lista.addHead(3);
        lista.addHead(6);
        lista.addHead(7);
        // 7 6 3
        assertNull(lista.remove(-1));
        assertNull(lista.remove(3));

        assertEquals(3,lista.remove(2));
        // 7 6

        ListaSimplementeEnlazada listaAux = new ListaSimplementeEnlazada();
        listaAux.addHead(7);
        listaAux.addTail(6);
        assertEquals(listaAux,lista);

        assertEquals(7,lista.remove(0));

    }
    @Test
    void addAll() {
        lista.addHead(3);
        lista.addHead(6);
        lista.addHead(7);

        ListaSimplementeEnlazada l2 = new ListaSimplementeEnlazada();
        l2.addTail(4);
        l2.addTail(8);

        assertTrue(lista.addAll(l2));
        assertFalse(lista.addAll(new ListaSimplementeEnlazada()));

        l2 = new ListaSimplementeEnlazada();
        l2.addHead(3);
        l2.addHead(6);
        l2.addHead(7);
        l2.addTail(4);
        l2.addTail(8);

        assertEquals(lista,l2);

    }
}