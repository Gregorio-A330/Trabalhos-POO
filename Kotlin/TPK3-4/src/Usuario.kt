import java.util.ArrayList

open public class Usuario(login: String) {
	//Armazenador de Strings...
	private var login: ArrayList<String>

	init {
		this.login = ArrayList<String>()
		this.login.add(login)
	}

	fun buscaLogin(login: String): Boolean {
		return this.login.contains(login)
	}

	fun Saudacao() {
		println("Bem-vindo " + login + ".")
	}

	fun getLogin():ArrayList<String> {
		return login;
	}
}