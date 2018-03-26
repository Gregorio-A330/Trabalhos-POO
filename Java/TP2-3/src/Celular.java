
public class Celular {
	private int numero;
	private String usuario;
	private Bateria bateria;
	private boolean estado;

	public Celular(int numero, String usuario, Bateria bateria) {
		this.numero = numero;
		this.usuario = usuario;
		this.bateria = bateria;
		this.estado = false;
	}

	public void ligar() {
		if (this.estado == false) {
			if (bateria.getCarga() > 20) {
				System.out.println("Inicializando Android 7.0 " + this.usuario);
			} else if (this.bateria.getCarga() < 20 && this.bateria.getCarga() > 0) {
				System.out.println("Bateria Fraca");
			}
			this.estado = true;
			bateria.descarregar();
			bateria.descarregar();
		}
	}

	public void desligar() {
		if (this.estado == true) {
			System.out.println("Desligando...");
			bateria.descarregar();
			this.estado = false;
		}
	}

	public void musica() {
		if (this.estado = true && bateria.getCarga() >= 10) {
			System.out.println("Music Audio");
		}
	}

	public void trocarBateria(Bateria bateria) {
		System.out.println("Mudando Bateria");
		desligar();
		this.bateria = bateria;
	}

	public int getNumero() {
		return numero;
	}

	public String getUsuario() {
		return usuario;
	}

	public boolean isEstado() {
		return estado;
	}

	public Bateria getBateria() {
		return bateria;
	}

	public void mostraCarga() {
		this.bateria.mostraCarga();
	}

}
