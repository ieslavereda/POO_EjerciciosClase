package es.ieslavereda.TAD;

import es.ieslavereda.Cartas.Carta;
import es.ieslavereda.Cartas.Palo;
import es.ieslavereda.Cartas.Valor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaSimplementeEnlazadaTest {
    static ListaSimplementeEnlazada<Carta> lista;

    @BeforeEach
    public void initialize(){
        lista = new ListaSimplementeEnlazada<>();

        lista.addHead(new Carta(Valor.A, Palo.HEART));
        lista.addHead(new Carta(Valor.J, Palo.CLUB));
        lista.addHead(new Carta(Valor.Q, Palo.DIAMOND));
    }

    @Test
    @DisplayName("Testing get method when lista is empty")
    void getEmpty() {
        lista.clear();
        assertNull(lista.get(0));
        assertNull(lista.get(-1));
    }

    @Test
    @DisplayName("Testing get method when lista isn't empty")
    void getNotEmpty() {

        // Q♦, J♣, A♥
        assertEquals(new Carta(Valor.Q, Palo.DIAMOND),lista.get(0));
        assertEquals(new Carta(Valor.J, Palo.CLUB),lista.get(1));
        assertEquals(new Carta(Valor.A, Palo.HEART),lista.get(2));
        assertNull(lista.get(3));
        assertNull(lista.get(-1));

    }

    @Test
    @DisplayName("Remove object from the list")
    void remove() {

        // Q♦, J♣, A♥
        assertNull(lista.remove(-1));
        assertNull(lista.remove(3));
        System.out.println(lista);
        assertEquals(new Carta(Valor.A, Palo.HEART),lista.remove(2));
        // 7 6

        ListaSimplementeEnlazada<Carta> listaAux = new ListaSimplementeEnlazada<>();
        listaAux.addHead(new Carta(Valor.Q, Palo.DIAMOND));
        listaAux.addTail(new Carta(Valor.J, Palo.CLUB));
        assertEquals(listaAux,lista);

        assertEquals(new Carta(Valor.Q, Palo.DIAMOND),lista.remove(0));

    }
    @Test
    @Disabled
    void addAll() {

        ListaSimplementeEnlazada l2 = new ListaSimplementeEnlazada();
        l2.addTail(4);
        l2.addTail(8);

        assertTrue(lista.addAll(l2));
        assertFalse(lista.addAll(new ListaSimplementeEnlazada<Carta>()));

        l2 = new ListaSimplementeEnlazada();
//        l2.addHead(3);
//        l2.addHead(6);
//        l2.addHead(7);
//        l2.addTail(4);
//        l2.addTail(8);

        assertEquals(lista,l2);

    }
}