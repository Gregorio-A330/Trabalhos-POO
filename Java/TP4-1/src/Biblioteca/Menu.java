package Biblioteca;
import java.util.Scanner;

public class Menu {
        
        Biblioteca biblioteca = new Biblioteca("Fatec");
        Scanner s = new Scanner(System.in);
        Scanner entradaString = new Scanner(System.in);
        int opc = 0, anoP, opcCat;
        Categoria cat;
        String nomeEstante, nomeLivro, autor;
        Estante estante;
        Livro livro;
        
    public void mostrarMenuConvidado(){
        while(opc != 99){
            System.out.println("==== TELA DE LOGIN - CONVIDADO ====");
            System.out.println("3 - Listar Estantes");
            System.out.println("4 - Listar Livros");
            System.out.println("5 - Listrar Livros por categoria");
            System.out.println("6 - Listrar autores por categoria");
            System.out.println("7 - Quantidade de livros");
            System.out.println("8 - Quantidade de livros por categoria");
            System.out.println("99 - Sair");
            System.out.println("Digite a opção desejada");
            opc = s.nextInt();
            switch (opc){
                case 3: //listar estantes
                    System.out.println("Estantes na Biblioteca: ");
                    for(int i = 0; i < biblioteca.getEstantes().size();i++){
                        System.out.println("====ESTANTE Nº" + i+1 + "====");
                        System.out.println(biblioteca.getEstantes().toString());
                    }
                break;
                case 4: //listar livros
                    System.out.println("Listar todos os livros:");
                    biblioteca.listarTudo();
                break;
                case 5: //listar livros por categoria
                    System.out.println("Escolha a categoria do livro: ");
                    do {
                        System.out.println("1 - Ciência");
                        System.out.println("2 - Filosofia");
                        System.out.println("3 - Literatura");
                        opcCat = s.nextInt();
                        switch (opcCat) {
                            case 1:
                                if (biblioteca.listarCiencia().length != 0){
                                    for(int i = 0; i < biblioteca.listarCiencia().length;i++){
                                        System.out.println(biblioteca.listarCiencia()[i]);
                                    }
                                }else
                                    System.out.println("Vazio...");
                                break;
                            case 2:
                                if (biblioteca.listarFilosofia().length != 0){
                                    for(int i = 0; i < biblioteca.listarFilosofia().length;i++){
                                        System.out.println(biblioteca.listarFilosofia()[i]);
                                    }
                                }else
                                    System.out.println("Vazio...");
                                break;
                            case 3:
                                if (biblioteca.listarLiteratura().length != 0){
                                    for(int i = 0; i < biblioteca.listarLiteratura().length;i++){
                                        System.out.println(biblioteca.listarLiteratura()[i]);
                                    }
                                }else
                                    System.out.println("Vazio...");
                                break;
                            default:
                                System.out.println("Opção inválida...");
                        }
                    } while (opcCat != 1 && opcCat != 2 && opcCat != 3);
                break;
                case 6: //listar autores por categoria
                    System.out.println("Escolha a categoria desejada: ");
                    this.opcoesCat();
                    if(biblioteca.listarAutores(cat).size() != 0){
                        for(int i = 0; i < biblioteca.listarAutores(cat).size();i++){
                            System.out.println("==== AUTOR Nº" + i+1 + "====");
                            System.out.println(biblioteca.listarAutores(cat).toString());
                        }
                    } else
                        System.out.println("Vazio...");
                break;
                case 7: //quantidade de livros
                    System.out.println("Quantidade de livros: " + biblioteca.contarLivros());
                break;
                case 8: //quantidade de livros por categoria
                    System.out.println("Escolha a categoria do livro: ");
                    do {
                        System.out.println("1 - Ciência");
                        System.out.println("2 - Filosofia");
                        System.out.println("3 - Literatura");
                        opcCat = s.nextInt();
                        switch (opcCat) {
                            case 1:
                                System.out.println("Quantidade de livros de Ciencia: " + biblioteca.contarCiencia());
                                break;
                            case 2:
                                System.out.println("Quantidade de livros de Filosofia: " + biblioteca.contarFilosofia());
                                break;
                            case 3:
                                System.out.println("Quantidade de livros de Literatura: " + biblioteca.contarLiteratura());
                                break;
                            default:
                                System.out.println("Opção inválida...");
                        }
                    } while (opcCat != 1 && opcCat != 2 && opcCat != 3);
                break;
                case 99:
                    System.out.println("Saindo...");
                break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                break;
            }
        }
    }  
    
    public void mostrarMenuBibliotecario(){
        while(opc != 99){
            System.out.println("==== TELA DE LOGIN - BIBLIOTECÁRIO ====");
            System.out.println("2 - Adicionar Livro");
            System.out.println("3 - Listar Estantes");
            System.out.println("4 - Listar Livros");
            System.out.println("5 - Listrar Livros por categoria");
            System.out.println("6 - Listrar autores por categoria");
            System.out.println("7 - Quantidade de livros");
            System.out.println("8 - Quantidade de livros por categoria");
            System.out.println("99 - Sair");
            System.out.println("Digite a opção desejada");
            opc = s.nextInt();
            switch (opc){
                case 2: //adicionar livro
                    System.out.println("Digitar o nome da estante a ser add o livro: ");
                    nomeEstante = entradaString.nextLine();
                    if (biblioteca.pesquisarEstante(nomeEstante)) {
			System.out.println("Nome do Livro: ");
			nomeLivro = entradaString.nextLine();
			System.out.println("Autor: ");
			autor = entradaString.nextLine();
			System.out.println("Ano de Publicação: ");
			anoP = s.nextInt();
			livro = new Livro(nomeLivro, autor, anoP);
			estante.inserirLivro(livro);
                    } else
			System.out.println("Não há estante com esse nome...");
                break;
                case 3: //listar estantes
                    System.out.println("Estantes na Biblioteca: ");
                    for(int i = 0; i < biblioteca.getEstantes().size();i++){
                        System.out.println("====ESTANTE Nº" + i+1 + "====");
                        System.out.println(biblioteca.getEstantes().toString());
                    }
                break;
                case 4: //listar livros
                    System.out.println("Listar todos os livros:");
                    biblioteca.listarTudo();
                break;
                case 5: //listar livros por categoria
                    System.out.println("Escolha a categoria do livro: ");
                    do {
                        System.out.println("1 - Ciência");
                        System.out.println("2 - Filosofia");
                        System.out.println("3 - Literatura");
                        opcCat = s.nextInt();
                        switch (opcCat) {
                            case 1:
                                for(int i = 0; i < biblioteca.listarCiencia().length;i++){
                                    System.out.println(biblioteca.listarCiencia()[i]);
                                }
                                break;
                            case 2:
                                for(int i = 0; i < biblioteca.listarFilosofia().length;i++){
                                    System.out.println(biblioteca.listarFilosofia()[i]);
                                }
                                break;
                            case 3:
                                for(int i = 0; i < biblioteca.listarLiteratura().length;i++){
                                    System.out.println(biblioteca.listarLiteratura()[i]);
                                }
                                break;
                            default:
                                System.out.println("Opção inválida...");
                        }
                    } while (opcCat != 1 && opcCat != 2 && opcCat != 3);
                break;
                case 6: //listar autores por categoria
                    System.out.println("Escolha a categoria desejada: ");
                    this.opcoesCat();
                    if(biblioteca.listarAutores(cat).size() != 0){
                        for(int i = 0; i < biblioteca.listarAutores(cat).size();i++){
                            System.out.println("==== AUTOR Nº" + i+1 + "====");
                            System.out.println(biblioteca.listarAutores(cat).toString());
                        }
                    } else
                        System.out.println("Vazio...");
                break;
                case 7: //quantidade de livros
                    System.out.println("Quantidade de livros: " + biblioteca.contarLivros());
                break;
                case 8: //quantidade de livros por categoria
                    System.out.println("Escolha a categoria do livro: ");
                    do {
                        System.out.println("1 - Ciência");
                        System.out.println("2 - Filosofia");
                        System.out.println("3 - Literatura");
                        opcCat = s.nextInt();
                        switch (opcCat) {
                            case 1:
                                System.out.println("Quantidade de livros de Ciencia: " + biblioteca.contarCiencia());
                                break;
                            case 2:
                                System.out.println("Quantidade de livros de Filosofia: " + biblioteca.contarFilosofia());
                                break;
                            case 3:
                                System.out.println("Quantidade de livros de Literatura: " + biblioteca.contarLiteratura());
                                break;
                            default:
                                System.out.println("Opção inválida...");
                        }
                    } while (opcCat != 1 && opcCat != 2 && opcCat != 3);
                break;
                case 99:
                    System.out.println("Saindo...");
                break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                break;
            }
        }
    }  
    
    public void mostrarMenuAdmin(){
        while(opc != 99){
            System.out.println("==== TELA DE LOGIN - ADMIN ====");
            System.out.println("1 - Adicionar Estante");
            System.out.println("2 - Adicionar Livro");
            System.out.println("3 - Listar Estantes");
            System.out.println("4 - Listar Livros");
            System.out.println("5 - Listrar Livros por categoria");
            System.out.println("6 - Listrar autores por categoria");
            System.out.println("7 - Quantidade de livros");
            System.out.println("8 - Quantidade de livros por categoria");
            System.out.println("9 - Remover Estante");
            System.out.println("10 - Remover Livro");
            System.out.println("99 - Sair");
            System.out.println("Digite a opção desejada");
            opc = s.nextInt();
            switch (opc){
                case 1: //adicionar estante
                    if (biblioteca != null){
                        System.out.println("Digite o nome da nova Estante: ");
                        nomeEstante = entradaString.nextLine();
			System.out.println("Escolha a categoria da nova Estante: ");
			this.opcoesCat();
			estante = new Estante(nomeEstante, cat);
                        biblioteca.inserirEstante(estante);
                        System.out.println("Estante adicionada");
                    }             
                break;
                case 2: //adicionar livro
                    System.out.println("Digitar o nome da estante a ser add o livro: ");
                    nomeEstante = entradaString.nextLine();
                    if (biblioteca.pesquisarEstante(nomeEstante)) {
			System.out.println("Nome do Livro: ");
			nomeLivro = entradaString.nextLine();
			System.out.println("Autor: ");
			autor = entradaString.nextLine();
			System.out.println("Ano de Publicação: ");
			anoP = s.nextInt();
			livro = new Livro(nomeLivro, autor, anoP);
			estante.inserirLivro(livro);
                    } else
			System.out.println("Não há estante com esse nome...");
                break;
                case 3: //listar estantes
                    System.out.println("Estantes na Biblioteca: ");
                    for(int i = 0; i < biblioteca.getEstantes().size();i++){
                        System.out.println("====ESTANTE Nº" + i+1 + "====");
                        System.out.println(biblioteca.getEstantes().toString());
                    }
                break;
                case 4: //listar livros
                    System.out.println("Listar todos os livros:");
                    biblioteca.listarTudo();
                break;
                case 5: //listar livros por categoria
                    System.out.println("Escolha a categoria do livro: ");
                    do {
                        System.out.println("1 - Ciência");
                        System.out.println("2 - Filosofia");
                        System.out.println("3 - Literatura");
                        opcCat = s.nextInt();
                        switch (opcCat) {
                            case 1:
                                for(int i = 0; i < biblioteca.listarCiencia().length;i++){
                                    System.out.println(biblioteca.listarCiencia()[i]);
                                }
                                break;
                            case 2:
                                for(int i = 0; i < biblioteca.listarFilosofia().length;i++){
                                    System.out.println(biblioteca.listarFilosofia()[i]);
                                }
                                break;
                            case 3:
                                for(int i = 0; i < biblioteca.listarLiteratura().length;i++){
                                    System.out.println(biblioteca.listarLiteratura()[i]);
                                }
                                break;
                            default:
                                System.out.println("Opção inválida...");
                        }
                    } while (opcCat != 1 && opcCat != 2 && opcCat != 3);
                break;
                case 6: //listar autores por categoria
                    System.out.println("Escolha a categoria desejada: ");
                    this.opcoesCat();
                    if(biblioteca.listarAutores(cat).size() != 0){
                        for(int i = 0; i < biblioteca.listarAutores(cat).size();i++){
                            System.out.println("==== AUTOR Nº" + i+1 + "====");
                            System.out.println(biblioteca.listarAutores(cat).toString());
                        }
                    } else
                        System.out.println("Vazio...");
                break;
                case 7: //quantidade de livros
                    System.out.println("Quantidade de livros: " + biblioteca.contarLivros());
                break;
                case 8: //quantidade de livros por categoria
                    System.out.println("Escolha a categoria do livro: ");
                    do {
                        System.out.println("1 - Ciência");
                        System.out.println("2 - Filosofia");
                        System.out.println("3 - Literatura");
                        opcCat = s.nextInt();
                        switch (opcCat) {
                            case 1:
                                System.out.println("Quantidade de livros de Ciencia: " + biblioteca.contarCiencia());
                                break;
                            case 2:
                                System.out.println("Quantidade de livros de Filosofia: " + biblioteca.contarFilosofia());
                                break;
                            case 3:
                                System.out.println("Quantidade de livros de Literatura: " + biblioteca.contarLiteratura());
                                break;
                            default:
                                System.out.println("Opção inválida...");
                        }
                    } while (opcCat != 1 && opcCat != 2 && opcCat != 3);
                break;
                case 9: //remover estante
                    System.out.println("Digitar o nome da estante a ser removida: ");
	            nomeEstante = entradaString.next();
	            if (biblioteca.removerEstante(nomeEstante))
                        System.out.println("Estante " + nomeEstante + " removida.");
	            else
                        System.out.println("Estante inexistente ou com livros.");
	        break;
                case 10: //remover livro
                    System.out.println("Digitar o nome do livro a ser removido: ");
                    nomeLivro = entradaString.next();
                    if(estante.pesquisarLivro(nomeLivro)){
                        estante.removerLivroNome(nomeLivro);
                        System.out.println("Livro " + nomeLivro + " removido.");
                    }else
                        System.out.println("Livro inexistente.");
                break;
                case 99:
                    System.out.println("Saindo...");
                break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                break;
            }
        }
    }  
    
    public void opcoesCat() {
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
}
