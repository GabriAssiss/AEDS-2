package org.example;

import java.util.HashMap;
import java.util.Map;

public class NotacaoPolonesa {

    private final static Pilha<Character> pilhaSinais = new Pilha<>();
    private final static Sinal sinais = new Sinal();


    public static String expressao(String expressao) {
        int i = 0;
        char[] expressaoConvertida = new char[expressao.length()];
        conversor(expressao, i,expressaoConvertida);
        return conversor(expressao, i,expressaoConvertida);
    }

    private static String conversor(String expressao, int i, char[] expressaoConvertida) {

        if(i < expressao.length() && sinais.getSinal().containsKey(expressao.charAt(i))) {
            manipularPilha(expressao, i, expressaoConvertida);
        }
        else if(i < expressao.length()) {
            expressaoConvertida[i] = expressao.charAt(i);
            conversor(expressao, i++, expressaoConvertida);
        }


        return new String(expressaoConvertida);
    }

    private static void manipularPilha(String expressao, int i, char[] expressaoConvertida) {
    }


}
