class Livro(nome: String, autor: String, anoPublicacao: Int) {
	var nome: String
	var autor: String
	var anoPublicacao: Int = 0

	init {
		this.nome = nome
		this.autor = autor
		this.anoPublicacao = anoPublicacao
	}
	fun getNome(): String {
		return nome
	}
	
	fun getAutor(): String {
		return autor
	}
	
	fun getAnoPublicacao(): Int {
		return anoPublicacao
	}

	fun mostrarInfoLivro() {
		println("Livro: " + nome)
		println("Autor: " + autor)
		println("Ano de Publicação: " + anoPublicacao)
	}

	public override fun toString(): String {
		return "\nLivro: " + nome + "\nAutor: " + autor + "\nAno de publicacao: " + anoPublicacao
	}
}