package e1;

public abstract class Personaje {
    private String nombre;
    private int vida;
    private int armadura;
    protected Dado dado;
    private Boolean muerto;


    public Personaje(String nombre, int vida, int armadura, Dado dado) {
        this.nombre = nombre;
        this.vida = vida;
        this.armadura = armadura;
        this.dado = dado;
        this.muerto = false;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int atacar(Personaje personaje) {
        return personaje.atacado(this.dado.tirada());
    }
    public int atacado(int dmg){
        int realDmg = Math.max(dmg-this.armadura,0);
        this.vida -= realDmg;
        if(this.vida <= 0){
            this.muerto = true;
            this.vida = 0;
        }

        return realDmg;
    }

    public int getArmadura() {
        return armadura;
    }

    @Override
    public String toString() {
        return nombre + " " + vida + "HP ";
    }
}
