
public class Teste {
	
	public static void main(String[] args) {
		Imposto imposto = new IPI();
		Imposto imposto2 = new ICMS();
		Imposto imposto3 = new ICMS();
		
		Produto produto1 = new Produto("IPHONE 8plus",3600.00,imposto);
		Produto produto2 = new Produto("Cappucino",8.00,imposto2);
		Produto produto3 = new Produto("Honda CIVIC",95000.00,imposto3);
		
		System.out.print("Nome do produto: ");
		produto1.mostrarNome();
		System.out.print("Preco do produto com o desconto de 5% de IPI: ");
		produto1.mostrarPrecoComDesconto();
		System.out.print("Preco do produto sem o desconto da aliquota do IPI: ");
		produto1.mostarPrecoSemDesconto();
		
		System.out.println();
		
		produto2.mostrarNome();
		produto2.mostrarPrecoComDesconto();
		produto2.mostarPrecoSemDesconto();
		
		System.out.println();
		
		System.out.print("Nome do produto: ");
		produto3.mostrarNome();
		System.out.print("Preco do produto com o desconto de 10% de ICMS: ");
		produto3.mostrarPrecoComDesconto();
		System.out.print("Preco do produto sem o desconto da aliquota do ICMS: ");
		produto3.mostarPrecoSemDesconto();
		
	}
}
