package org.example;

public interface HashTable<K, V> {
    int inserir(K chave, V valor);
    V remover(K chave);
    V pesquisar(K chave);
    void imprimir();
}
