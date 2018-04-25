import java.util.Scanner

class Menu {
	internal var s: Scanner
	internal var entradaString: Scanner
	internal var b = Biblioteca("Mundo dos Livros")
	internal var e: Estante
	internal var nomeEstante: String
	internal var nomeLivro: String
	internal var autor: String
	internal var anoP: Int = 0
	internal var cat: Categoria
	internal var l: Livro

	init {
		s = Scanner(System.`in`)
		entradaString = Scanner(System.`in`)
	}

	fun mostrarMenu() {
		var opc = 0
		while (opc != 99) {
			this.exibirOpcoes()
			opc = s.nextInt()
			when (opc) {
				1 // adicionar estante
				-> {
					println("Digite o nome da nova Estante: ")
					nomeEstante = entradaString.nextLine()
					println("Escolha a categoria da nova Estante: ")
					this.opcoesCat()
					e = Estante(nomeEstante, cat)
					b.inserirEstante(e)
					println("Estante adicionada!")
				}
				2 // adicionar livro a alguma estante
				-> {
					println("Digitar o nome da estante a ser add o livro: ")
					nomeEstante = entradaString.nextLine()
					if (b.pesquisarEstante(nomeEstante)) {
						println("Nome do Livro: ")
						nomeLivro = entradaString.nextLine()
						println("Autor: ")
						autor = entradaString.nextLine()
						println("Ano de Publicação: ")
						anoP = s.nextInt()
						l = Livro(nomeLivro, autor, anoP)
						e.inserirLivro(l)
					} else
						println("Não há estante com esse nome...")
				}
				3 // listar estantes
				-> {
					println("Estantes na Biblioteca: ")
					b.listarEstante()
				}
				4 // listar todos os livros
				-> {
					println("Livros da Biblioteca")
					b.listarTodos()
				}
				5 // listar livro por categoria
				-> {
					println("Escolha a categoria: ")
					this.opcoesCat()
					if (cat === Categoria.FILOSOFIA)
						System.out.println(b.listarFilosofia())
					else if (cat === Categoria.CIENCIA)
						System.out.println(b.listarCiencia())
					else if (cat === Categoria.LITERATURA)
						System.out.println(b.listarLiteratura())
				}
				6 // listar autor por categoria
				-> {
					println("Escolha a categoria: ")
					this.opcoesCat()
					System.out.println(b.listarAutores(cat))
				}
				7 // quantidade de livro
				-> System.out.println("Qtde de livro na biblioteca: " + b.qtdeLivros())
				8 // remover estante
				-> {
					println("Digitar o nome da estante a ser removida: ")
					nomeEstante = entradaString.nextLine()
					if (b.removerEstante(nomeEstante)) {
						println("Estante " + nomeEstante + " removida.")
					} else {
						println("Estante inexistente ou com livros.")
					}
				}
				9 // remover livro
				-> {
					println("Digitar o nome do livro a ser removido: ")
					nomeLivro = entradaString.nextLine()
					if (e.removerLivroNome(nomeLivro)) {
						println("Livro " + nomeLivro + " removido.")
					} else {
						println("Livro inexistente.")
					}
				}
				99 -> this.sair()
				else -> this.erro()
			}
		}
	}

	fun exibirOpcoes() {
		println("--- BIBLIOTECA ---")
		println("1. Adicionar Estante")
		println("2. Adicionar Livro")
		println("3. Listar Estantes")
		println("4. Listar Livros")
		println("5. Listar Livro por Categoria")
		println("6. Listar Autor por Categoria")
		println("7. Quantidade de Livros")
		println("8. Remover Estante")
		println("9. Remover Livro")
		println("99. Sair")
		println("Digite a opção: ")
	}

	fun opcoesCat() {
		var opcCat: Int
		do {
			println("1 - Ciência")
			println("2 - Filosofia")
			println("3 - Literatura")
			opcCat = s.nextInt()
			when (opcCat) {
				1 -> cat = Categoria.CIENCIA
				2 -> cat = Categoria.FILOSOFIA
				3 -> cat = Categoria.LITERATURA
				else -> println("Opção inválida...")
			}
		} while (opcCat != 1 && opcCat != 2 && opcCat != 3)
	}

	fun erro() {
		println("Erro...")
	}

	fun sair() {
		println("Fim do programa")
		s.close()
	}
}