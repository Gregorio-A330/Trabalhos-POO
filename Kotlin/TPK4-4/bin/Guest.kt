class Guest(login:String):Usuario(login) {
  fun menuGuest() {
    println("Menu:")
    println("1-Permiss�es")
    println("2-Op��es de Grupo")
    println("8-Trocar de Usu�rio")
    println("9-Sair")
    println("Op��o: ")
  }
  fun despedidaUsuario() {
    System.out.println("Log-off " + super.getLogin())
  }
  fun descricaoUsuario() {
    println("Permiss�es Restritas...")
  }
}