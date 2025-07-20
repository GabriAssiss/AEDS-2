package org.example;

public class Main {
    public static void main(String[] args) throws Exception {

        Lista<Object> list = new Lista<>();


        list.inserir(2);
        list.inserir(4);
        list.inserir(6);
        list.inserir(6);
        list.inserir(7, 2);
        list.mostrar();
        list.remover(1);
        list.mostrar();
    }

}