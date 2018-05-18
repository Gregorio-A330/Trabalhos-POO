class Root(login:String):Usuario(login) {
  fun menuRoot() {
    println("Menu:")
    println("1-Permissões")
    println("2-Opções de Grupo")
    println("8-Trocar de Usuário")
    println("9-Sair")
    println("Opção: ")
  }
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