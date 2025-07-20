package org.example;

import java.util.Objects;

public class Entrada<K, V> {
    private K chave;
    private V valor;
    private boolean removida;

    public Entrada(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
        setRemovida(false);

    }

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public boolean isRemovida() {
        return removida;
    }

    public void setRemovida(boolean removida) {
        this.removida = removida;
    }

    @Override
    public String toString() {
        return "chave=" + chave +
                ", valor=" + valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Entrada<K, V> entrada = (Entrada<K, V>) o;
        return Objects.equals(chave, entrada.chave);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(chave);
    }
}
