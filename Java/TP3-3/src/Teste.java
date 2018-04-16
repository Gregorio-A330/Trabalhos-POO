
public class Teste {

	public static void main(String[] args) {
		Constelacao constelacao = new Constelacao("Sargitario");
		Estrela estrela1 = new Estrela("Beta Aquarri", 3000, "Azul");
		Estrela estrela2 = new Estrela("Gamma Aquarri", 2000, "Vermelha");
		Estrela estrela3 = new Estrela("Zeta Aquarri", 4000, "Amarela");

		estrela1.mostrar();
		estrela2.mostrar();
		estrela3.mostrar();

		
		constelacao.adicionar(estrela1);
		System.out.println(constelacao.tempConstelacao());
		constelacao.adicionar(estrela2);
		System.out.println(constelacao.tempConstelacao());
		constelacao.adicionar(estrela3);

		// Cálculo da soma da temperatura de uma constelação
		// é feito pela soma das temperaturas de todas as estrelas
		// desta constelação, que neste caso é 3000 + 2000+ 4000 = 9000 graus.
		System.out.println(constelacao.tempConstelacao());
		System.out.println();
		constelacao.infoEstrelas();

	}

}
