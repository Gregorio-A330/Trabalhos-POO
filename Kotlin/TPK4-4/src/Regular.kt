class Regular(login:String):Usuario(login) {
  fun menuRegular() {
    println("Menu:")
    println("1-Permiss�es")
    println("2-Dashboard")
    println("8-Trocar de Usu�rio")
    println("9-Sair")
    println("Op��o: ")
  }
  fun despedidaUsuario() {
    System.out.println("Log-off " + super.getLogin())
  }
  fun descricaoUsuario() {
    println("Pode consultar suas informa��es.")
  }
  fun dashboard() {
    System.out.println("Usuario: " + super.getLogin())
    println("Tipo: Regular")
    print("Permissoes: ")
    this.descricaoUsuario()
  }
}