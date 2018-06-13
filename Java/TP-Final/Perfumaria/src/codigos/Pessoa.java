package codigos;

public class Pessoa {

	// atributos

	public String nome, email, endereco, telefone;

	// construtor
	public Pessoa(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	// métodos get e set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	// método toString

	public String toString() {
		return "Pessoa: \nNome: " + nome + "\nEmail: " + email + "\nEndereco: " + endereco + "\nTelefone: " + telefone;
	}

}
