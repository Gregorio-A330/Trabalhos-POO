import java.util.Scanner

class MenuVenda {
	internal var s: Scanner
	// internal var formato:Formato
	internal var EPUB = Livros(Formato.EPUB, 10, 0, 20.00)
	internal var PDF = Livros(Formato.PDF, 10, 0, 40.00)
	internal var FISICO = Livros(Formato.FISICO, 10, 0, 80.00)

	init {
		s = Scanner(System.`in`)
		this.EPUB = EPUB
		this.PDF = PDF
		this.FISICO = FISICO
	}

	fun menu() {
		var opt = 0
		while (opt != 4) {
			println("--- LIVRARIA ---")
			println("1. Vender")
			println("2. Comprar")
			println("3. Exibir condição de venda-estoque")
			println("4. Sair")
			println("Digite a opção: ")
			opt = s.nextInt()
			when (opt) {
				1 -> this.vender()
				2 -> this.comprar()
				3 -> this.exibir()
				4 -> this.sair()
				else -> this.erro()
			}
		}
	}

	fun erro() {
		println("Erro...")
	}

	fun vender() {
		// Scanner s = new Scanner(System.in); //VC PODE COLOCAR O SCANNER EM UM
		// CONSTRUTOR - EM UMA CLASSE
		println("Digite o formato de livro: ")
		var formato = Formato.valueOf(s.next())
		if (formato === Formato.EPUB) {
			println("Digite a quantidade: ")
			var qtdVenda = s.nextInt()
			EPUB.vender(qtdVenda)
		} else {
			if (formato === Formato.PDF) {
				println("Digite a quantidade: ")
				var qtdVenda = s.nextInt()
				PDF.vender(qtdVenda)
			} else {
				if (formato === Formato.FISICO) {
					println("Digite a quantidade: ")
					var qtdVenda = s.nextInt()
					FISICO.vender(qtdVenda)
				}
			}
		}
	}

	fun comprar() {
		// Scanner s = new Scanner(System.in); //VC PODE COLOCAR O SCANNER EM UM
		// CONSTRUTOR - EM UMA CLASSE
		println("Digite o formato de livro: ")
		val formato = Formato.valueOf(s.next())
		if (formato === Formato.EPUB) {
			println("Digite a quantidade comprada: ")
			var qtdCompra = s.nextInt()
			EPUB.comprar(qtdCompra)
		} else {
			if (formato === Formato.PDF) {
				println("Digite a quantidade comprada: ")
				val qtdCompra = s.nextInt()
				PDF.comprar(qtdCompra)
			} else {
				if (formato === Formato.FISICO) {
					println("Digite a quantidade comprada: ")
					val qtdCompra = s.nextInt()
					FISICO.comprar(qtdCompra)
				}
			}
		}
	}

	fun exibir() {
		// Scanner s = new Scanner(System.in); //VC PODE COLOCAR O SCANNER EM UM
		// CONSTRUTOR - EM UMA CLASSE
		println("Digite o formato de livro: ")
		val formato = Formato.valueOf(s.next())
		if (formato === Formato.EPUB) {
			System.out.println("Faturamento de Livros EPUB: " + EPUB.calcFaturamento())
			System.out.println("Estoque: " + EPUB.qtdEstoque())
			System.out.println("Vendido: " + EPUB.qtdVendido())
			//System.out.println("Total de Vendas: " + EPUB.getQtTotalVendas())
		} else {
			if (formato === Formato.PDF) {
				System.out.println("Faturamento de Livros EPUB: " + PDF.calcFaturamento())
				System.out.println("Estoque: " + PDF.qtdEstoque())
				System.out.println("Vendido: " + PDF.qtdVendido())
				//System.out.println("Total de Vendas: " + PDF.getQtTotalVendas())
			} else {
				if (formato === Formato.FISICO) {
					System.out.println("Faturamento de Livros EPUB: " + FISICO.calcFaturamento())
					System.out.println("Estoque: " + FISICO.qtdEstoque())
					System.out.println("Vendido: " + FISICO.qtdVendido())
					//System.out.println("Total de Vendas: " + FISICO.getQtTotalVendas())
				}
			}
		}
	}

	fun sair() {
		println("Fim do programa")
		s.close()
	}
}