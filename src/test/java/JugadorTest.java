import es.ieslavereda.Cartas.Carta;
import es.ieslavereda.Cartas.Jugador;
import es.ieslavereda.Cartas.Palo;
import es.ieslavereda.Cartas.Valor;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testeo de obtencion de la puntuacion de un Jugador")
public class JugadorTest {

    private Jugador jugador;

    @BeforeAll
    static void beforeAll() {
        System.out.println("**--- Ejecutando los test ---**");
    }

    @BeforeEach
    void init(){
        jugador = new Jugador("Test");
    }
    @DisplayName("Comprobando 3A, 2, 5, y Q")
    @Test
    void check_score_3A25Q(){

        jugador.addCard(new Carta(Valor.A,Palo.CLUB));
        jugador.addCard(new Carta(Valor.CINCO,Palo.CLUB));
        jugador.addCard(new Carta(Valor.A,Palo.CLUB));
        jugador.addCard(new Carta(Valor.DOS,Palo.CLUB));
        jugador.addCard(new Carta(Valor.A,Palo.CLUB));

        assertEquals(jugador.getPuntuacion(),20);
    }

    @DisplayName("Test para comprobar si se pasa")
    @Test
    void check_score_JJQ(){

        jugador.addCard(new Carta(Valor.J,Palo.CLUB));
        jugador.addCard(new Carta(Valor.J,Palo.CLUB));
        jugador.addCard(new Carta(Valor.Q,Palo.CLUB));

        assertEquals(jugador.getPuntuacion(),-1);
    }

    @DisplayName("Comprobando 3A, J")
    @Test
    void check_score_3A10(){

        jugador.addCard(new Carta(Valor.A,Palo.CLUB));
        jugador.addCard(new Carta(Valor.J,Palo.CLUB));
        jugador.addCard(new Carta(Valor.A,Palo.CLUB));
        jugador.addCard(new Carta(Valor.A,Palo.CLUB));

        assertEquals(jugador.getPuntuacion(),13);
    }
    @DisplayName("Comprobando 2A, J")
    @Test
    void check_score_2A10(){

        jugador.addCard(new Carta(Valor.J,Palo.CLUB));
        jugador.addCard(new Carta(Valor.A,Palo.CLUB));
        jugador.addCard(new Carta(Valor.A,Palo.CLUB));

        assertEquals(jugador.getPuntuacion(),12);
    }

    @DisplayName("Comprobando 4A, 6")
    @Test
    void check_score_4A6(){

        jugador.addCard(new Carta(Valor.A,Palo.CLUB));
        jugador.addCard(new Carta(Valor.A,Palo.CLUB));
        jugador.addCard(new Carta(Valor.SEIS,Palo.CLUB));
        jugador.addCard(new Carta(Valor.A,Palo.CLUB));
        jugador.addCard(new Carta(Valor.A,Palo.CLUB));

        assertEquals(jugador.getPuntuacion(),20);
    }
    @DisplayName("Comprobando 2A")
    @Test
    void check_score_2A(){

        jugador.addCard(new Carta(Valor.A,Palo.CLUB));
        jugador.addCard(new Carta(Valor.A,Palo.CLUB));

        assertEquals(12, jugador.getPuntuacion());
    }

    @AfterAll
    static void afterAll() {
        System.out.println("**---   Test finalizado   ---**");
    }
}
