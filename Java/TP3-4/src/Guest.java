public class Guest extends Usuario {

	public Guest(String login) {
		super(login);
	}

	public void despedidaGuest() {
		System.out.println("Log-off " + super.getLogin());
	}

	public void descricaoGuest() {
		System.out.println("Permissões Restritas...");
	}
}