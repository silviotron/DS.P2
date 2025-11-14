package e1;

public abstract class Heroe extends Personaje {
    public Heroe(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura , new Dado(0,100,2));
    }
}
