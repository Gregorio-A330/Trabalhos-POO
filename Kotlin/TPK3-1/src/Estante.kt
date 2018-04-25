import java.util.ArrayList

class Estante(nome: String, categoria: Categoria) {
	private var nome: String
	private var categoria: Categoria
	private var livros: ArrayList<Livro>
	var qtde: Int = 0

	fun getLivros(): ArrayList<String> {
		return livros.size()
	}

	fun getNome(): String {
		return nome
	}

	fun getCategoria(): Categoria {
		return categoria
	}

	var isVazia: Boolean = false
	
	fun getLivro(): ArrayList<String> {
		return livros.size()
	}

	init {
		this.nome = nome
		this.categoria = categoria
		this.livros = ArrayList<Livro>()
		this.qtde = qtde
	}

	fun inserirLivro(l: Livro) {
		livros.add(l)
	}

	fun removerLivro(l: Livro) {
		livros.remove(l)
	}

	fun removerLivroNome(nomeLivro: String): Boolean {
		for (l in livros) {
			if (l.getNome().equalsIgnoreCase(nomeLivro)) {
				livros.remove(l)
				return true
			}
		}
		return false
	}

	fun mostrarEstante() {
		println("Estante: " + nome)
		println("Categoria: " + categoria)
	}

	fun listarLivros() {
		for (l in livros) {
			l.mostrarInfoLivro()
		}
	}

	fun listarAutores() {
		for (l in livros)
			l.getAutor()
	}

	fun pesquisarLivro(nomeLivro: String): Boolean {
		for (l in livros) {
			if (l.getNome().equalsIgnoreCase(nomeLivro)) {
				return true
			}
		}
		return false
	}
}