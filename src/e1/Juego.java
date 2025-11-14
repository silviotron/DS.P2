package e1;

import java.util.ArrayList;

public class Juego {

    private ArrayList<Personaje> azul;
    private ArrayList<Personaje> rojo;

    public Juego(ArrayList<Personaje> azul, ArrayList<Personaje> rojo) {
        this.azul = azul;
        this.rojo = rojo;
    }

    public Juego() {
        this.azul = new ArrayList<Personaje>();
        this.rojo = new ArrayList<Personaje>();
    }

    public Boolean addAzul(Personaje personaje) {
        return this.azul.add(personaje);
    }
    public Boolean addRojo(Personaje personaje) {
        return this.rojo.add(personaje);
    }

    public ArrayList<String> batalla(){
        ArrayList<String> resultado = new ArrayList<String>();
        int turno = 1;

        while(!this.azul.isEmpty() && !this.rojo.isEmpty()){
            resultado.add("Turno " + turno + ":");
            for (int i = 0; i < this.azul.size() && i < this.rojo.size(); i++) {
                Personaje pAzul = this.azul.get(i);
                Personaje pRojo = this.rojo.get(i);

                int vidaInicialRojo = pRojo.getVida();
                int dmgAzul = pAzul.atacar(pRojo);
                resultado.add(pAzul.getNombre()+" ("+pAzul.getVida()+"HP) ataca a "+pRojo.getNombre()+" ("+vidaInicialRojo+"HP) y le quita "+dmgAzul+"HP (ahora "+pRojo.getNombre()+" tiene "+pRojo.getVida()+"HP)");

                if(pRojo.isMuerto()){
                    resultado.add(pRojo.getNombre() + " fue asesinado por "+pAzul.getNombre());
                    this.rojo.remove(i);
                    i--;
                } else {
                    int vidaInicialAzul = pAzul.getVida();
                    int dmgRojo = pRojo.atacar(pAzul);
                    resultado.add(pRojo.getNombre()+" ("+pRojo.getVida()+"HP) ataca a "+pAzul.getNombre()+" ("+vidaInicialAzul+"HP) y le quita "+dmgRojo+"HP (ahora "+pAzul.getNombre()+" tiene "+pAzul.getVida()+"HP)");

                    if(pAzul.isMuerto()){
                        resultado.add(pAzul.getNombre() + " fue asesinado por "+pRojo.getNombre());
                        this.azul.remove(i);
                        i--;
                    }
                }
            }

            turno++;
        }
        if(this.azul.isEmpty()&&this.rojo.isEmpty()){
            resultado.add("EMPATE");
        } else if (this.azul.isEmpty()) {
            resultado.add("GANAN LOS ROJOS");
        }else{
            resultado.add("GANAN LOS AZULES");
        }
        resultado.add("END");
        return resultado;
    }
}
