package e2;

public class Cancion {
    private String titulo;
    private String autor;
    private String estilo;

    public Cancion(String titulo, String autor, String estilo) {
        this.titulo = titulo;
        this.autor = autor;
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return titulo + " de " + autor + " (" + estilo + ")";
    }
}
