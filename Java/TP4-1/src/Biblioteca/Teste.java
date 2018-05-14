package Biblioteca;
import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
     
    public static void main(String ... args){
        int opc =0;
        System.out.println("==== TELA DE LOGIN ====");
        do{
            Menu menu = new Menu();
            String senha;
            Scanner s = new Scanner(System.in);
            System.out.println("1 - Convidado");
            System.out.println("2 - Bibliotecário");
            System.out.println("3 - Admin");
            System.out.println("99 - Sair");
            System.out.println("Digite a opção: ");
            opc = s.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Digite a senha: ");
                    senha=s.next();
                    if(senha.equalsIgnoreCase("convidado"))
                        menu.mostrarMenuConvidado();
                    else
                        System.out.println("Senha inválida.");
                    break;
                case 2:
                    System.out.println("Digite a senha: ");
                    senha=s.next();
                    if(senha.equalsIgnoreCase("bibliotecario"))
                        menu.mostrarMenuBibliotecario();
                    else
                        System.out.println("Senha inválida.");
                    break;
                case 3:
                    System.out.println("Digite a senha: ");
                    senha=s.next();
                    if(senha.equalsIgnoreCase("admin"))
                        menu.mostrarMenuAdmin();
                    else
                        System.out.println("Senha inválida.");
                    break;
                case 99:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }while(opc != 99);
    }
}