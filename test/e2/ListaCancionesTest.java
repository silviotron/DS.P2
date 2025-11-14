package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListaCancionesTest {
    private ListaCanciones lista;
    private Cancion c1, c2, c3, c4;

    @BeforeEach
    public void setUp() {
        lista = new ListaCanciones();
        c1 = new Cancion("Bohemian Rhapsody", "A Night at the Opera", "Queen", "Rock");
        c2 = new Cancion("Imagine", "Imagine", "John Lennon", "Pop");
        c3 = new Cancion("Billie Jean", "Thriller", "Michael Jackson", "Pop");
        c4 = new Cancion("Thriller", "Thriller", "Michael Jackson", "Pop");
    }

    @Test
    public void constructor() {
        assertEquals(0, lista.getPosicion());
        assertFalse(lista.isPlaying());
    }

    @Test
    public void add() {
        assertTrue(lista.add(c1));
        assertTrue(lista.add(c2));
        assertEquals(c1, lista.get(0));
        assertEquals(c2, lista.get(1));
    }

    @Test
    public void addEnPosicion() {
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        assertTrue(lista.add(1, c4));
        assertEquals(c1, lista.get(0));
        assertEquals(c4, lista.get(1));
        assertEquals(c2, lista.get(2));
    }

    @Test
    public void addEnPosicionInvalida() {
        lista.add(c1);
        assertFalse(lista.add(-1, c2));
        assertFalse(lista.add(10, c2));
    }

    @Test
    public void remove() {
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        assertEquals(c2, lista.remove(1));
        assertEquals(c3, lista.get(1));
    }

    @Test
    public void removePosicionInvalida() {
        lista.add(c1);
        assertNull(lista.remove(-1));
        assertNull(lista.remove(10));
    }

    @Test
    public void removeActualizaPosicionAntes() {
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.setPosicion(2);
        lista.remove(0);
        assertEquals(1, lista.getPosicion());
    }

    @Test
    public void removeActualizaPosicionActual() {
        lista.add(c1);
        lista.add(c2);
        lista.setPosicion(1);
        lista.remove(1);
        assertEquals(0, lista.getPosicion());
    }

    @Test
    public void move() {
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.add(c4);
        assertTrue(lista.move(0, 2));
        assertEquals(c2, lista.get(0));
        assertEquals(c1, lista.get(2));
    }

    @Test
    public void movePosicionInvalida() {
        lista.add(c1);
        lista.add(c2);
        assertFalse(lista.move(-1, 1));
        assertFalse(lista.move(1, 10));
    }

    @Test
    public void moveActualizaPosicionOrigen() {
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.setPosicion(0);
        lista.move(0, 2);
        assertEquals(2, lista.getPosicion());
    }

    @Test
    public void setPosicion() {
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.setPosicion(2);
        assertEquals(2, lista.getPosicion());
    }

    @Test
    public void setPosicionInvalida() {
        lista.add(c1);
        lista.add(c2);
        lista.setPosicion(-1);
        assertEquals(0, lista.getPosicion());
        lista.setPosicion(10);
        assertEquals(0, lista.getPosicion());
    }

    @Test
    public void playListaVacia() {
        assertNull(lista.play());
        assertFalse(lista.isPlaying());
    }

    @Test
    public void play() {
        lista.add(c1);
        lista.add(c2);
        assertEquals(c1, lista.play());
        assertTrue(lista.isPlaying());
    }

    @Test
    public void pause() {
        lista.add(c1);
        lista.play();
        lista.pause();
        assertFalse(lista.isPlaying());
    }

    @Test
    public void next() {
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.next();
        assertEquals(1, lista.getPosicion());
    }

    @Test
    public void nextCircular() {
        lista.add(c1);
        lista.add(c2);
        lista.setPosicion(1);
        lista.next();
        assertEquals(0, lista.getPosicion());
    }

    @Test
    public void nextReproduccion() {
        lista.add(c1);
        lista.add(c2);
        lista.play();
        lista.next();
        assertTrue(lista.isPlaying());
    }

    @Test
    public void previous() {
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.setPosicion(2);
        lista.previous();
        assertEquals(1, lista.getPosicion());
    }

    @Test
    public void previousCircular() {
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.setPosicion(0);
        lista.previous();
        assertEquals(2, lista.getPosicion());
    }

    @Test
    public void previousReproduccion() {
        lista.add(c1);
        lista.add(c2);
        lista.play();
        lista.previous();
        assertTrue(lista.isPlaying());
    }

    @Test
    public void ordenar() {
        lista.add(new Cancion("C", "Album", "Artista B", "Rock A"));
        lista.add(new Cancion("A", "Album", "Artist C", "Rock B"));
        lista.add(new Cancion("B", "Album", "Artist A", "Rock C"));
        lista.play();
        lista.setPosicion(2);
        lista.ordenar();
        assertEquals("A", lista.get(0).getTitulo());
        assertEquals("B", lista.get(1).getTitulo());
        assertEquals("C", lista.get(2).getTitulo());
        assertFalse(lista.isPlaying());
        assertEquals(0, lista.getPosicion());
    }

    @Test
    public void ordenarPorAutor() {
        lista.add(new Cancion("C", "Album", "Artista B", "Rock A"));
        lista.add(new Cancion("A", "Album", "Artista C", "Rock B"));
        lista.add(new Cancion("B", "Album", "Artista A", "Rock C"));
        lista.play();
        lista.setPosicion(2);
        lista.ordenar(new ComparadorPorAutor());
        assertEquals("Artista A", lista.get(0).getAutor());
        assertEquals("Artista B", lista.get(1).getAutor());
        assertEquals("Artista C", lista.get(2).getAutor());
        assertFalse(lista.isPlaying());
        assertEquals(0, lista.getPosicion());
    }

    @Test
    public void ordenarPorEstilo() {
        lista.add(new Cancion("C", "Album", "Artista B", "Rock A"));
        lista.add(new Cancion("A", "Album", "Artist C", "Rock B"));
        lista.add(new Cancion("B", "Album", "Artist A", "Rock C"));
        lista.play();
        lista.setPosicion(2);
        lista.ordenar(new ComparadorPorEstilo());
        assertEquals("Rock A", lista.get(0).getEstilo());
        assertEquals("Rock B", lista.get(1).getEstilo());
        assertEquals("Rock C", lista.get(2).getEstilo());
        assertFalse(lista.isPlaying());
        assertEquals(0, lista.getPosicion());
    }

    @Test
    public void pruebaToString() {
        lista.add(c1);
        String resultado = lista.toString();
        assertTrue(resultado.contains("posicion="));
        assertTrue(resultado.contains("play="));
        assertTrue(resultado.contains("canciones="));
    }
}
