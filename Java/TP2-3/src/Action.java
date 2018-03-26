
public class Action {

	public void Dispositivo() {
		Bateria bat1 = new Bateria();
		Bateria bat2 = new Bateria();

		Celular c1 = new Celular(991674735, "Gregorio", bat1);

		c1.ligar();
		c1.mostraCarga();
		c1.desligar();
		c1.ligar();
		c1.mostraCarga();

		c1.musica();
		bat1.carregar();
		c1.mostraCarga();
		bat1.carregar();
		c1.mostraCarga();
		bat1.carregar();
		c1.mostraCarga();
		bat1.carregar();

		c1.trocarBateria(bat2);
		c1.ligar();
		c1.mostraCarga();
		bat2.carregar();
		c1.mostraCarga();
		c1.desligar();
	}
}
