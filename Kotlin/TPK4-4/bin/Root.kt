class Root(login:String):Usuario(login) {
  fun menuRoot() {
    println("Menu:")
    println("1-Permiss�es")
    println("2-Op��es de Grupo")
    println("8-Trocar de Usu�rio")
    println("9-Sair")
    println("Op��o: ")
  }
  fun despedidaRoot() {
    System.out.println("Log-off " + super.getLogin())
  }
  fun descricaoRoot() {
    println("Acesso Total.")
    println("Voc� pode excluir todos os usu�rios")
  }
  fun excluirTodos() {
    println("Voc� 'excluiu' todos os usu�rios")
  }
}