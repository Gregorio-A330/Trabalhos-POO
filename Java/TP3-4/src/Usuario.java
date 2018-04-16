import java.util.ArrayList;

public class Usuario {
	//Armazenador de Strings...
	private ArrayList<String> login;

	public Usuario(String login) {
		this.login = new ArrayList<>();
		this.login.add(login);
	}

	public ArrayList<String> getLogin() {
		return login;
	}

	public boolean buscaLogin(String login) {
		return this.login.contains(login);
	}

	public void Saudacao() {
		System.out.println("Bem-vindo " + login + ".");
	}
}