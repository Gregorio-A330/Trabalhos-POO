import java.util.InputMismatchException;
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
			System.out.println("Login: ");
			// hasNext esse método retorna true enquanto existe proximo elemento na lista,
			// geralmente é usado com o método Next();
			while (entrada.hasNext("\n")) {
				entrada.next();
			}
			try {
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
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				entrada.reset();
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
					root.menuRoot();
					try {
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
							entrada.reset();
							break;
						case 9:
							root.despedidaRoot();
							entrada.reset();
							break;
						default:
							System.out.println("Opção Inválida!");
						}
					} catch (InputMismatchException e) {
						System.out.println(e.getMessage());
						entrada.reset();
					}
				} while (opc != 9 && opc != 8);
			}
			if (usuario.equals("guest")) {
				guest.Saudacao();
				do {
					guest.menuGuest();
					try {
						opc = entrada.nextInt();
						switch (opc) {
						case 1:
							guest.descricaoUsuario();
							break;
						case 2:
							System.out.println("Nada Consta");
							break;
						case 8:
							guest.despedidaUsuario();
							entrada.reset();
							break;
						case 9:
							guest.despedidaUsuario();
							entrada.reset();
							break;
						default:
							System.out.println("Opção Inválida!");
						}
					} catch (InputMismatchException e) {
						System.out.println(e.getMessage());
						entrada.reset();
					}
				} while (opc != 9 && opc != 8);
			}
			if (usuario.equals("group")) {
				group.Saudacao();
				do {
					group.menuGroup();
					try {
						opc = entrada.nextInt();
						switch (opc) {
						case 1:
							group.descricaoUsuario();
							break;
						case 2:
							group.groupBoard();
							break;
						case 8:
							group.despedidaUsuario();
							entrada.reset();
							break;
						case 9:
							group.despedidaUsuario();
							entrada.reset();
							break;
						default:
							System.out.println("Opção Inválida!");
						}
					} catch (InputMismatchException e) {
						System.out.println(e.getMessage());
						entrada.reset();
					}
				} while (opc != 9 && opc != 8);
			}
			if (usuario.equals("regular")) {
				regular.Saudacao();
				do {
					regular.menuRegular();
					try {
						opc = entrada.nextInt();
						switch (opc) {
						case 1:
							regular.descricaoUsuario();
							break;
						case 2:
							regular.dashboard();
							break;
						case 8:
							regular.despedidaUsuario();
							entrada.reset();
							break;
						case 9:
							regular.despedidaUsuario();
							entrada.reset();
							break;
						default:
							System.out.println("Opção Inválida!");
						}
					} catch (InputMismatchException e) {
						System.out.println(e.getMessage());
						entrada.reset();
					}
				} while (opc != 9 && opc != 8);
			}
		} while (opc != 9);
	}
}