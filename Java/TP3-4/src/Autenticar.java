
public class Autenticar {
	protected String perfil;
	protected String acc;
	protected String senha;

	public Autenticar(String perfil, String acc, String senha) {
		this.perfil = perfil;
		this.acc = acc;
		this.senha = senha;
	}

	public void Logar() {
		if (perfil.equals("Guest") || perfil.equals("guest")) {
			System.out.println("Login Temporario como Guest");
		} else if (acc.equals("gabriel") && senha.equals("22022021")) {
			System.out.println("Login Efetuado como Perfil Regular.");
		} else if(perfil.equals("root") && senha.equals("root")){
			System.out.println("Usuario ou Senha Invalida...");
		} else if(perfil.equals("group")) {
			System.out.println("Entrada em Perfil Comum de Grupo.");
		}
	}

	public String getAcc() {
		return acc;
	}

	public String getPerfil() {
		return perfil;
	}

	public String getSenha() {
		return senha;
	}

}
