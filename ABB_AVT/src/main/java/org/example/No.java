package org.example;

public class No<T extends Comparable<T>> {
    private T item;
    private No<T> direita;
    private No<T> esquerda;
    private int altura;;

    public No() {
        this.item = null;
        this.direita = null;
        this.esquerda = null;
        this.altura = 0;
    }

    public No(T item) {
        this.item = item;
        this.direita = null;
        this.esquerda = null;
        this.altura = 0;
    }

    public No(T item, No<T> direita, No<T> esquerda) {
        this.item = item;
        this.direita = direita;
        this.esquerda = esquerda;
        this.altura = 0;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public No<T> getDireita() {
        return direita;
    }

    public void setDireita(No<T> direita) {
        this.direita = direita;
    }

    public No<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No<T> esquerda) {
        this.esquerda = esquerda;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura() {
        if(direita.getAltura() > esquerda.getAltura())
            this.altura = direita.getAltura() + 1;
        else
            this.altura = esquerda.getAltura() + 1;
    }

    public No<T> clone() {
        return new No<>(this.item);
    }

}
