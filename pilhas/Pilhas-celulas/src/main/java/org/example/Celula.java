package org.example;

public class Celula<T> {
    public Celula<T> proximo;
    public T elemento;

    public Celula(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public Celula() {
        this.elemento = null;
        this.proximo = null;
    }
}
