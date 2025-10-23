package e2;

import java.util.ArrayList;

public class ListaCanciones {
    private ArrayList<Cancion> canciones;
    private int posicion;
    private boolean play;

    public ListaCanciones() {
        this.play = false;
        this.canciones = new ArrayList<>();
    }
    public Cancion get(int index){
        return this.canciones.get(index);
    }

    public boolean add(Cancion cancion) {
        return this.canciones.add(cancion);
    }
    public boolean add(int index,Cancion cancion) {
        if (index < 0 || index > this.canciones.size()) {
            return false;
        }
        this.canciones.add(index,cancion);
        return true;
    }

    public Cancion remove(int index) {
        if (index < 0 || index > this.canciones.size()) {
            return null;
        }
        if (index >= this.posicion) {
            this.posicion--;
        }
        return this.canciones.remove(index);
    }
    //TODO: mira que los return false estan bien
    public boolean move(int from,int to){
        if (from < 0 || from > this.canciones.size()) {
            return false;
        }
        if (to < 0 || to > this.canciones.size()-1) {
            return false;
        }
        Cancion cancion = this.remove(from);
        return this.add(to,cancion);

    }

    public Cancion play(){
        if(this.canciones.isEmpty()){
          return null;
        }
        return canciones.get(this.posicion);
    }
    public void pause(){
        this.play = false;
    }

    public void next(){
        if (this.posicion == this.canciones.size()-1) {
            this.posicion=0;
        }
        else {
            this.posicion++;
        }
    }
    public void previous(){
        if (this.posicion == 0) {
            this.posicion=this.canciones.size()-1;
        }
        else {
            this.posicion++;
        }
    }


    @Override
    public String toString() {
        return "canciones=" + canciones +'\n'+
                "posicion=" + posicion +'\n'+
                "play=" + play ;
    }
}
