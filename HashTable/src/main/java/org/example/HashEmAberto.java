package org.example;

import java.util.NoSuchElementException;

public class HashEmAberto<K,V> implements HashTable<K,V> {

    private Entrada<K, V>[] tabela;
    private int capacidade;


    public HashEmAberto(int capacidade) {
        this.capacidade = capacidade;
        this.tabela = new Entrada[capacidade];
    }

    @Override
    public int inserir(K chave, V valor) {
        int tentativas = 0;
        int pos = funcaoHash(chave, tentativas);
        boolean inseriu = false;

        while(pos < capacidade && !inseriu) {
            if(tabela[pos] == null || tabela[pos].isRemovida()) {
                tabela[pos] = new Entrada<>(chave, valor);
                inseriu = true;
            }
            else if (this.tabela[pos].getChave().equals(chave))
                throw new IllegalArgumentException("O item já havia sido inserido anteriormente na tabela hash!");
            else {
                pos = funcaoHash(chave, tentativas++);
            }
        }

        if(inseriu)
            return pos;
        else
            throw new IllegalStateException("O item não pode ser inserido na tabela.");
    }

    public int funcaoHash(K chave, int tentativas) {
        return Math.abs(chave.hashCode() + tentativas) % capacidade;
    }

    @Override
    public V remover(K chave) {
        int tentativas = 0;
        int pos = funcaoHash(chave, tentativas);
        while(pos < capacidade) {
            if(tabela[pos] == null)
                throw new NoSuchElementException("Elemento não encontrado!");
            else if(tabela[pos].getChave().equals(chave) || !tabela[pos].isRemovida()) {
                tabela[pos].setRemovida(true);
                return tabela[pos].getValor();
            }
            else {
                pos = funcaoHash(chave, tentativas++);
            }
        }
        throw new NoSuchElementException("Elemento não encontrado!");
    }

    @Override
    public V pesquisar(K chave) {
        if(tabela.length == 0)
            throw new NoSuchElementException("Não há elementos na lista.");
        int tentativas = 0;
        int pos = funcaoHash(chave, tentativas);
        while(pos < capacidade) {
            if(tabela[pos] == null) {
                throw new NoSuchElementException("Não há elementos na lista.");
            }
            else if(tabela[pos].getChave().equals(chave) && !tabela[pos].isRemovida()) {
                return tabela[pos].getValor();
            }
            else
                pos = funcaoHash(chave, tentativas++);
        }
        throw new IllegalArgumentException("Elemento não encontrado.");
    }

    @Override
    public void imprimir() {
        for(int i = 0; i < capacidade; i++) {
            System.out.println("Posição [" + i + "]");
            if(tabela[i] == null || tabela[i].isRemovida()) {
                System.out.println("Posição vazia.");
            }
            else
                System.out.println(tabela[i]);
        }
    }

    public boolean vazia() {
        for(int i = 0; i < capacidade; i++) {
            if(tabela[i] != null && !(tabela[i].isRemovida()))
                return false;
        }
        return true;
    }
}
