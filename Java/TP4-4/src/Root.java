public class Root extends Usuario {

	public Root(String login) {
		super(login);
	}

	public void menuRoot() {
		System.out.println("Menu:");
		System.out.println("1-Permiss�es");
		System.out.println("2-Op��es de Grupo");
		System.out.println("8-Trocar de Usu�rio");
		System.out.println("9-Sair");
		System.out.println("Op��o: ");
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