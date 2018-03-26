
public class Cliente {

	String nome;
	private double saldo;
	private double limite;

	public Cliente(String nome, double limite) {
		this.nome = nome;
		this.limite = limite;
	}

	public void depositar(double valor) {
		this.saldo += valor;
	}

	public void sacar(double valor) {
		if (valor <= saldo + limite) {
			saldo -= valor;
		}
	}

	public double checarSaldo() {
		return saldo + limite;
	}

	public String getNome() {
		return nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getLimite() {
		return limite;
	}

}
