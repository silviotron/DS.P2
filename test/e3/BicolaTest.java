package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BicolaTest {

    private Bicola<Integer> bicola;

    @BeforeEach
    void setUp() {
        bicola = new Bicola<>();
    }

    @Test
    void insertarYSacarIzquierda() {
        bicola.insertarIzq(10);
        bicola.insertarIzq(20);
        bicola.insertarIzq(30);

        assertEquals(30, bicola.sacarIzq());
        assertEquals(20, bicola.sacarIzq());
        assertEquals(10, bicola.sacarIzq());
    }

    @Test
    void insertarYSacarDerecha() {
        bicola.insertarDch(10);
        bicola.insertarDch(20);
        bicola.insertarDch(30);

        assertEquals(30, bicola.sacarDch());
        assertEquals(20, bicola.sacarDch());
        assertEquals(10, bicola.sacarDch());
    }

    @Test
    void insertarYSacarMixta() {
        bicola.insertarIzq(10);
        bicola.insertarDch(20);
        bicola.insertarIzq(30);
        bicola.insertarDch(40);

        assertEquals(30, bicola.obtenerIzq());
        assertEquals(40, bicola.obtenerDch());
        assertEquals(30, bicola.sacarIzq());
        assertEquals(40, bicola.sacarDch());
        assertEquals(10, bicola.sacarIzq());
        assertEquals(20, bicola.sacarDch());
    }

    @Test
    void obtenerSinSacar() {
        bicola.insertarIzq(10);
        bicola.insertarDch(20);

        assertEquals(10, bicola.obtenerIzq());
        assertEquals(20, bicola.obtenerDch());
        assertEquals(10, bicola.obtenerIzq());
        assertEquals(20, bicola.obtenerDch());
    }

    @Test
    void iteradorNormal() {
        bicola.insertarDch(1);
        bicola.insertarDch(2);
        bicola.insertarDch(3);
        bicola.insertarDch(4);

        Iterator<Integer> it = bicola.iterator();

        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
        assertEquals(4, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void iteradorInverso() {
        bicola.insertarDch(1);
        bicola.insertarDch(2);
        bicola.insertarDch(3);
        bicola.insertarDch(4);

        Iterator<Integer> it = bicola.iterator(true);

        assertTrue(it.hasNext());
        assertEquals(4, it.next());
        assertEquals(3, it.next());
        assertEquals(2, it.next());
        assertEquals(1, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void iteradorNormalCompleto() {
        bicola.insertarDch(10);
        bicola.insertarDch(20);
        bicola.insertarDch(30);

        int suma = 0;
        int contador = 0;
        for (Integer valor : bicola) {
            suma += valor;
            contador++;
        }

        assertEquals(60, suma);
        assertEquals(3, contador);
    }

    @Test
    void iteradorSinElementos() {
        Iterator<Integer> it = bicola.iterator();
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void iteradorInversoSinElementos() {
        Iterator<Integer> it = bicola.iterator(true);
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void toStringConElementos() {
        bicola.insertarDch(1);
        bicola.insertarDch(2);
        bicola.insertarDch(3);

        String resultado = bicola.toString();
        assertTrue(resultado.contains("1"));
        assertTrue(resultado.contains("2"));
        assertTrue(resultado.contains("3"));
    }

    @Test
    void operacionesConUnSoloElemento() {
        bicola.insertarIzq(42);

        assertEquals(42, bicola.obtenerIzq());
        assertEquals(42, bicola.obtenerDch());
        assertEquals(42, bicola.sacarIzq());
    }

    @Test
    void iteradorConUnSoloElemento() {
        bicola.insertarDch(99);

        Iterator<Integer> it = bicola.iterator();
        assertTrue(it.hasNext());
        assertEquals(99, it.next());
        assertFalse(it.hasNext());
    }
}