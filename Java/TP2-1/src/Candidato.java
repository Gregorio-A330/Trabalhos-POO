public class Candidato {

	private String nome;
	private Part_Politico part_Politico;

	public Candidato(String nome, Part_Politico part_Politico) {
		this.nome = nome;
		this.part_Politico = part_Politico;
	}

	public void apresentaCandidato() {
		System.out.println(this.nome + "\n" + this.part_Politico.getNome() + "\n" + this.part_Politico.getSigla() + "\n"
				+ this.part_Politico.getIdeologia() + "\n");
	}

	public String getNome() {
		return nome;
	}

	public Part_Politico getPartidoPolitico() {
		return part_Politico;
	}

}