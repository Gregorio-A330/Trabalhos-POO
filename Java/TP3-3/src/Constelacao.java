import java.util.ArrayList;

public class Constelacao {
	private String nome;
	private ArrayList<Estrela> estrelas;

	public Constelacao(String nome) {
		this.nome = nome;
		this.estrelas = new ArrayList<>();
	}

	public void adicionar(Estrela e) {
		this.estrelas.add(e);
	}

	public void infoEstrelas() {
		for (Estrela e : estrelas) {
			e.mostrar();
			System.out.println("----------");
		}
	}

	public double tempConstelacao() {
		double temperaturaTotal = 0;
		for (Estrela e : estrelas) {
			temperaturaTotal += e.getTemperatura();
		}
		return temperaturaTotal;
	}

	public String getNome() {
		return nome;
	}
}
