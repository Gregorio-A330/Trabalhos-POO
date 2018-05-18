class Group(login: String) : Usuario(login) {
	fun menuGroup() {
		println("Menu:")
		println("1-Permissões")
		println("2-Opções de Grupo")
		println("8-Trocar de Usuário")
		println("9-Sair")
		println("Opção: ")
	}

	
	fun despedidaUsuario() {
		System.out.println("Log-off " + super.getLogin())
	}

	fun descricaoUsuario() {
		println("Pode participar de Grupos.")
	}

	fun groupBoard() {
		println("Você remover Usuários deste Grupo")
	}
}