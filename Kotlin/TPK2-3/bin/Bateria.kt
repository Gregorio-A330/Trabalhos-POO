import java.util.*

class Bateria {
	private var carga: Int = 0
	private var cargaMax: Int = 0
	private var cargaMin: Int = 0

	init {
		this.carga = 80
		this.cargaMax = 100
		this.cargaMin = 0
	}

	fun carregar() {
		if (this.carga >= this.cargaMin && this.carga <= this.cargaMax) {
			this.carga = this.carga + 5
		}
	}

	fun descarregar() {
		if (this.carga >= this.cargaMin && this.carga <= this.cargaMax) {
			this.carga = this.carga - 10
		}
		if (this.carga < 0) {
			this.carga = 0
		}
	}

	fun mostraCarga() {
		println("Bateria com " + this.carga + "%")
	}

	fun Carga(): Int {
		return carga
	}
}
