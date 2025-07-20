package org.example;

public class Fila<E> {
    private Celula<E> inicio;
    private Celula<E> fim;

    public Fila() {
        Celula sentinela = new Celula();
        this.inicio = sentinela;
        this.fim = sentinela;
    }

    public boolean isEmpty() {
        return inicio == fim;
    }

    public void push(E elem) {
        Celula novoElemento = new Celula(elem);
        fim.proximo = novoElemento;
        fim = novoElemento;
    }

    public void show() {
        Celula c = new Celula();
        for(c = inicio.proximo; c != null; c = c.proximo) {
            System.out.print(c.elemento+" ");
        }
        System.out.println("\n");
    }

    public E pop() throws Exception {
        if(inicio == fim)
            throw new Exception("Erro.");
        inicio = inicio.proximo;

        return inicio.elemento;
    }

    public Fila<E> concatenar(Fila<E> fila) throws Exception {
        while (!fila.isEmpty()) {
            push(fila.pop());
        }

        return this;
    }

    public int obterNumeroItens() {
        int num = 0;
        Celula<E> iterador = inicio;
        while(iterador != fim){
            iterador = iterador.proximo;
            num++;
        }
        return num;
    }

    public boolean verificarExistencia(E item) {
        Celula<E> iterador = inicio.proximo;
        while(iterador != null) {
          if(iterador.elemento.equals(item))
              return true;
          iterador = iterador.proximo;
        }
        return false;
    }

    public int obterNumItensAFrente(E item) {
        Celula<E> iterador = inicio.proximo;
        int i = 0;
        boolean numExiste = false;
        while(iterador != null) {
            if(numExiste){
                i++;
            }
            if(iterador.elemento.equals(item)){
                numExiste = true;
            }
            iterador = iterador.proximo;
        }
        return i;

    }

    public Fila<E> dividir() throws Exception {
        int pos = 1;
        Fila<E> atualImpar = new Fila<>();
        Fila<E> par = new Fila<>();
        Celula<E> iterador = inicio.proximo;
        while(iterador != null) {
            if(pos % 2 == 0) {
                par.push(pop());
            }
            else {
                atualImpar.push(pop());
            }
            iterador = iterador.proximo;
            pos++;
        }

        iterador = atualImpar.inicio.proximo;
        while(iterador != null) {
            push(atualImpar.pop());
            iterador = iterador.proximo;
        }

        return par;
    }

}
