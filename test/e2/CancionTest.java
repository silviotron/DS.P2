package e2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CancionTest {

    @Test
    public void constructorYGetters() {
        Cancion cancion = new Cancion("Bohemian Rhapsody", "A Night at the Opera", "Queen", "Rock");
        assertEquals("Bohemian Rhapsody", cancion.getTitulo());
        assertEquals("A Night at the Opera", cancion.getAlbum());
        assertEquals("Queen", cancion.getAutor());
        assertEquals("Rock", cancion.getEstilo());
    }

    @Test
    public void compararTitulosDiferentes() {
        Cancion c1 = new Cancion("Imagine", "Imagine", "John Lennon", "Pop");
        Cancion c2 = new Cancion("Yesterday", "Help!", "The Beatles", "Pop");
        assertNotEquals(0,c1.compareTo(c2));
    }

    @Test
    public void compararTitulosIgualesAlbumesDiferentes() {
        Cancion c1 = new Cancion("Yesterday", "Help?", "The Beatles", "Rock");
        Cancion c2 = new Cancion("Yesterday", "Help!", "The Beatles", "Rock");
        assertNotEquals(0,c1.compareTo(c2));
    }

    @Test
    public void compararCancionesIguales() {
        Cancion c1 = new Cancion("Imagine", "Imagine", "John Lennon", "Rock");
        Cancion c2 = new Cancion("Imagine", "Imagine", "Paul McCartney", "Pop");
        assertEquals(0, c1.compareTo(c2));
    }

    @Test
    public void compararIgnoraCase() {
        Cancion c1 = new Cancion("imagine", "IMAGINE", "John Lennon", "Pop");
        Cancion c2 = new Cancion("IMAGINE", "imagine", "John Lennon", "Pop");
        assertEquals(0, c1.compareTo(c2));
    }

    @Test
    public void compararConNull() {
        Cancion cancion = new Cancion("Imagine", "Imagine", "John Lennon", "Pop");
        assertThrows(NullPointerException.class, () -> cancion.compareTo(null));
    }

    @Test
    public void pruebaToString() {
        Cancion cancion = new Cancion("Imagine", "Imagine", "John Lennon", "Rock");
        assertEquals("Imagine de John Lennon (Rock)", cancion.toString());
    }
}
