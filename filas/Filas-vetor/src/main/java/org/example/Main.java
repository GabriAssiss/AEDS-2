package org.example;

public class Main {
    public static void main(String[] args) throws Exception {

        Fila<Object> fila1 = new Fila<>();

        fila1.inserir(1);
        fila1.inserir(2);
        fila1.inserir(4);
        fila1.inserir(-3);
        fila1.inserir(9);

        fila1.remover();

        fila1.imprimir();
    }
}