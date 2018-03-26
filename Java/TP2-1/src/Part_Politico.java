
public class Part_Politico {

	private String nome;
	private String ideologia;
	private String sigla;
	private int num;

	public Part_Politico(String nome, String ideologia, String sigla, int num) {
		this.nome = nome;
		this.ideologia = ideologia;
		this.sigla = sigla;
		this.num = num;
	}

	public String getNome() {
		return nome;
	}

	public String getIdeologia() {
		return ideologia;
	}

	public String getSigla() {
		return sigla;
	}

	public int getNumero() {
		return num;
	}

}
