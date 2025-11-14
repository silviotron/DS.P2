package e2;

import java.util.Comparator;

public class ComparadorPorAutor implements Comparator<Cancion> {
    @Override
    public int compare(Cancion c1, Cancion c2) {
        int cAutor = c1.getAutor().compareToIgnoreCase(c2.getAutor());
        if (cAutor != 0) {
            return cAutor;
        }
        int cAlbum = c1.getAlbum().compareToIgnoreCase(c2.getAlbum());
        if (cAlbum != 0) {
            return cAlbum;
        }
        return c1.getTitulo().compareToIgnoreCase(c2.getTitulo());
    }
}
