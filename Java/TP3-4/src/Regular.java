public class Regular extends Usuario {

	public Regular(String login) {
		super(login);
	}

	public void despedidaRegular() {
		System.out.println("Log-off " + super.getLogin());
	}

	public void descricaoRegular() {
		System.out.println("Pode consultar suas informações.");
	}

	public void dashboard() {
		System.out.println("Usuario: " + super.getLogin());
		System.out.println("Tipo: Regular");
		System.out.print("Permissoes: ");
		this.descricaoRegular();
	}
}