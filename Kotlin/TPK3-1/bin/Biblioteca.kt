import java.util.ArrayList

class Biblioteca(nome: String) {
	var nome: String
	var estante: ArrayList<Estante>
	var qtde: Int = 0
	
	fun getEstante(): ArrayList<String> {
		return estante.size()
	}
	
	fun getQtde(): Int {
		return qtde
	}

	init {
		this.nome = nome
		this.estante = ArrayList<Estante>()
		this.qtde = qtde
	}

	fun inserirEstante(e: Estante) {
		estante.add(e)
	}

	fun listarFilosofia(): ArrayList<Livro> {
		var livroFilo = ArrayList<Estante>()
		for (e in estante) {
			if (e.getCategoria() === Categoria.FILOSOFIA) {
				for (i in estante.indices) {
					if (estante.get(i).getLivros() != null)
						livroFilo.addAll(estante.get(i).getLivros())
				}
			} else
				println("Categoria vazia...")
		}
		return livroFilo
	}

	fun listarCiencia(): ArrayList<Livro> {
		var livroCiencia = ArrayList<Estante>()
		for (e in estante) {
			if (e.getCategoria() === Categoria.CIENCIA) {
				for (i in estante.indices) {
					if (estante.get(i).getLivros() != null)
						livroCiencia.addAll(estante.get(i).getLivros())
				}
			} else
				println("Categoria vazia...")
		}
		return livroCiencia
	}

	fun listarLiteratura(): ArrayList<Livro> {
		var livroLiteratura = ArrayList<Estante>()
		for (e in estante) {
			if (e.getCategoria() === Categoria.LITERATURA) {
				for (i in estante.indices) {
					if (estante.get(i).getLivros() != null) {
						livroLiteratura.addAll(estante.get(i).getLivros())
					}
				}
			} else
				println("Categoria vazia...")
		}
		return livroLiteratura
	}

	fun listarAutores(cat: Categoria): ArrayList<String> {
		var autores = ArrayList<String>()
		var livroAux = ArrayList<Estante>()
		for (e in estante) {
			for (i in estante.indices) {
				autores.add(livroAux.get(i).getAutor())
			}
		}
		return autores
	}

	fun qtdeLivros(): Int {
		var qtdLivros = 0
		for (e in estante) {
			for (i in estante.indices)
				qtdLivros++
		}
		return qtdLivros
	}

	fun listarEstante() {
		for (e in estante) {
			e.mostrarEstante()
		}
	}

	fun pesquisarEstante(nomeEstante: String): Boolean {
		for (e in estante) {
			if (e.getNome().equalsIgnoreCase(nomeEstante)) {
				return true
			}
		}
		return false
	}

	fun listarTodos() {
		for (e in estante) {
			e.listarLivros()
		}
	}

	fun removerEstante(nomeEstante: String): Boolean {
		for (e in estante) {
			if (e.getNome().equalsIgnoreCase(nomeEstante) && e.isVazia()) {
				estante.remove(e)
				return true
			}
		}
		return false
	}

	fun pesquisarEstanteIndice(nomeEstante: String): ArrayList<Estante> {
		for (i in 0..estante.size()) {
			if (estante.get(i).getNome() === nomeEstante)
				return estante
		}
		return null
	}

	fun removeEstante(e: Estante) {
		for (i in 0..estante.size()) {
			if (estante.get(i) === e) {
				estante.removeAt(i)
				println("Estante removida...")
			} else
				println("Estante não encontrada...")
		}
	}
}