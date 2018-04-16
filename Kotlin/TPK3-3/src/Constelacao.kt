import java.util.ArrayList

class Constelacao(nome: String) {
	var nome: String
	private var estrelas: ArrayList<Estrela>

	init {
		this.nome = nome
		this.estrelas = ArrayList<Estrela>()
	}

	fun adicionar(e: Estrela) {
		this.estrelas.add(e)
	}

	fun infoEstrelas() {
		for (e in estrelas) {
			e.mostrar()
			println("----------")
		}
	}

	fun tempConstelacao(): Double {
		var temperaturaTotal = 0.0
		for (e in estrelas) {
			temperaturaTotal += e.getTemperatura()
		}
		return temperaturaTotal
	}
}