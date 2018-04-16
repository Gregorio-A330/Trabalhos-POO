class Guest(login:String):Usuario(login) {
  fun despedidaGuest() {
    System.out.println("Log-off " + super.getLogin())
  }
  fun descricaoGuest() {
    println("Permissões Restritas...")
  }
}