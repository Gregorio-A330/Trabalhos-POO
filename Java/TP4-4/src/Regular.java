public class Regular extends Usuario {

	public Regular(String login) {
		super(login);
	}

	public void menuRegular() {
		System.out.println("Menu:");
		System.out.println("1-Permissões");
		System.out.println("2-Dashboard");
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
		System.out.println("Pode consultar suas informações.");
	}

	public void dashboard() {
		System.out.println("Usuario: " + super.getLogin());
		System.out.println("Tipo: Regular");
		System.out.print("Permissoes: ");
		this.descricaoUsuario();
	}
}