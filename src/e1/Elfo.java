package e1;

public class Elfo extends Heroe{
    public Elfo(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    @Override
    public int atacar(Personaje personaje) {
        int dmg = this.dado.tirada();
        if(personaje instanceof Orco){
            dmg+=10;
        }
        return personaje.atacado(dmg);

    }
}
