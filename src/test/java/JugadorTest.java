import es.ieslavereda.Cartas.Carta;
import es.ieslavereda.Cartas.Jugador;
import es.ieslavereda.Cartas.Palo;
import es.ieslavereda.Cartas.Valor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testeo de obtencion de la puntuacion de un Jugador")
public class JugadorTest {

    private Jugador jugador;

    @BeforeEach
    void init(){
        jugador = new Jugador("Test");
    }
    @Test
    void check_score_3A25Q(){

        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));
        jugador.addCard(new Carta(Valor.CINCO,Palo.CLUB));
        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));
        jugador.addCard(new Carta(Valor.DOS,Palo.CLUB));
        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));

        assertEquals(jugador.getPuntuacion(),20);
    }
    @Test
    void check_score_JJQ(){

        jugador.addCard(new Carta(Valor.DIEZ,Palo.CLUB));
        jugador.addCard(new Carta(Valor.DIEZ,Palo.CLUB));
        jugador.addCard(new Carta(Valor.ONCE,Palo.CLUB));

        assertEquals(jugador.getPuntuacion(),-1);
    }
    @Test
    void check_score_3A10(){

        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));
        jugador.addCard(new Carta(Valor.DIEZ,Palo.CLUB));
        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));
        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));

        assertEquals(jugador.getPuntuacion(),13);
    }
    @Test
    void check_score_2A10(){

        jugador.addCard(new Carta(Valor.DIEZ,Palo.CLUB));
        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));
        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));

        assertEquals(jugador.getPuntuacion(),12);
    }

    @Test
    void check_score_4A6(){

        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));
        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));
        jugador.addCard(new Carta(Valor.SEIS,Palo.CLUB));
        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));
        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));

        assertEquals(jugador.getPuntuacion(),20);
    }
    @Test
    void check_score_2A(){

        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));
        jugador.addCard(new Carta(Valor.UNO,Palo.CLUB));

        assertEquals(jugador.getPuntuacion(),12);
    }

}
