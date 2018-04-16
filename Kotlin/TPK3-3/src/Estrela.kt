class Estrela(nome: String, temperatura: Double, cor: String) {
	private val nome: String
	var temperatura: Double = 0.toDouble()
	private var cor: String

	init {
		this.nome = nome
		this.temperatura = temperatura
		this.cor = cor
	}

	fun mostrar() {
		println(("Nome: " + nome
				+ ", Temperatura: " + temperatura
				+ ", Cor: " + cor))
	}
	fun getTemperatura():Double {
		return temperatura;
	}
}