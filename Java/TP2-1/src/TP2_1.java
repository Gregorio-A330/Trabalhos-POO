
public class TP2_1 {
	public static void main(String[] args) {
		Part_Politico PV = new Part_Politico("Partido Verde", "Ambientalista", "PV", 43);
		Part_Politico PMDB = new Part_Politico("Partido do Movimento Democratico Brasileiro", "VICE-SEMPRE", "PMDB",
				15);

		Candidato c1 = new Candidato("Eduardo Jorge", PV);
		Candidato c2 = new Candidato("Temer", PMDB);

		c1.apresentaCandidato();
		c2.apresentaCandidato();

	}

}
