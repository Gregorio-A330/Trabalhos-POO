
public class Bateria {
	private int carga;
	private int cargaMax;
	private int cargaMin;

	public Bateria() {
		this.carga = 80;
		this.cargaMax = 100;
		this.cargaMin = 0;
	}

	public int getCarga() {
		return carga;
	}

	public int getCargaMax() {
		return cargaMax;
	}

	public int getCargaMin() {
		return cargaMin;
	}

	public void carregar() {
		if (this.carga >= this.cargaMin && this.carga <= this.cargaMax) {
			this.carga = this.carga + 5;
		}
	}

	public void descarregar() {
		if (this.carga >= this.cargaMin && this.carga <= this.cargaMax) {
			this.carga = this.carga - 10;
		}
		if (this.carga < 0) {
			this.carga = 0;
		}
	}

	public void mostraCarga() {
		System.out.println("Bateria com " + this.getCarga() + "%"); 
	}
}
