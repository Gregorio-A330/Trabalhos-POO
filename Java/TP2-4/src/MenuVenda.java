import java.util.Scanner;

public class MenuVenda {
	Scanner s;
	Formato formato;
	Livro EPUB = new Livro(Formato.EPUB, 10, 0, 20.00);
	Livro PDF = new Livro(Formato.PDF, 10, 0, 40.00);
	Livro FISICO = new Livro(Formato.FISICO, 10, 0, 80.00);

	public MenuVenda() { // CONSTRUTOR
		s = new Scanner(System.in);
		this.EPUB = EPUB;
		this.PDF = PDF;
		this.FISICO = FISICO;
	}

	public void menu() {
		int opt = 0;
		while (opt != 4) {
			System.out.println("--- LIVRARIA ---");
			System.out.println("1. Vender");
			System.out.println("2. Comprar");
			System.out.println("3. Exibir condição de venda-estoque");
			System.out.println("4. Sair");
			System.out.println("Digite a opção: ");
			opt = s.nextInt();
			switch (opt) {
			case 1:
				this.vender();
				break;
			case 2:
				this.comprar();
				break;
			case 3:
				this.exibir();
				break;
			case 4:
				this.sair();
				break;
			default:
				this.erro();
			}
		}
	}

	public void erro() {
		System.out.println("Erro...");
	}

	public void vender() {
		// Scanner s = new Scanner(System.in); //VC PODE COLOCAR O SCANNER EM UM
		// CONSTRUTOR - EM UMA CLASSE
		System.out.println("Digite o formato de livro: ");
		Formato formato = Formato.valueOf(s.next());
		if (formato == formato.EPUB) {
			System.out.println("Digite a quantidade: ");
			int qtdVenda = s.nextInt();
			EPUB.vender(qtdVenda);
		} else {
			if (formato == formato.PDF) {
				System.out.println("Digite a quantidade: ");
				int qtdVenda = s.nextInt();
				PDF.vender(qtdVenda);
			} else {
				if (formato == formato.FISICO) {
					System.out.println("Digite a quantidade: ");
					int qtdVenda = s.nextInt();
					FISICO.vender(qtdVenda);
				}
			}
		}
	}

	public void comprar() {
		// Scanner s = new Scanner(System.in); //VC PODE COLOCAR O SCANNER EM UM
		// CONSTRUTOR - EM UMA CLASSE
		System.out.println("Digite o formato de livro: ");
		Formato formato = Formato.valueOf(s.next());
		if (formato == formato.EPUB) {
			System.out.println("Digite a quantidade comprada: ");
			int qtdCompra = s.nextInt();
			EPUB.comprar(qtdCompra);
		} else {
			if (formato == formato.PDF) {
				System.out.println("Digite a quantidade comprada: ");
				int qtdCompra = s.nextInt();
				PDF.comprar(qtdCompra);
			} else {
				if (formato == formato.FISICO) {
					System.out.println("Digite a quantidade comprada: ");
					int qtdCompra = s.nextInt();
					FISICO.comprar(qtdCompra);
					;
				}
			}
		}
	}

	public void exibir() {
		// Scanner s = new Scanner(System.in); //VC PODE COLOCAR O SCANNER EM UM
		// CONSTRUTOR - EM UMA CLASSE
		System.out.println("Digite o formato de livro: ");
		Formato formato = Formato.valueOf(s.next());
		if (formato == formato.EPUB) {
			System.out.println("Faturamento de Livros EPUB: " + EPUB.calcFaturamento());
			System.out.println("Estoque: " + EPUB.qtdEstoque());
			System.out.println("Vendido: " + EPUB.qtdVendido());
			System.out.println("Total de Vendas: " + EPUB.getQtTotalVendas());
		} else {
			if (formato == formato.PDF) {
				System.out.println("Faturamento de Livros EPUB: " + PDF.calcFaturamento());
				System.out.println("Estoque: " + PDF.qtdEstoque());
				System.out.println("Vendido: " + PDF.qtdVendido());
				System.out.println("Total de Vendas: " + PDF.getQtTotalVendas());
			} else {
				if (formato == formato.FISICO) {
					System.out.println("Faturamento de Livros EPUB: " + FISICO.calcFaturamento());
					System.out.println("Estoque: " + FISICO.qtdEstoque());
					System.out.println("Vendido: " + FISICO.qtdVendido());
					System.out.println("Total de Vendas: " + FISICO.getQtTotalVendas());
				}
			}
		}
	}

	public void sair() {
		System.out.println("Fim do programa");
		s.close();
	}

}
