object TPK2_2 {
  @JvmStatic fun main(args:Array<String>) {
    var cliente = Cliente("Felipe", 10.0)
    var cliente2 = Cliente("Marllon", 1000.0)
    var doc = Doc()
    cliente2.depositar(1000.0)
    cliente.depositar(100.0)
    cliente2.sacar(200.0)
    cliente.sacar(20.0)
    System.out.println(cliente2.checarSaldo())
    System.out.println(cliente.checarSaldo())
    doc.transferir(cliente2, cliente, 800.0)
    System.out.println(cliente2.checarSaldo())
    System.out.println(cliente.checarSaldo())
  }
}