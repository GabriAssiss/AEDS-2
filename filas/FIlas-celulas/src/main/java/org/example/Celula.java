package org.example;

public class Celula<E> {

    public E elemento;
    public Celula<E> proximo;

    public Celula(E elemento) {
        this.elemento = elemento;
        this.proximo = null;
        
    }

    public Celula() {

    }
}
