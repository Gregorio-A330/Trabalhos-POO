class Regular(login:String):Usuario(login) {
  fun despedidaRegular() {
    System.out.println("Log-off " + super.getLogin())
  }
  fun descricaoRegular() {
    println("Pode consultar suas informa��es.")
  }
  fun dashboard() {
    System.out.println("Usuario: " + super.getLogin())
    println("Tipo: Regular")
    print("Permissoes: ")
    this.descricaoRegular()
  }
}