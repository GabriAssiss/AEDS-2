import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	public void mostrar() {
		if(!vazia()) {
			for(Celula<E> celula = topo; celula != fundo ; celula = celula.getProximo()) {
				System.out.println(celula.getItem() + "\n");
			}
		}
		else{
			System.out.println("Pilha vazia.");
		}
	}
	
	public Pilha<E> subPilha(int numItens) {
		Pilha<E> subPilha = new Pilha<>();
		Celula<E>[] temp = new Celula[numItens];
		if(numItens <= 0)
			return subPilha;
		int i = 0;

        for(Celula<E> celula = topo; celula != fundo && i < numItens; celula = celula.getProximo(), i++) {
			temp[i] = celula;
		}

		for( i = numItens - 1; i >= 0; i--) {
			subPilha.empilhar(temp[i].getItem());
		}
		return subPilha;
	}
}