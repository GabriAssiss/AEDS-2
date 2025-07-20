package org.example;

import java.util.List;
import java.util.NoSuchElementException;

public class HashSeparado<K, V> implements HashTable<K, V>{

    private Lista<Entrada<K, V>>[] tabela;
    private int capacidade;

    public HashSeparado(int capacidade) {
        this.tabela = (Lista<Entrada<K, V>>[]) new Lista[capacidade];
        this.capacidade = capacidade;

        for (int i = 0; i < this.capacidade; i++)
            this.tabela[i] = new Lista<>();
    }

    @Override
    public int inserir(K chave, V valor) {
        Entrada<K, V> item = new Entrada<>(chave, valor);
        int pos = funcaoHash(chave);
        try {
            tabela[pos].pesquisar(item);
            throw new IllegalArgumentException("Item já está na tabela");
        }
        catch(NoSuchElementException e) {
            tabela[pos].inserirFinal(item);
            return pos;
        }
    }

    public int funcaoHash(K chave) {
        return Math.abs(chave.hashCode()) % capacidade;
    }

    @Override
    public V remover(K chave) {
        int pos = funcaoHash(chave);
        Entrada<K, V> entrada = new Entrada<>(chave , null);
        return tabela[pos].remover(entrada).getValor();
    }

    @Override
    public V pesquisar(K chave) {
        int pos = funcaoHash(chave);
        Entrada<K, V> procurado = new Entrada<>(chave , null);
        return tabela[pos].pesquisar(procurado).getValor();
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < capacidade; i++) {
            if(!tabela[i].vazia())
                tabela[i].imprimir();
        }
    }

    public Lista<Entrada<K,V>> obterTodasAsEntradas() {
        Lista<Entrada<K,V>> listaComTodasAsEntradas = new Lista<>();
        for(int i = 0; i < capacidade; i++) {
            listaComTodasAsEntradas.fundirListas(tabela[i]);
        }
        return listaComTodasAsEntradas;
    }

    public Lista<K> obterTodasChaves() {
        Lista<Entrada<K, V>> tudo = obterTodasAsEntradas();
        Lista<K> todasAsChaves = new Lista<>();

        for(Celula<Entrada<K,V>> c = tudo.getPrimeiro().getProximo(); c != null; c = c.getProximo()) {
            todasAsChaves.inserirFinal(c.getItem().getChave());
        }

        return todasAsChaves;
    }

    public Lista<Entrada<K, V>>[] getTabela() {
        return tabela;
    }

    public void setTabela(Lista<Entrada<K, V>>[] tabela) {
        this.tabela = tabela;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

}
