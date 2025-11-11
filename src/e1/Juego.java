package e1;

import java.util.ArrayList;

public class Juego {
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
    public void batalla(){
        int turno = 0;

        while((!this.azul.isEmpty() && !this.rojo.isEmpty())){
            System.out.printf("Turno %d: \n", turno);
            for (int i = 0; i < this.azul.size() && i < this.rojo.size(); i++) {
                Personaje pAzul = this.azul.get(i);
                Personaje pRojo = this.rojo.get(i);
                System.out.println(pAzul.getNombre()+" ("+pAzul.getVida()+"HP) ataca a "+pRojo.getNombre() +" ("+pRojo.getVida()+"HP)" );
                System.out.println(pAzul.getNombre()+" ("+pAzul.getVida()+"HP) le quita "+pAzul.atacar(pRojo)+"HP a  "+pRojo.getNombre() +" ("+pRojo.getVida()+"HP)" );
                if(pRojo.isMuerto()){
                    System.out.println(pRojo.getNombre() + " fue asesinado por "+pAzul.getNombre());
                    this.rojo.remove(pRojo);
                    if(this.rojo.size()>i){
                        pRojo = this.rojo.get(i);
                    }else{
                        break;
                    }

                }
                    System.out.println(pRojo.getNombre()+" ("+pRojo.getVida()+"HP) ataca a  "+pAzul.getNombre() +" ("+pAzul.getVida()+"HP)" );
                    System.out.println(pRojo.getNombre()+" ("+pRojo.getVida()+"HP) le quita "+pRojo.atacar(pAzul)+"HP a  "+pAzul.getNombre() +" ("+pAzul.getVida()+"HP)" );
                    if(pAzul.isMuerto()){
                        System.out.println(pAzul.getNombre() + " fue asesinado por "+pRojo.getNombre());
                        this.azul.remove(pAzul);


                    }

            }

            turno++;
        }
        if(this.azul.isEmpty()&&this.rojo.isEmpty()){
            System.out.println("EMPATE");
        } else if (this.azul.isEmpty()) {
            System.out.println("GANAN LOS ROJOS");
        }else{
            System.out.println("GANAN LOS AZULES");
        }
        System.out.println("END");
    }
}
