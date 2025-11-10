package e1;

public class Hobbit extends Heroe{
    public Hobbit(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }
    @Override
    public int atacar(Personaje personaje) {
        int dmg = this.dado.tirada();
        if(personaje instanceof Trasgo){
            dmg-=5;
            if(dmg<0){
                dmg = 0;
            }
        }
        return personaje.atacado(dmg);

    }
}
