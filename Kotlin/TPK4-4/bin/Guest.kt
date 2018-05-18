class Guest(login:String):Usuario(login) {
  fun menuGuest() {
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
    println("Permissões Restritas...")
  }
}