public class Guest extends Usuario {

	public Guest(String login) {
		super(login);
	}

	public void menuGuest() {
		System.out.println("Menu:");
		System.out.println("1-Permiss�es");
		System.out.println("2-Op��es de Grupo");
		System.out.println("8-Trocar de Usu�rio");
		System.out.println("9-Sair");
		System.out.println("Op��o: ");
	}

	@Override
	public void despedidaUsuario() {
		System.out.println("Log-off " + super.getLogin());
	}

	@Override
	public void descricaoUsuario() {
		System.out.println("Permiss�es Restritas...");
	}
}