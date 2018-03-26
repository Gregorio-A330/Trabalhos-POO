class Doc {
  fun transferir(c1:Cliente, c2:Cliente, quantia:Double) {
    if (c1.checarSaldo() >= quantia)
    {
      c1.sacar(quantia)
      c2.depositar(quantia)
    }
  }
}