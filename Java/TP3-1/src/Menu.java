import java.util.Scanner;

public class Menu {

	Scanner s;
	Scanner entradaString;
	Biblioteca b = new Biblioteca("Mundo dos Livros");
	Estante e;
	String nomeEstante, nomeLivro, autor;
	int anoP;
	Categoria cat;
	Livro l;

	public Menu() {
		s = new Scanner(System.in);
		entradaString = new Scanner(System.in);
	}

	public void mostrarMenu() {
		int opc = 0;

		while (opc != 99) {
			this.exibirOpcoes();
			opc = s.nextInt();

			switch (opc) {
			case 1: // adicionar estante
				System.out.println("Digite o nome da nova Estante: ");
				nomeEstante = entradaString.nextLine();
				System.out.println("Escolha a categoria da nova Estante: ");
				this.opcoesCat();
				e = new Estante(nomeEstante, cat);
				b.inserirEstante(e);
				System.out.println("Estante adicionada!");
				break;
			case 2: // adicionar livro a alguma estante
				System.out.println("Digitar o nome da estante a ser add o livro: ");
				nomeEstante = entradaString.nextLine();
				if (b.pesquisarEstante(nomeEstante)) {
					System.out.println("Nome do Livro: ");
					nomeLivro = entradaString.nextLine();
					System.out.println("Autor: ");
					autor = entradaString.nextLine();
					System.out.println("Ano de Publicação: ");
					anoP = s.nextInt();
					l = new Livro(nomeLivro, autor, anoP);
					e.inserirLivro(l);
				} else
					System.out.println("Não há estante com esse nome...");
				break;
			case 3: // listar estantes
				System.out.println("Estantes na Biblioteca: ");
				b.listarEstante();
				break;
			case 4: // listar todos os livros
				System.out.println("Livros da Biblioteca");
				b.listarTodos();
				break;
			case 5: // listar livro por categoria
				System.out.println("Escolha a categoria: ");
				this.opcoesCat();
				if(cat == Categoria.FILOSOFIA)
					System.out.println(b.listarFilosofia());
				else if (cat == Categoria.CIENCIA)
					System.out.println(b.listarCiencia());
				else if (cat == Categoria.LITERATURA)
					System.out.println(b.listarLiteratura());
				break;
			case 6: // listar autor por categoria
				System.out.println("Escolha a categoria: ");
				this.opcoesCat();
				System.out.println(b.listarAutores(cat));
				break;
			case 7: // quantidade de livro
				System.out.println("Qtde de livro na biblioteca: " + b.qtdeLivros());
				break;
			case 8: // remover estante
				 System.out.println("Digitar o nome da estante a ser removida: ");
	                nomeEstante = entradaString.nextLine();
	                if (b.removerEstante(nomeEstante)) {
	                    System.out.println("Estante " + nomeEstante + " removida.");
	                } else {
	                    System.out.println("Estante inexistente ou com livros.");
	                }
	            break;
			case 9: // remover livro
				System.out.println("Digitar o nome do livro a ser removido: ");
				nomeLivro = entradaString.nextLine();
				if (e.removerLivroNome(nomeLivro)) {
					System.out.println("Livro " + nomeLivro + " removido.");
                } else {
                    System.out.println("Livro inexistente.");
                }
				break;
			case 99:
				this.sair();
				break;

			default:
				this.erro();
			}
		}
	}

	public void exibirOpcoes() {
		System.out.println("--- BIBLIOTECA ---");
		System.out.println("1. Adicionar Estante");
		System.out.println("2. Adicionar Livro");
		System.out.println("3. Listar Estantes");
		System.out.println("4. Listar Livros");
		System.out.println("5. Listar Livro por Categoria");
		System.out.println("6. Listar Autor por Categoria");
		System.out.println("7. Quantidade de Livros");
		System.out.println("8. Remover Estante");
		System.out.println("9. Remover Livro");
		System.out.println("99. Sair");
		System.out.println("Digite a opção: ");
	}

	public void opcoesCat() {
		int opcCat;
		do {
			System.out.println("1 - Ciência");
			System.out.println("2 - Filosofia");
			System.out.println("3 - Literatura");
			opcCat = s.nextInt();
			switch (opcCat) {
			case 1:
				cat = Categoria.CIENCIA;
				break;
			case 2:
				cat = Categoria.FILOSOFIA;
				break;
			case 3:
				cat = Categoria.LITERATURA;
				break;
			default:
				System.out.println("Opção inválida...");
			}
		} while (opcCat != 1 && opcCat != 2 && opcCat != 3);

	}

	public void erro() {
		System.out.println("Erro...");
	}

	public void sair() {
		System.out.println("Fim do programa");
		s.close();
	}
}
