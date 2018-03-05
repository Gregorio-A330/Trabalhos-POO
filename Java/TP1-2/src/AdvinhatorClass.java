import java.util.Random;

class AdvinhatorClass
{
  private int aleatorio;
  private Random rand;
  
  public AdvinhatorClass() {
    rand = new Random();
    aleatorio = rand.nextInt(100);
    System.out.println(this.newRandomNumber());
  }
  
  public String newRandomNumber() {
    aleatorio = rand.nextInt(100);
  	return "Estou com um novo número";
  }
  
  public boolean advinhation(int guess) {
    
    if (guess > aleatorio) {
      System.out.println("Número chutado é maior que o que eu tenho!" + " Seu número foi: " + guess);
	} else if (guess < aleatorio) {
      System.out.println("Número chutado é menor que o que eu tenho!" + " Seu número foi: " + guess);
	} else { 
      System.out.println("Acerto miserávi! O número é o " + aleatorio + " mesmo.");
      return true;
    }
    return false;
        
  }  
}