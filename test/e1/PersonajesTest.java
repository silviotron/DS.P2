package e1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonajesTest {

    @BeforeEach
    void setUp() {
        Dado.setSeed(10);
    }

    @AfterEach
    void tearDown() {
        Dado.resetSeed();
    }

    @Test
    void elfoContraOrco() {
        Elfo elfo = new Elfo("Elfo", 100, 20);
        Orco orco = new Orco("Orco", 120, 30);

        int vidaAntes = orco.getVida();
        int dmg = elfo.atacar(orco);

        assertTrue(dmg >= 0);
        assertTrue(orco.getVida() <= vidaAntes);
        assertTrue(orco.getVida() >= 0);

        assertEquals(vidaAntes - dmg, orco.getVida());

    }

    @Test
    void hobbitContraTrasgo() {
        Hobbit hobbit = new Hobbit("Hobbit", 80, 10);
        Trasgo trasgo = new Trasgo("Trasgo", 90, 15);

        int vidaAntes = trasgo.getVida();
        int dmg = hobbit.atacar(trasgo);

        assertTrue(dmg >= 0);
        assertTrue(trasgo.getVida() <= vidaAntes);
        assertTrue(trasgo.getVida() >= 0);

        assertEquals(vidaAntes - dmg, trasgo.getVida());
    }

    @Test
    void orcoReduceArmadura() {
        Humano humano = new Humano("Humano", 100, 30);
        Orco orco = new Orco("Orco2", 120, 20);

        int vidaAntes = humano.getVida();
        int dmg = orco.atacar(humano);

        assertTrue(dmg >= 0);
        assertTrue(humano.getVida() <= vidaAntes);
        assertTrue(humano.getVida() >= 0);

        assertEquals(vidaAntes - dmg, humano.getVida());
    }

    @Test
    void personajeMuere() {
        Humano humano = new Humano("Humano2", 10, 0);
        Orco orco = new Orco("Orco3", 100, 0);

        while (!humano.isMuerto()) {
            orco.atacar(humano);
        }

        assertTrue(humano.isMuerto());
        assertEquals(0, humano.getVida());
    }

    @Test
    void ataqueSinDanoPorArmadura() {
        Humano humano = new Humano("Humano3", 100, 1000);
        Orco orco = new Orco("Orco4", 100, 0);

        int vidaAntes = humano.getVida();
        int dmg = orco.atacar(humano);

        assertEquals(vidaAntes, humano.getVida());
        assertEquals(0, dmg);
    }

    @Test
    void atacadoSinMorir() {
        Humano humano = new Humano("HumanoTest", 100, 0);

        int vidaAntes = humano.getVida();
        int dmg = humano.atacado(30);

        assertTrue(dmg >= 0);
        assertEquals(vidaAntes - dmg, humano.getVida());
        assertFalse(humano.isMuerto());
    }

    @Test
    void atacadoConMuerte() {
        Humano humano = new Humano("HumanoTest2", 10, 0);

        int dmg = humano.atacado(50);

        assertEquals(50, dmg);
        assertEquals(0, humano.getVida());
        assertTrue(humano.isMuerto());
    }
}