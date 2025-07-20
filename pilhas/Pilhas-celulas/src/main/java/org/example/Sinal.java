package org.example;

import java.util.HashMap;
import java.util.Map;

public class Sinal {
    private final Map<Character, Integer> sinal = new HashMap<>();

    public Map<Character, Integer> getSinal() {
        return sinal;
    }

    public Sinal() {
        sinal.put('(', 1);
        sinal.put(')', 1);
        sinal.put('+', 2);
        sinal.put('-', 2);
        sinal.put('–', 2);
        sinal.put('*', 3);
        sinal.put('/', 3);
        sinal.put('^', 4);
    }
}
