class Action {

	fun Dispositivo() {
		var bat1 = Bateria()
		var bat2 = Bateria()
		var c1 = Celular(991674735, "Gregorio", bat1)

		c1.ligar()
		c1.mostraCarga()
		c1.desligar()
		c1.ligar()
		c1.mostraCarga()
		c1.musica()
		c1.mostraCarga()
		c1.musica()
		c1.mostraCarga()

		bat1.carregar()
		c1.mostraCarga()
		bat1.carregar()
		c1.mostraCarga()
		bat1.carregar()
		c1.mostraCarga()
		bat1.carregar()

		c1.trocarBateria(bat2)
		c1.ligar()
		c1.mostraCarga()

		bat2.carregar()
		c1.mostraCarga()
		c1.desligar()
	}
}
