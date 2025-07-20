package org.example;

public class Main {
    public static void main(String[] args) {

        /*Ordem de prioridade
        *
        * ^  == 4
        * /* == 3
        * +- == 2
        * (  == 1
        * */



        String expressao = "3 + 5 * (7 - 2) / 4";

        String nums = "12  3 42 2";

        System.out.println(NotacaoPolonesa.expressao(expressao));
    }
}