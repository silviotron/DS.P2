package e1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DadoTest {

    @BeforeEach
    void setUp() {
        Dado.setSeed(1);
    }

    @AfterEach
    void tearDown() {
        Dado.resetSeed();
    }

    @Test
    void setSeed() {
        Dado.setSeed(5);
        Dado d1 = new Dado(0, 10, 1);
        int a = d1.tirada();
        int b = d1.tirada();

        Dado.setSeed(5);
        Dado d2 = new Dado(0, 10, 1);
        int c = d2.tirada();
        int d = d2.tirada();

        assertEquals(a, c);
        assertEquals(b, d);
    }

    @Test
    void resetSeed() {
        Dado.setSeed(7);
        Dado d1 = new Dado(0, 10, 1);
        int a = d1.tirada();

        Dado.resetSeed();
        Dado d2 = new Dado(0, 10, 1);
        int b = d2.tirada();

        assertNotEquals(a, b);
    }

    @Test
    void tirada() {
        Dado d = new Dado(0, 10, 2);
        int v = d.tirada();
        assertTrue(v >= 0 && v <= 10);
    }
}