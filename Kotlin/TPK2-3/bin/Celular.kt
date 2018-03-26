import java.util.*

class Celular(numero: Int, usuario: String, bateria: Bateria) {
	private var numero: Int = 0
	private var usuario: String
	private var bateria: Bateria
	private var Estado: Boolean = false

	init {
		this.numero = numero
		this.usuario = usuario
		this.bateria = bateria
		this.Estado = false
	}

	fun ligar() {
		if (this.Estado == false) {
			if (bateria.Carga() > 20) {
				println("Inicializando Android 7.0 " + this.usuario)
			} else if (this.bateria.Carga() < 20 && this.bateria.Carga() > 0) {
				println("Bateria Fraca... favor recarregar")
			}
			this.Estado = true
			bateria.descarregar()
			bateria.descarregar()
		}
	}

	fun desligar() {
		if (this.Estado == true) {
			println("Desligando...")
			bateria.descarregar()
			this.Estado = false
		}
	}

	fun musica() {
		if (this.Estado == true && this.bateria.Carga() > 20) {
			println("Music Audio")
			bateria.descarregar()
		}else
			println("Bateria Fraca...")
	}

	fun trocarBateria(bateria: Bateria) {
		println("Mudando Bateria")
		desligar()
		this.bateria = bateria
	}

	fun mostraCarga() {
		this.bateria.mostraCarga()
	}
}