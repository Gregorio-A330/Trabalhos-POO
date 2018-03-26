
public class Operacao {

	public static void main(String[] args) {

		Cliente cliente = new Cliente("Felipe", 10);
		Cliente cliente2 = new Cliente("Marllon", 1000);
		Doc doc = new Doc();
		cliente2.depositar(1000);
		cliente.depositar(100);
		cliente2.sacar(200);
		cliente.sacar(20);
		System.out.println(cliente2.checarSaldo());
		System.out.println(cliente.checarSaldo());
		doc.transferir(cliente2, cliente, 800);
		System.out.println(cliente2.checarSaldo());
		System.out.println(cliente.checarSaldo());

	}

}
