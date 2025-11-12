package e3;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;

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
        private int indice = 0;
        private boolean   inverso = false;
        public bicolaIterator(Boolean inverso) {
            this.inverso = inverso;
            this.indice = inverso?bicola.size()-1:0;
        }

        @Override
        public boolean hasNext() {
            return inverso?indice >= 0: indice < bicola.size();
        }

        @Override
        public E next() {
            return bicola.get(inverso?indice--:indice++);
        }
    }

}
