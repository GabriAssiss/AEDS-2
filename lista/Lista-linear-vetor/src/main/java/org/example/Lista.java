package org.example;

public class Lista<E> {
    private E[] lista;
    private int primeiro;
    private int ultimo;

    public Lista() {
        this(5);
    }

    public Lista(int tamanho) {
        this.lista = (E[]) new Object[tamanho];
        primeiro = 0;
        ultimo = 0;
    }

    public boolean vazio() {
        return primeiro == ultimo;
    }

    public boolean cheio() {
        return ultimo == lista.length;
    }

    public void inserir(E elemento) throws Exception {
        if(cheio())
            throw  new Exception("Não é possível inserir mais elementos na lista.");
        lista[ultimo] = elemento;
        ultimo++;
    }

    public void inserir(E elemento, int pos) throws Exception {
        if(cheio())
            throw  new Exception("Não é possível inserir mais elementos na lista.");
        if(pos < 0 || pos > ultimo)
            throw new Exception("Não é possível inserir o elemento na posição desejada.");

        for(int i = ultimo; i > pos; i--) {
            lista[i] = lista[i-1];
        }
        lista[pos] = elemento;
        ultimo++;
    }

    public void remover() throws Exception {
        if(vazio())
            throw new Exception("Não há itens para remover.");
        for(int i = primeiro+1; i < ultimo; i++) {
            lista[i-1] = lista[i];
        }
        ultimo--;
    }

    public void remover(int pos) throws Exception {
        if(vazio())
            throw new Exception("Não há itens para remover.");
        if(pos < 0 || pos > ultimo)
            throw new Exception("Não é possível remover o elemento na posição desejada.");
        for(int i = pos+1; i < ultimo; i++) {
            lista[i-1] = lista[i];
        }
        ultimo--;

    }

    public void mostrar() throws Exception {
        if(vazio())
            throw new Exception("Não há itens para mostrar.");

        int i = primeiro;
        while(i < ultimo) {
            System.out.println(lista[i] + " ");
            i++;
        }
        System.out.println("\n");
    }

}
