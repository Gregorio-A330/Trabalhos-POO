import java.util.Scanner

class Menu {
	private var entrada = Scanner(System.`in`)
	private var opc: Int = 0
	private lateinit var Usuario: String
	private lateinit var login: String
	private var root = Root("root")
	private var regular = Regular("regular")
	private var guest = Guest("guest")
	private var group = Group("group")
	fun login() {
		do {
			println("Digite seu login: ")
			// hasNext esse método retorna true enquanto existe proximo elemento na lista,
			// geralmente é usado com o método Next();
			while (entrada.hasNext("\n")) {
				entrada.next()
			}
			// nextLine() insere a entrada via Scanner...
			login = entrada.nextLine()
			if (root.buscaLogin(login)) {
				Usuario = login
				break
			} else if (guest.buscaLogin(login)) {
				Usuario = login
				break
			} else if (regular.buscaLogin(login)) {
				Usuario = login
				break
			} else if (group.buscaLogin(login)) {
				Usuario = login
				break
			} else if ((login != "root" || login != "regular" || login != "guest"
							|| login != "group")) {
				println("Usuário não existe.")
			}
		} while (login != Usuario)
	}

	fun menu() {
		do {
			login()
			// equals compara a (entrada) com a variavel
			if (Usuario == "root") {
				root.Saudacao()
				do {
					println("Menu:")
					println("1-Permissões")
					println("2-Opções de Grupo")
					println("8-Trocar de Usuário")
					println("9-Sair")
					println("Opção: ")
					opc = entrada.nextInt()
					when (opc) {
						1 -> root.descricaoRoot()
						2 -> root.excluirTodos()
						8 -> root.despedidaRoot()
						9 -> root.despedidaRoot()
						else -> println("Opção Inválida!")
					}
				} while (opc != 9 && opc != 8)
			}
			if (Usuario == "guest") {
				guest.Saudacao()
				do {
					println("Menu:")
					println("1-Permissões")
					println("2-Opções de Grupo")
					println("8-Trocar de Usuário")
					println("9-Sair")
					println("Opção: ")
					opc = entrada.nextInt()
					when (opc) {
						1 -> guest.descricaoGuest()
						2 -> println("Nada Consta")
						8 -> guest.despedidaGuest()
						9 -> guest.despedidaGuest()
						else -> println("Opção Inválida!")
					}
				} while (opc != 9 && opc != 8)
			}
			if (Usuario == "group") {
				group.Saudacao()
				do {
					println("Menu:")
					println("1-Permissões")
					println("2-Opções de Grupo")
					println("8-Trocar de Usuário")
					println("9-Sair")
					println("Opção: ")
					opc = entrada.nextInt()
					when (opc) {
						1 -> group.descricaoGroup()
						2 -> group.groupBoard()
						8 -> group.despedidaGroup()
						9 -> group.despedidaGroup()
						else -> println("Opção Inválida!")
					}
				} while (opc != 9 && opc != 8)
			}
			if (Usuario == "regular") {
				regular.Saudacao()
				do {
					println("Menu:")
					println("1-Permissões")
					println("2-Dashboard")
					println("8-Trocar de Usuário")
					println("9-Sair")
					println("Opção: ")
					opc = entrada.nextInt()
					when (opc) {
						1 -> regular.descricaoRegular()
						2 -> regular.dashboard()
						8 -> regular.despedidaRegular()
						9 -> regular.despedidaRegular()
						else -> println("Opção Inválida!")
					}
				} while (opc != 9 && opc != 8)
			}
		} while (opc != 9)
	}
}