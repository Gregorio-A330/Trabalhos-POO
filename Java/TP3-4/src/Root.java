public class Root extends Usuario {

	public Root(String login) {
		super(login);
	}

	public void despedidaRoot() {
		System.out.println("Log-off " + super.getLogin());
	}

	public void descricaoRoot() {
		System.out.println("Acesso Total.");
		System.out.println("Voc� pode excluir todos os usu�rios");
	}

	public void excluirTodos() {
		System.out.println("Voc� 'excluiu' todos os usu�rios");
	}
}