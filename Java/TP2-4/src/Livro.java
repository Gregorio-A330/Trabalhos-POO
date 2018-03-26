
public class Livro {

	private Formato formato;
	private int qtEstoque, qtVendido;
	private double preco;
	private static int qtTotalVendas; // TD PRODUTO TERÁ QTVENDIDO DIFERENTE, MAS QTTOTALVENDAS IGUAL, SE CRIAR OUTRAS
										// INSTANCIAS - VAI CHAMAR O MESMO ATRIBUTO

	public Livro(Formato formato, int qtEstoque, int qtVendido, double preco) {
		this.formato = formato;
		this.qtEstoque = Math.max(0, qtEstoque);
		this.qtVendido = 0; // DIDATICO, O JAVA JÁ TE COLOCA ZERO NO QTVENDIDO
		this.preco = Math.max(1, preco);
	}

	public void vender(int quantidade) {
		int qtAuxiliar = Math.max(0, quantidade);
		if (qtAuxiliar <= qtEstoque) {
			qtEstoque -= qtAuxiliar;
			qtVendido += qtAuxiliar;
			qtTotalVendas += qtAuxiliar;
		} else {
			System.out.println("Sem estoque suficiente para a venda!");
			System.out.println("Estoque atual: " + qtdEstoque());
		}
	}

	public double calcFaturamento() {
		return qtVendido * preco;
	}

	/*
	 * public void aumentarPreco(double pct) { preco =
	 * Math.max(preco,(1+pct))*preco; }
	 * 
	 * public void diminuirPreco(double pct) { preco =
	 * Math.min(preco,(1-pct))*preco; }
	 */
	public void comprar(int quantidade) {
		qtEstoque += Math.max(0, quantidade);
	}

	public double qtdVendido() {
		return qtVendido;
	}

	public double qtdEstoque() {
		return qtEstoque;
	}

	public static int getQtTotalVendas() { // static pq não precisa instanciar
		return qtTotalVendas;
	}
}
