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
  	return "Estou com um novo n�mero";
  }
  
  public boolean advinhation(int guess) {
    
    if (guess > aleatorio) {
      System.out.println("N�mero chutado � maior que o que eu tenho!" + " Seu n�mero foi: " + guess);
	} else if (guess < aleatorio) {
      System.out.println("N�mero chutado � menor que o que eu tenho!" + " Seu n�mero foi: " + guess);
	} else { 
      System.out.println("Acerto miser�vi! O n�mero � o " + aleatorio + " mesmo.");
      return true;
    }
    return false;
        
  }  
}