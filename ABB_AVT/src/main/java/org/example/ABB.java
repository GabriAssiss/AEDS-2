package org.example;

import java.util.NoSuchElementException;

public class ABB<E extends Comparable<E>> {
    private No<E> raiz;

    public ABB() {
        this.raiz = null;
    }

    public ABB(No<E> raiz) {
        this.raiz = raiz;
    }

    public No<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(No<E> raiz) {
        this.raiz = raiz;
    }

    public void adicionar(E item) {
        this.raiz = adicionar(item, this.raiz);
    }

    private No<E> adicionar(E item, No<E> raiz) {
        if(raiz == null) {
            raiz = new No<>(item);
        }
        else {
            int comparacao = item.compareTo(raiz.getItem());

            if (comparacao > 0)
                raiz.setDireita(adicionar(item, raiz.getDireita()));
            else if (comparacao < 0)
                raiz.setEsquerda(adicionar(item, raiz.getEsquerda()));
            else
                throw new RuntimeException("Erro: valor já inserido na árvore.");
        }
        return raiz;
    }

    public E pesquisar(E item) {
        return pesquisar(raiz, item);
    }

    private E pesquisar(No<E> raiz, E item) {
        if(raiz == null)
            throw new RuntimeException("Erro: árvore vazia.");
        int comparacao = raiz.getItem().compareTo(item);
        if(comparacao == 0)
            return raiz.getItem();
        else if(comparacao > 0)
            return pesquisar(raiz.getEsquerda(), item);
        else
            return pesquisar(raiz.getDireita(), item);
    }

    public void encaminhamentoEmOrdem() {
        encaminhamentoEmOrdem(this.raiz);
    }

    public void encaminhamentoEmOrdem(No<E> raiz) {
        if(raiz == null)
            throw new RuntimeException("Árvore vazia!");
        if(raiz.getEsquerda() != null)
            encaminhamentoEmOrdem(raiz.getEsquerda());
        System.out.println(raiz.getItem().toString());
        if(raiz.getDireita() != null)
            encaminhamentoEmOrdem(raiz.getDireita());
    }

    public void caminhamentoEmPreOrdem() {
        caminhamentoEmPreOrdem(raiz);
    }

    public void caminhamentoEmPreOrdem(No<E> raiz) {
        if(raiz == null)
            throw new NoSuchElementException("Árvore vazia");
        System.out.println(raiz.getItem().toString());
        if(raiz.getEsquerda() != null)
            caminhamentoEmPreOrdem(raiz.getEsquerda());
        if(raiz.getDireita() != null)
            caminhamentoEmPreOrdem(raiz.getDireita());
    }

    public void caminhamentoPosOrdem() {
        caminhamentoPosOrdem(raiz);
    }

    public void caminhamentoPosOrdem(No<E> raiz) {
        if(raiz == null)
            throw new NoSuchElementException("Árvore vazia.");
        if(raiz.getEsquerda() != null)
            caminhamentoPosOrdem(raiz.getEsquerda());
        if(raiz.getDireita() != null)
            caminhamentoPosOrdem(raiz.getDireita());
        System.out.println(raiz.getItem().toString());
    }

    public E obterMenor() {
        return obterMenor(raiz);
    }

    public E obterMenor(No<E> raiz) {
        if(raiz == null)
            throw new NoSuchElementException("Árvore vazia.");
        if(raiz.getEsquerda() == null)
            return raiz.getItem();
        return obterMenor(raiz.getEsquerda());
    }

    public ABB<E> clone() {
        ABB<E> arvoreClone = new ABB<>();
        No<E> noClone = raiz.clone();
        arvoreClone.setRaiz(noClone);
        return clone(raiz, arvoreClone);
    }

    public ABB<E> clone(No<E> raiz, ABB<E> arvoreClone) {
        if(raiz == null)
            throw new NoSuchElementException("àrvore vazia.");
        if(raiz.getEsquerda() != null) {
            No<E> copiaNoEsquerdo = new No<>();
            copiaNoEsquerdo = raiz.getEsquerda().clone();
            arvoreClone.adicionar(copiaNoEsquerdo.getItem());
            clone(raiz.getEsquerda(), arvoreClone);
        }
        if(raiz.getDireita() != null) {
            No<E> copiaNoDireito = new No<>();
            copiaNoDireito = raiz.getDireita().clone();
            arvoreClone.adicionar(copiaNoDireito.getItem());
            clone(raiz.getDireita(), arvoreClone);
        }

        return arvoreClone;

    }

    public boolean ehRaiz(E item) {
        return raiz.getItem().compareTo(item) == 0;
    }

}
