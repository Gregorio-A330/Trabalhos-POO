class Cliente(nome:String, limite:Double) {
  var nome:String
  internal set
  var saldo:Double = 0.toDouble()
  var limite:Double = 0.toDouble()
  init{
    this.nome = nome
    this.limite = limite
  }
  fun depositar(valor:Double) {
    this.saldo += valor
  }
  fun sacar(valor:Double) {
    if (valor <= saldo + limite)
    {
      saldo -= valor
    }
  }
  fun checarSaldo():Double {
    return saldo + limite
  }
}