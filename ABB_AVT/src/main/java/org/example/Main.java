package org.example;

public class Main {
    public static void main(String[] args) {

        Produto p1 = new Produto("Arroz 5kg", 16.0);
        Produto p2 = new Produto("Feijão Preto 1kg", 8.0);
        Produto p3 = new Produto("Macarrão Espaguete 500g", 23.0);
        Produto p4 = new Produto("Óleo de Soja 900ml", 19.0);
        Produto p5 = new Produto("Açúcar Refinado 1kg", 27.0);
        Produto p7 = new Produto("Café Torrado 500g", 4.0);
        Produto p8 = new Produto("Leite Integral 1L", 11.0);
        Produto p9 = new Produto("Biscoito Recheado 140g", 5.0);


        ABB<Produto> arvore = new ABB<>();
        arvore.adicionar(p1);
        arvore.adicionar(p2);
        arvore.adicionar(p3);
        arvore.adicionar(p4);
        arvore.adicionar(p5);
        arvore.adicionar(p7);
        arvore.adicionar(p8);
        arvore.adicionar(p9);

        //arvore.encaminhamentoEmOrdem();
        //arvore.caminhamentoEmPreOrdem();
        //arvore.caminhamentoPosOrdem();

        //System.out.println(arvore.obterMenor());

        ABB<Produto> arvore2 = arvore.clone();

        System.out.println(arvore.ehRaiz(p1));
    }
}