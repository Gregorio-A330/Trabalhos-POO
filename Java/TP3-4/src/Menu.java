import java.util.Scanner;

public class Menu {
	private Scanner entrada = new Scanner(System.in);
	private int opc;
	private String usuario, login;
	private Root root = new Root("root");
	private Regular regular = new Regular("regular");
	private Guest guest = new Guest("guest");
	private Group group = new Group("group");

	public void login() {
		do {
			System.out.println("Digite seu login: ");
			// hasNext esse método retorna true enquanto existe proximo elemento na lista,
			// geralmente é usado com o método Next();
			while (entrada.hasNext("\n")) {
				entrada.next();
			}
			// nextLine() insere a entrada via Scanner...
			login = entrada.nextLine();
			if (root.buscaLogin(login)) {
				usuario = login;
				break;
			} else if (guest.buscaLogin(login)) {
				usuario = login;
				break;
			} else if (regular.buscaLogin(login)) {
				usuario = login;
				break;
			} else if (group.buscaLogin(login)) {
				usuario = login;
				break;
			} else if (!login.equals("root") || !login.equals("regular") || !login.equals("guest")
					|| !login.equals("group")) {
				System.out.println("Usuário não existe.");
			}
		} while (!login.equals(usuario));
	}

	public void menu() {
		do {
			login();
			// equals compara a (entrada) com a variavel
			if (usuario.equals("root")) {
				root.Saudacao();
				do {
					System.out.println("Menu:");
					System.out.println("1-Permissões");
					System.out.println("2-Opções de Grupo");
					System.out.println("8-Trocar de Usuário");
					System.out.println("9-Sair");
					System.out.println("Opção: ");
					opc = entrada.nextInt();
					switch (opc) {
					case 1:
						root.descricaoRoot();
						break;
					case 2:
						root.excluirTodos();
						break;
					case 8:
						root.despedidaRoot();
						break;
					case 9:
						root.despedidaRoot();
						break;
					default:
						System.out.println("Opção Inválida!");
					}
				} while (opc != 9 && opc != 8);
			}
			if (usuario.equals("guest")) {
				guest.Saudacao();
				do {
					System.out.println("Menu:");
					System.out.println("1-Permissões");
					System.out.println("2-Opções de Grupo");
					System.out.println("8-Trocar de Usuário");
					System.out.println("9-Sair");
					System.out.println("Opção: ");
					opc = entrada.nextInt();
					switch (opc) {
					case 1:
						guest.descricaoGuest();
						break;
					case 2:
						System.out.println("Nada Consta");
						break;
					case 8:
						guest.despedidaGuest();
						break;
					case 9:
						guest.despedidaGuest();
						break;
					default:
						System.out.println("Opção Inválida!");
					}
				} while (opc != 9 && opc != 8);
			}
			if (usuario.equals("group")) {
				group.Saudacao();
				do {
					System.out.println("Menu:");
					System.out.println("1-Permissões");
					System.out.println("2-Opções de Grupo");
					System.out.println("8-Trocar de Usuário");
					System.out.println("9-Sair");
					System.out.println("Opção: ");
					opc = entrada.nextInt();
					switch (opc) {
					case 1:
						group.descricaoGroup();
						break;
					case 2:
						group.groupBoard();
						break;
					case 8:
						group.despedidaGroup();
						break;
					case 9:
						group.despedidaGroup();
						break;
					default:
						System.out.println("Opção Inválida!");
					}
				} while (opc != 9 && opc != 8);
			}
			if (usuario.equals("regular")) {
				regular.Saudacao();
				do {
					System.out.println("Menu:");
					System.out.println("1-Permissões");
					System.out.println("2-Dashboard");
					System.out.println("8-Trocar de Usuário");
					System.out.println("9-Sair");
					System.out.println("Opção: ");
					opc = entrada.nextInt();
					switch (opc) {
					case 1:
						regular.descricaoRegular();
						break;
					case 2:
						regular.dashboard();
						break;
					case 8:
						regular.despedidaRegular();
						break;
					case 9:
						regular.despedidaRegular();
						break;
					default:
						System.out.println("Opção Inválida!");
					}
				} while (opc != 9 && opc != 8);
			}
		} while (opc != 9);
	}
}