class trabalho1x1 {
  internal var ligada:Int = 0
  internal var queimada:Int = 0
  internal var x:Int = 0
  internal fun lampadanova() {
    ligada = 0
    queimada = 10
  }
	
  internal fun lampadaqueimada() {
    println("Lampada Queimada...")
  }
	
  internal fun estado() {
    if (ligada == queimada)
    lampadaqueimada()
    else if (x == 0)
    println("Lampada Apagada...")
    else
    println("Lampada Acesa...")
  }
	
  internal fun click() {
    if (ligada == queimada)
    lampadaqueimada()
    else if (x == 0)
    {
      x = 1
      println("Acendeu...")
      ligada++
    }
    else
    {
      x = 0
      println("Apagou...")
    }
  }
}