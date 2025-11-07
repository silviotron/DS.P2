package e1;

public abstract class Personaje {
    private String nombre;
    private int vida;
    private int armadura;
    Dado dado;
    private Boolean muerto;


    public Personaje(String nombre, int vida, int armadura, Dado dado) {
        this.nombre = nombre;
        this.vida = vida;
        this.armadura = armadura;
        this.dado = dado;
        this.muerto = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public boolean atacar(Personaje personaje) {
        return personaje.atacado(this.dado.tirada());
    }
    public boolean atacado(int dmg){
        if(this.armadura > dmg){
            this.vida-=dmg;

        }
        return this.vida<=0;
    }

    public int getArmadura() {
        return armadura;
    }

    @Override
    public String toString() {
        return nombre + " " + vida + "HP " + armadura+"Armour";
    }
}
