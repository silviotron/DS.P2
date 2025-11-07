package e1;

import java.util.ArrayList;

public class Juego {
    //TODO: toda la logica de batalla entre ejercitos usando ArrayList.b
    //TODO: yo diria de hacer que en vez de ejercito azul vs rojo fuera un aray de tamaño 2 para que se pudiera escalar, por ahora lo dejo asi que es lo que pide
    private ArrayList<Personaje> azul;
    private ArrayList<Personaje> rojo;

    public Juego(ArrayList<Personaje> azules, ArrayList<Personaje> rojos) {
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
//TODO: ahora solo falta matar a los que estan muertos antes de pasar al siguiente turno, tenemos los 2 arrays con los muertos es solo vaciar esas posiciones de cada array en principio en sentido inverso, es decir primero eliminar al personaje con id mas alta y ya esta
//TODO: nose porque no pasa al siguiente turno como tal y la vida es tan negativa.
    public void batalla(){

        while(this.azul.size()>0 || this.rojo.size() > 0){
            int turno = 0;
            ArrayList<Integer> muertoAzul = new ArrayList<>();
            ArrayList<Integer> muertoRojo = new ArrayList<>();
            System.out.printf("Turno %d: \n", turno);
            for (int i = 0; i < this.azul.size() && i < this.rojo.size(); i++) {
                Personaje personajeAzul = this.azul.get(i);
                Personaje personajeRojo = this.rojo.get(i);
                System.out.println(personajeAzul.getNombre()+" ("+personajeAzul.getVida()+"HP) ataca a  "+personajeRojo.getNombre() +" ("+personajeRojo.getVida()+"HP)" );
                if(personajeAzul.atacar(personajeRojo)){
                    System.out.println(personajeRojo.getNombre() + " fue asesinado por "+personajeAzul.getNombre());
                    muertoRojo.add(i);
                }else{
                    System.out.println(personajeRojo.getNombre()+" ("+personajeRojo.getVida()+"HP) ataca a  "+personajeAzul.getNombre() +" ("+personajeAzul.getVida()+"HP)" );
                    if(personajeRojo.atacar(personajeAzul)){
                        System.out.println(personajeAzul.getNombre() + " fue asesinado por "+personajeRojo.getNombre());
                        muertoAzul.add(i);
                    }
                }
            }
            for(int i = muertoAzul.size()-1; i >= 0; i--) {
                this.azul.remove(muertoAzul.get(i));
            }
            for(int i = muertoRojo.size()-1; i >= 0; i--) {
                this.azul.remove(muertoRojo.get(i));
            }
            turno++;
        }
        System.out.println("END");
    }
}
