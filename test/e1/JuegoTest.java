package e1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JuegoTest {

    @BeforeEach
    void setUp() {
        Dado.setSeed(20);
    }

    @AfterEach
    void tearDown() {
        Dado.resetSeed();
    }

    @Test
    void batallaDevuelveGanadorOEmpate() {
        ArrayList<Personaje> azul = new ArrayList<>();
        ArrayList<Personaje> rojo = new ArrayList<>();

        azul.add(new Elfo("Elfo", 150, 30));
        azul.add(new Humano("Humano", 50, 40));
        azul.add(new Hobbit("Hobbit", 20, 10));

        rojo.add(new Orco("Orco", 190, 40));
        rojo.add(new Orco("Orco2", 290, 30));

        Juego juego = new Juego(azul, rojo);
        ArrayList<String> log = juego.batalla();

        assertFalse(log.isEmpty());
        assertEquals("END", log.getLast());
    }

    @Test
    void batallaEmpateConListasVacias() {
        ArrayList<Personaje> azul = new ArrayList<>();
        ArrayList<Personaje> rojo = new ArrayList<>();

        Juego juego = new Juego(azul, rojo);
        ArrayList<String> log = juego.batalla();

        assertFalse(log.isEmpty());
        String penultima = log.get(log.size() - 2);
        assertTrue(penultima.contains("EMPATE"));
        assertEquals("END", log.getLast());
    }
}
