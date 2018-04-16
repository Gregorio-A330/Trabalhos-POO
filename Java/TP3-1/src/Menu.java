import java.util.Scanner;

public class Menu {

	Scanner s;
	Categoria categoria;
	Biblioteca b = new Biblioteca("Mundo dos Livros");
	Estante e;
	Livro l;
	
	public Menu() {
		s = new Scanner (System.in);
	}
	
	public void mostrarMenu() {
		int opc = 0;
		
		while(opc != 99) {
			System.out.println("--- BIBLIOTECA ---");
			System.out.println("1. Adicionar Estante");
			System.out.println("2. Adicionar Livro");
			System.out.println("3. Listar Estantes");
			System.out.println("4. Listar Livros");
			System.out.println("5. Remover Estante");
			System.out.println("6. Remover Livro");
			System.out.println("99. Sair");
			System.out.println("Digite a opção: ");
			opc = s.nextInt();
			
			switch(opc) {
			case 1: 
				b.addEstante(e);
				break;
			case 2: 
				e.addLivro(l);
				break;		
			case 3: 
				b.listarTodasEstantes();;
				break;		
			case 4: 
				e.listarTodosLivros();
				break;		
			case 5: 
				b.removerEstante(e);
				break;		
			case 6: 
				e.removerLivro(l);
				break;		
					
			case 99: this.sair();
					break;
			default: this.erro();
			}
		
		}	
				
	}
	
	public void erro() {
		System.out.println("Erro...");
	}
	
	public void sair() {
		System.out.println("Fim do programa");
		s.close();
	}
	
	
	
	
}
