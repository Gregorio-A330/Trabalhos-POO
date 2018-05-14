public class Group extends Usuario {

	public Group(String login) {
		super(login);
	}

	public void menuGroup() {
		System.out.println("Menu:");
		System.out.println("1-Permissões");
		System.out.println("2-Opções de Grupo");
		System.out.println("8-Trocar de Usuário");
		System.out.println("9-Sair");
		System.out.println("Opção: ");
	}

	@Override
	public void despedidaUsuario() {
		System.out.println("Log-off " + super.getLogin());
	}

	@Override
	public void descricaoUsuario() {
		System.out.println("Pode participar de Grupos.");
	}

	public void groupBoard() {
		System.out.println("Você remover Usuários deste Grupo");
	}
}