package es.ieslavereda.Inheritance.E1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultimediaTest {

    @Test
    @DisplayName("Testing equals method")
    void testEquals() {
        Multimedia m1 = new Multimedia("Un titulo","Un autor",Formato.AVI,32);
        Multimedia m2 = new Multimedia("Un titulo","Un autor",Formato.AVI,32);

        assertEquals(m1,m2);
    }
}