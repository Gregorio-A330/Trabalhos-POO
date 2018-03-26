class Livros(formato: Formato, qtEstoque: Int, qtVendido: Int, preco: Double) {
	//private var formato: Formato
	private var qtEstoque: Int = Math.max(0, qtEstoque)
	private var qtVendido: Int = 0
	private var preco: Double = Math.max(1.0, preco)
	//init{
	//formato = formato
	//qtEstoque = Math.max(0, qtEstoque)
	//qtVendido = 0 
	//preco = Math.max(1.0, preco)
	//}

	fun vender(quantidade: Int) {
		var qtAuxiliar = Math.max(0, quantidade)
		if (qtAuxiliar <= qtEstoque) {
			qtEstoque -= qtAuxiliar
			qtVendido += qtAuxiliar
			qtTotalVendas += qtAuxiliar
		} else {
			println("Sem estoque suficiente para a venda!")
			println("Estoque atual: " + qtdEstoque())
		}
	}

	fun calcFaturamento(): Double {
		return qtVendido * preco
	}

	fun comprar(quantidade: Int) {
		qtEstoque += Math.max(0, quantidade)
	}

	fun qtdVendido(): Double {
		return qtVendido.toDouble()
	}

	fun qtdEstoque(): Double {
		return qtEstoque.toDouble()
	}
	companion object {
	// static pq não precisa instanciar
	var qtTotalVendas:Int = 0 // TD PRODUTO TERÁ QTVENDIDO DIFERENTE, MAS QTTOTALVENDAS IGUAL, SE CRIAR OUTRAS
	}
}