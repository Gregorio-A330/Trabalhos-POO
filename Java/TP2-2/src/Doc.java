
public class Doc {

	public void transferir(Cliente c1, Cliente c2, double quantia) {
		if (c1.checarSaldo() >= quantia) {
			c1.sacar(quantia);
			c2.depositar(quantia);
		}

	}
}
