class Group(login:String):Usuario(login) {
  fun despedidaGroup() {
    System.out.println("Log-off " + super.getLogin())
  }
  fun descricaoGroup() {
    println("Pode participar de Grupos.")
  }
  fun groupBoard() {
    println("Voc� remover Usu�rios deste Grupo")
  }
}