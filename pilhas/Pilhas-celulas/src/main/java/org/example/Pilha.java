package org.example;

public class Pilha<T> {
    private Celula<T> topo;
    private Celula<T> fundo;

    public Pilha() {
        Celula<T> sentinela = new Celula<>();
        this.topo = sentinela;
        this.fundo = sentinela;
    }

    public boolean isEmpty() {
        return fundo == topo;
    }

    public Celula<T> getTopo() {
        return topo;
    }

    public Celula<T> getFundo() {
        return fundo;
    }

    public void push(T elemento) {
        Celula<T> novoElemento = new Celula<>(elemento);
        novoElemento.proximo = this.topo;
        this.topo = novoElemento;
    }

    public void pop() {
        this.topo = topo.proximo;
    }

    public void show() {
        Celula<T> c = null;
        if(isEmpty()){
            System.out.println("No elements");
        }
        for(c = this.topo; c != fundo; c = c.proximo){
            System.out.print(c.elemento + "\n");
        }
        System.out.println("\n");
    }
}
