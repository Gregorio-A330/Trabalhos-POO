public class Root extends Usuario {

	public Root(String login) {
		super(login);
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