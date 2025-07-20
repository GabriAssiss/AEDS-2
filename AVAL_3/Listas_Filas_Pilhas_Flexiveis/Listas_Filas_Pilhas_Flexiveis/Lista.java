import java.util.function.Function;
import java.util.function.Predicate;

public class Lista<E> {

	private Celula<E> primeiro;
	private Celula<E> ultimo;
	private int tamanho;
	
	public Lista() {
		
		Celula<E> sentinela = new Celula<>();
		
		this.primeiro = this.ultimo = sentinela;
		this.tamanho = 0;
	}
	
	public boolean vazia() {
		
		return (this.primeiro == this.ultimo);
	}
	
	public void inserir(E novo, int posicao) {
		
		Celula<E> anterior, novaCelula, proximaCelula;
		
		if ((posicao < 0) || (posicao > this.tamanho))
			throw new IndexOutOfBoundsException("Não foi possível inserir o item na lista: "
					+ "a posição informada é inválida!");
		
		anterior = this.primeiro;
		for (int i = 0; i < posicao; i++)
			anterior = anterior.getProximo();
				
		novaCelula = new Celula<>(novo);
			
		proximaCelula = anterior.getProximo();
			
		anterior.setProximo(novaCelula);
		novaCelula.setProximo(proximaCelula);
			
		if (posicao == this.tamanho)  // a inserção ocorreu na última posição da lista
			this.ultimo = novaCelula;
			
		this.tamanho++;		
	}
	
	public E remover(int posicao) {
		
		Celula<E> anterior, celulaRemovida, proximaCelula;
		
		if (vazia())
			throw new IllegalStateException("Não foi possível remover o item da lista: "
					+ "a lista está vazia!");
		
		if ((posicao < 0) || (posicao >= this.tamanho ))
			throw new IndexOutOfBoundsException("Não foi possível remover o item da lista: "
					+ "a posição informada é inválida!");
			
		anterior = this.primeiro;
		for (int i = 0; i < posicao; i++)
			anterior = anterior.getProximo();
				
		celulaRemovida = anterior.getProximo();
				
		proximaCelula = celulaRemovida.getProximo();
				
		anterior.setProximo(proximaCelula);
		celulaRemovida.setProximo(null);
				
		if (celulaRemovida == this.ultimo)
			this.ultimo = anterior;
				
		this.tamanho--;
				
		return (celulaRemovida.getItem());	
	}

	public double calcularValorMedio(Function<E, Double> extrator, int quantidade)  {
		double valor = 0.0;
		double soma = 0.0;
		int i = 0;

		if(quantidade > tamanho || quantidade <= 0)
			return 0.0;

		for(Celula<E> celula = primeiro.getProximo(); celula != null && i < quantidade; celula = celula.getProximo()) {
			valor = extrator.apply(celula.getItem());
			soma = soma + valor;
			i++;
		}

		return soma/quantidade;
    }

	public Lista<E> filtrar(Predicate<E> conditional, int quantidade) {

		Lista<E> subLista = new Lista<>();

		int i = 0;

		for(Celula<E> celula = primeiro.getProximo(); celula != null && i < quantidade; celula = celula.getProximo(), i++) {
			if(conditional.test(celula.getItem()))
				subLista.inserir(celula.getItem(), subLista.getTamanho());
		}

		return subLista;
	}

	public void mostrar() {
		if(!vazia()) {
			Celula<E> celula = primeiro.getProximo();
			while(celula != null) {
				System.out.println(celula.getItem().toString() + "\n");
				celula = celula.getProximo();
			}
		}
	}

	public Celula<E> getUltimo() {
		return ultimo;
	}

	public int getTamanho() {
		return tamanho;
	}

	public static void main(String[] args) {
		Lista<Integer> l = new Lista<>();
	}
}
