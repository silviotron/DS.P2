package e2;

import java.util.Comparator;

public class ComparadorPorEstilo implements Comparator<Cancion> {
    @Override
    public int compare(Cancion c1, Cancion c2) {
        int cEstilo = c1.getEstilo().compareToIgnoreCase(c2.getEstilo());
        if (cEstilo != 0) {
            return cEstilo;
        }
        return c1.getTitulo().compareToIgnoreCase(c2.getTitulo());
    }
}

