public class Regular extends Usuario {

	public Regular(String login) {
		super(login);
	}

	public void menuRegular() {
		System.out.println("Menu:");
		System.out.println("1-Permiss�es");
		System.out.println("2-Dashboard");
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
		System.out.println("Pode consultar suas informa��es.");
	}

	public void dashboard() {
		System.out.println("Usuario: " + super.getLogin());
		System.out.println("Tipo: Regular");
		System.out.print("Permissoes: ");
		this.descricaoUsuario();
	}
}