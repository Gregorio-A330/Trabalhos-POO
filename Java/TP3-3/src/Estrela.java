
public class Estrela {

	private String nome;
	private double temperatura;
	private String cor;

	public Estrela(String nome, double temperatura, String cor) {
		this.nome = nome;
		this.temperatura = temperatura;
		this.cor = cor;
	}

	public void mostrar() {
		System.out.println("Nome: " + nome + ", Temperatura: " + temperatura + ", Cor: " + cor);
	}

	public double getTemperatura() {
		return temperatura;
	}
}
