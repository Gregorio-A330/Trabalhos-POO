import java.util.Random;

internal class AdvinhatorClass {
  private var aleatorio:Int
  private var rand:Random
  init{
    rand = Random()
    aleatorio = rand.nextInt(100)
    println(this.newRandomNumber())
  }
  fun newRandomNumber():String {
    aleatorio = rand.nextInt(100)
    return "Estou com um novo numero"
  }
  fun advinhation(guess:Int):Boolean {
    if (guess > aleatorio)
    {
      println("Numero chutado é maior que o que eu tenho!" + " Seu numero foi: " + guess)
    }
    else if (guess < aleatorio)
    {
      println("Numero chutado é menor que o que eu tenho!" + " Seu numero foi: " + guess)
    }
    else
    {
      println("Acertou! O numero é o " + aleatorio + " mesmo.")
      return true
    }
    return false
  }
}