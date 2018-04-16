class Root(login:String):Usuario(login) {
  fun despedidaRoot() {
    System.out.println("Log-off " + super.getLogin())
  }
  fun descricaoRoot() {
    println("Acesso Total.")
    println("Você pode excluir todos os usuários")
  }
  fun excluirTodos() {
    println("Você 'excluiu' todos os usuários")
  }
}