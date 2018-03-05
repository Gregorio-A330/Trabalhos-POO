object TP1x1 {
  @JvmStatic fun main(args:Array<String>) {

    val y:Int
   val z:Int
    val t = trabalho1x1()
    t.lampadanova()
	  y = 0
	  z=10
    
    do{
      t.click()
      t.estado()
      t.click()
      t.estado()
      t.click()
      t.click()
      y+1
    }while (y != z)
  }
}