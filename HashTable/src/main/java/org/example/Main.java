package org.example;

public class Main {
    public static void main(String[] args) {
        Aluno al1 = new Aluno("Gabriel", 1);
        //Entrada<Integer, String> entrada = new Entrada<>(al1.getNumMatricula(), al1.getNome());
        HashSeparado<Integer, String> tabela = new HashSeparado<>(10);

        Aluno al2 = new Aluno("JJ", 6);
        tabela.inserir(al1.getNumMatricula(), al1.getNome());
        tabela.inserir(al2.getNumMatricula(), al2.getNome());

        tabela.imprimir();
        tabela.obterTodasChaves().imprimir();
    }
}