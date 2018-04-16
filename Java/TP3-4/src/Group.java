public class Group extends Usuario {

	public Group(String login) {
		super(login);
	}

	public void despedidaGroup() {
		System.out.println("Log-off " + super.getLogin());
	}

	public void descricaoGroup() {
		System.out.println("Pode participar de Grupos.");
	}

	public void groupBoard() {
		System.out.println("Você remover Usuários deste Grupo");
	}
}