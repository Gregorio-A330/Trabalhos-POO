import java.util.InputMismatchException
import java.util.Scanner

class Menu {
	private var entrada = Scanner(System.`in`)
	private var opc: Int = 0
	private lateinit var usuario: String
	private lateinit var login: String
	private var root = Root("root")
	private var regular = Regular("regular")
	private var guest = Guest("guest")
	private var group = Group("group")
	fun login() {
		do {
			println("Login: ")
			// hasNext esse método retorna true enquanto existe proximo elemento na lista,
			// geralmente é usado com o método Next();
			while (entrada.hasNext("\n")) {
				entrada.next()
			}
			try {
				// nextLine() insere a entrada via Scanner...
				login = entrada.nextLine()
				if (root.buscaLogin(login)) {
					usuario = login
					break
				} else if (guest.buscaLogin(login)) {
					usuario = login
					break
				} else if (regular.buscaLogin(login)) {
					usuario = login
					break
				} else if (group.buscaLogin(login)) {
					usuario = login
					break
				} else if ((login != "root" || login != "regular" || login != "guest"
								|| login != "group")) {
					println("Usuário não existe.")
				}
			} catch (e: InputMismatchException) {
				println(e.message)
				entrada.reset()
			}
		} while (login != usuario)
	}

	fun menu() {
		do {
			login()
			// equals compara a (entrada) com a variavel
			if (usuario == "root") {
				root.Saudacao()
				do {
					root.menuRoot()
					try {
						opc = entrada.nextInt()
						when (opc) {
							1 -> root.descricaoRoot()
							2 -> root.excluirTodos()
							8 -> {
								root.despedidaRoot()
								entrada.reset()
							}
							9 -> {
								root.despedidaRoot()
								entrada.reset()
							}
							else -> println("Opção Inválida!")
						}
					} catch (e: InputMismatchException) {
						println(e.message)
						entrada.reset()
					}
				} while (opc != 9 && opc != 8)
			}
			if (usuario == "guest") {
				guest.Saudacao()
				do {
					guest.menuGuest()
					try {
						opc = entrada.nextInt()
						when (opc) {
							1 -> guest.descricaoUsuario()
							2 -> println("Nada Consta")
							8 -> {
								guest.despedidaUsuario()
								entrada.reset()
							}
							9 -> {
								guest.despedidaUsuario()
								entrada.reset()
							}
							else -> println("Opção Inválida!")
						}
					} catch (e: InputMismatchException) {
						println(e.message)
						entrada.reset()
					}
				} while (opc != 9 && opc != 8)
			}
			if (usuario == "group") {
				group.Saudacao()
				do {
					group.menuGroup()
					try {
						opc = entrada.nextInt()
						when (opc) {
							1 -> group.descricaoUsuario()
							2 -> group.groupBoard()
							8 -> {
								group.despedidaUsuario()
								entrada.reset()
							}
							9 -> {
								group.despedidaUsuario()
								entrada.reset()
							}
							else -> println("Opção Inválida!")
						}
					} catch (e: InputMismatchException) {
						println(e.message)
						entrada.reset()
					}
				} while (opc != 9 && opc != 8)
			}
			if (usuario == "regular") {
				regular.Saudacao()
				do {
					regular.menuRegular()
					try {
						opc = entrada.nextInt()
						when (opc) {
							1 -> regular.descricaoUsuario()
							2 -> regular.dashboard()
							8 -> {
								regular.despedidaUsuario()
								entrada.reset()
							}
							9 -> {
								regular.despedidaUsuario()
								entrada.reset()
							}
							else -> println("Opção Inválida!")
						}
					} catch (e: InputMismatchException) {
						println(e.message)
						entrada.reset()
					}
				} while (opc != 9 && opc != 8)
			}
		} while (opc != 9)
	}
}