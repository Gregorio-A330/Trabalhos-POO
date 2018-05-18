import java.util.ArrayList
import java.util.InputMismatchException

class Usuario @Throws(InputMismatchException::class)
constructor(login: String) {
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

	fun descricaoUsuario() {
		println("Log-off " + login)
	}

	fun despedidaUsuario() {
		println("")
	}

	fun getLogin(): ArrayList<String> {
		return login;
	}
}