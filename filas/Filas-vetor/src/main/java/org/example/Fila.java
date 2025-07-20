package org.example;

public class Fila<E> {
    private E[] array;
    private int primeiro;
    private int ultimo;

    public Fila() {
        this(5);
    }

    public Fila(int tamanho) {
        this.array = (E[]) new Object[tamanho + 1];
        this.primeiro = 0;
        this.ultimo = 0;
    }

    public void inserir(E elemento) throws Exception {
        if((ultimo + 1) % array.length == primeiro)
            throw new Exception("Não há mais espaço no array para elementos!");
        this.array[ultimo] = elemento;
        ultimo = (ultimo + 1) % array.length;
    }

    public void remover() throws Exception {
        if(primeiro == ultimo) {
            throw new Exception("A fila está vazia!");
        }
        primeiro = (primeiro + 1) % array.length;
    }

    public void imprimir() throws Exception {
        if(primeiro == ultimo) {
            throw new Exception("A fila está vazia!");
        }
        int i = primeiro;
        while(i != ultimo) {
            System.out.println(array[i]+"\n");
            i = (i + 1) % array.length;
        }
    }
}
