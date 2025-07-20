package org.example;

public class Pilha<E> {
    private E[] array;
    private int topo;

    public Pilha() {
        this(5);
    }

    public Pilha(int tamanho) {
        this.array = (E[]) new Object[tamanho];
        this.topo = 0;
    }

    public boolean cheia() {
        return topo == array.length;
    }

    public boolean vazia() {
        return topo == 0;
    }

    public E consultarTopo() {
        return array[topo-1];
    }

    public void inserir(E elemento) throws Exception {
        if(cheia())
            throw new Exception("O Limite de elementos da pilha foi excedido");
        array[topo] = elemento;
        topo++;
    }

    public void remover() {
        topo--;
    }

    public void mostrar() {
        int i = 0;
        while(i != topo) {
            System.out.print(array[i]+ " ");
        }
        System.out.println("\n");
    }

}
