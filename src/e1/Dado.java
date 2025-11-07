package e1;

public class Dado {
    private int min;
    private int max;
    private int tiradas;
    private static java.util.Random random = new java.util.Random();

    public static void seed(int seed){
        random = new java.util.Random(seed);
    }
    public static void seed(){
        random = new java.util.Random();
    }

    //TODO: en teoria todos tendrian que ser positivos, min menor que max y tiradas mas que cero.
    //TODO: dado "trucado" dado con seed.
    public Dado(int min, int max, int tiradas) {
        this.min = min;
        this.max = max;
        this.tiradas = tiradas;
    }

    public int tirada(){
        int resultado = 0;
        for (int i = 0; i < tiradas; i++) {
            int tirada = (int) (random.nextFloat() * (max - min + 1) + min);
            if (tirada > resultado) {
                resultado = tirada;
            }
        }
        return resultado;
    }
}
