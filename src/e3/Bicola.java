package e3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Bicola<E> implements Iterable<E>{
    private LinkedList<E> bicola = new LinkedList<E>();

    public void insertarIzq(E e){
        bicola.addFirst(e);
    }

    public void insertarDch(E e){
        bicola.addLast(e);
    }

    public E sacarIzq(){
        return bicola.removeFirst();
    }

    public E sacarDch(){
        return bicola.removeLast();
    }

    public E obtenerIzq(){
        return bicola.getFirst();
    }

    public E obtenerDch(){
        return bicola.getLast();
    }

    @Override
    public String toString() {
        return bicola.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new bicolaIterator(false);
    }


    public Iterator<E> iterator(Boolean inverso) {
        return new bicolaIterator(inverso);
    }

    private class bicolaIterator implements Iterator<E>{
        private int indice;
        private boolean inverso;
        private int tamano;

        public bicolaIterator(Boolean inverso) {
            this.inverso = inverso;
            this.tamano = bicola.size();
            this.indice = inverso?tamano-1:0;
        }

        @Override
        public boolean hasNext() {
            return inverso?indice >= 0: indice < tamano;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return bicola.get(inverso?indice--:indice++);
        }
    }

}
