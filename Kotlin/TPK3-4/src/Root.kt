class Root(login:String):Usuario(login) {
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