class Regular(login:String):Usuario(login) {
  fun menuRegular() {
    println("Menu:")
    println("1-Permissões")
    println("2-Dashboard")
    println("8-Trocar de Usuário")
    println("9-Sair")
    println("Opção: ")
  }
  fun despedidaUsuario() {
    System.out.println("Log-off " + super.getLogin())
  }
  fun descricaoUsuario() {
    println("Pode consultar suas informações.")
  }
  fun dashboard() {
    System.out.println("Usuario: " + super.getLogin())
    println("Tipo: Regular")
    print("Permissoes: ")
    this.descricaoUsuario()
  }
}