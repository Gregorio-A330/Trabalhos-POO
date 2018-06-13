package codigos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Funcionario extends Pessoa {

	// atributos
	public String cpf;

	// construtor
	public Funcionario(String cpf, String nome, String email, String endereco, String telefone) {

		super(nome, email, endereco, telefone);
		this.cpf = cpf;

	}

	// m�todos get e set
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	// m�todo toString()
	@Override
	public String toString() {
		return super.toString() + "\nCPF: " + cpf;
	}

	///////////////

	public void salvar(Funcionario f) {

		Connection con = null;
		String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";

		try {
			// Criar a conexao
			con = DriverManager.getConnection(DATABASE_URL, "root", "Uikujgt2@");
			// Cria��o do comando
			PreparedStatement insere = con.prepareStatement(
					"insert into " + "funcionario(cpf, nome, telefone, email, endereco) " + "values (?,?,?,?,?)");
			insere.setString(1, f.getCpf());
			insere.setString(2, f.getNome());
			insere.setString(3, f.getTelefone());
			insere.setString(4, f.getEmail());
			insere.setString(5, f.getEndereco());
			// Executar o comando
			insere.executeUpdate();
			// Fechar o comando e a conex�o
			insere.close();
			con.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel salvar os dados.", "Erro de valida��o",
					JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel salvar os dados.", "Erro de valida��o",
					JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		}
	}

	public void deletar(Funcionario f) {
		Connection con = null;
		String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";

		try {
			// Criar a conexao
			con = DriverManager.getConnection(DATABASE_URL, "root", "Uikujgt2@");
			// Cria��o do comando
			PreparedStatement remove = con.prepareStatement("delete from funcionario where cpf like ?");
			remove.setString(1, f.getCpf());
			// Executar o comando
			remove.executeUpdate();
			// Fechar o comando e a conex�o
			remove.close();
			con.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel deletar os dados.", "Erro de valida��o",
					JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel deletar os dados.", "Erro de valida��o",
					JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		}
	}

	public void alterar(Funcionario f) {

		Connection con = null;
		String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";

		try {
			// Criar a conexao
			con = DriverManager.getConnection(DATABASE_URL, "root", "Uikujgt2@");
			// Cria��o do comando
			PreparedStatement alterar = con
					.prepareStatement("update funcionario set telefone = ?, email = ? , endereco = ? where cpf like ?");
			alterar.setString(1, f.getTelefone());
			alterar.setString(2, f.getEmail());
			alterar.setString(3, f.getEndereco());
			alterar.setString(4, f.getCpf());
			// Executar o comando
			alterar.executeUpdate();
			// Fechar o comando e a conex�o
			alterar.close();
			con.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel alterar os dados.", "Erro de valida��o",
					JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel alterar os dados.", "Erro de valida��o",
					JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		}
	}

}
