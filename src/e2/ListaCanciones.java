package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        if (index < 0 || index >= this.canciones.size()) {
            return null;
        }
        if (index < this.posicion) {
            this.posicion--;
        } else if (index == this.posicion && this.posicion >= this.canciones.size() - 1) {
            this.posicion = this.canciones.size() - 2;
            if (this.posicion < 0) {
                this.posicion = 0;
            }
        }
        return this.canciones.remove(index);
    }

    public boolean move(int from,int to){
        if (from < 0 || from >= this.canciones.size()) {
            return false;
        }
        if (to < 0 || to >= this.canciones.size()) {
            return false;
        }
        Cancion cancion = this.canciones.remove(from);
        this.canciones.add(to, cancion);
        if (from == this.posicion) {
            this.posicion = to;
        } else if (from < this.posicion && to >= this.posicion) {
            this.posicion--;
        } else if (from > this.posicion && to <= this.posicion) {
            this.posicion++;
        }
        return true;
    }

    public int getPosicion() {
        return this.posicion;
    }

    public void setPosicion(int posicion) {
        if (posicion >= 0 && posicion < this.canciones.size()) {
            this.posicion = posicion;
        }
    }

    public boolean isPlaying() {
        return this.play;
    }

    public Cancion play(){
        if(this.canciones.isEmpty()){
          return null;
        }
        this.play = true;
        return canciones.get(this.posicion);
    }
    public void pause(){
        this.play = false;
    }

    public void next(){
        if (this.posicion >= this.canciones.size()-1) {
            this.posicion=0;
        }
        else {
            this.posicion++;
        }
        if (this.play) {
            this.play();
        }
    }
    public void previous(){
        if (this.posicion == 0) {
            this.posicion=this.canciones.size()-1;
        }
        else {
            this.posicion--;
        }
        if (this.play) {
            this.play();
        }
    }

    public void ordenar() {
        Collections.sort(this.canciones);
        this.play = false;
        this.posicion = 0;
    }

    public void ordenar(Comparator<Cancion> comparador) {
        Collections.sort(this.canciones, comparador);
        this.play = false;
        this.posicion = 0;
    }

    @Override
    public String toString() {
        return
                "posicion=" + posicion +'\n'+
                "play=" + play + '\n' +
                "canciones=" + canciones ;
    }
}
