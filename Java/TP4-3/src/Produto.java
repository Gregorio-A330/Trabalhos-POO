
public class Produto {
	
	private String nome;
	private double preco;
	private Imposto imposto;
		
	public Produto(String nome, double preco, Imposto imposto) {
		this.nome = nome;
		this.preco = preco;
		this.imposto = imposto;
	}
			
	public void mostrarNome() {
		System.out.println(this.nome);
	}
	
	public void mostrarPrecoComDesconto() {
		double valorFinal = imposto.calcular(this.preco);
		System.out.println(valorFinal);
	}
		
	public void mostarPrecoSemDesconto() {
		System.out.println(this.preco);
	}
	
}
