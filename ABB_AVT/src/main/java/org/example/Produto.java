package org.example;

public class Produto implements Comparable<Produto>{
    private String descricao;
    private Double preco;

    public Produto() {
    }

    public Produto(String descricao, Double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }


    @Override
    public int compareTo(Produto p1) {
        return this.preco.compareTo(p1.getPreco());
    }

    @Override
    public boolean equals(Object p1) {
        if (this == p1)
            return true;
        if (p1 == null || getClass() != p1.getClass())
            return false;
        Produto p = (Produto) p1;
        return this.preco.equals(p.preco);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
