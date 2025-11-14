package e2;

public class Cancion implements Comparable<Cancion>{
    private String titulo;
    private String album;
    private String autor;
    private String estilo;
    public Cancion(String titulo, String album, String autor, String estilo) {
        this.titulo = titulo;
        this.album = album;
        this.autor = autor;
        this.estilo = estilo;
    }

    @Override
    public int compareTo(Cancion o) {
        java.util.Objects.requireNonNull(o);
        int c = this.titulo.compareToIgnoreCase(o.titulo);
        if(c==0){
            return this.album.compareToIgnoreCase(o.album);
        }
        return c;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAlbum() {
        return album;
    }

    public String getAutor() {
        return autor;
    }

    public String getEstilo() {
        return estilo;
    }

    @Override
    public String toString() {
        return titulo + " de " + autor + " (" + estilo + ")";
    }
}
