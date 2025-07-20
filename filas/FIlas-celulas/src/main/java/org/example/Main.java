package org.example;

public class Main {
    public static void main(String[] args) throws Exception {

        Fila f1 = new Fila();
        f1.push(1);
        f1.push(2);
        f1.push(3);
        f1.push(4);

        //f1.show();

        Fila f2 = new Fila();
        f2.push(1);
        f2.push(2);
        f2.push(4);
        f2.push(4);

        //f2.show();

        //f1.concatenar(f2);
        //f1.show();
       // System.out.println(f1.obterNumeroItens());
        f1.dividir().show();
        f1.show();
    }
}