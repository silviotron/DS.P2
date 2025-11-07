package e1;

public class Orco extends Bestia{
    public Orco(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    @Override
    public boolean atacar(Personaje personaje) {
        int dmg  = this.dado.tirada()+(int)(personaje.getArmadura()*0.1);
        return personaje.atacado(dmg);

    }
}
