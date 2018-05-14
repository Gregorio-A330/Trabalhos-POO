public class Root extends Usuario {

	public Root(String login) {
		super(login);
	}

	public void menuRoot() {
		System.out.println("Menu:");
		System.out.println("1-Permissões");
		System.out.println("2-Opções de Grupo");
		System.out.println("8-Trocar de Usuário");
		System.out.println("9-Sair");
		System.out.println("Opção: ");
	}

	public void despedidaRoot() {
		System.out.println("Log-off " + super.getLogin());
	}

	public void descricaoRoot() {
		System.out.println("Acesso Total.");
		System.out.println("Você pode excluir todos os usuários");
	}

	public void excluirTodos() {
		System.out.println("Você 'excluiu' todos os usuários");
	}
}