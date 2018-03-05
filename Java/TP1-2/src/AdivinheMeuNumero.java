import java.util.Scanner;

public class AdivinheMeuNumero
{
  public static void main(String[] args)
  {
  
    AdvinhatorClass adivinha = new AdvinhatorClass();
    
    boolean continua = false;
    
    while (!continua) {
        System.out.println("Entre com o seu número: ");
       	Scanner leitor = new Scanner(System.in);		
      	adivinha.advinhation(leitor.nextInt());
      	
    }
    
  }  
}
