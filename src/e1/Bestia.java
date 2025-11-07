package e1;

public class Bestia extends Personaje {
    public Bestia(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura, new Dado(0,90,1));
    }
}
