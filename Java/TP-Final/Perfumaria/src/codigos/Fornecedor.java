package codigos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Fornecedor extends Pessoa {

	// atributos
	public String cnpj;

	// construtor
	public Fornecedor(String cnpj, String nome, String email, String endereco, String telefone) {

		super(nome, email, endereco, telefone);
		this.cnpj = cnpj;
	}

	// métodos get e set
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	// método toString()
	@Override
	public String toString() {
		return super.toString() + "\nCNPJ: " + cnpj;
	}

	// /////////////

	public void salvar(Fornecedor f) {

		Connection con = null;
		String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";

		try {
			// Criar a conexao
			con = DriverManager.getConnection(DATABASE_URL, "root", "Uikujgt2@");
			// Criação do comando
			PreparedStatement insere = con.prepareStatement(
					"insert into " + "fornecedor(cnpj, nome, telefone, email, endereco) " + "values (?,?,?,?,?)");
			insere.setString(1, f.getCnpj());
			insere.setString(2, f.getNome());
			insere.setString(3, f.getTelefone());
			insere.setString(4, f.getEmail());
			insere.setString(5, f.getEndereco());
			// Executar o comando
			insere.executeUpdate();
			// Fechar o comando e a conexão
			insere.close();
			con.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados.", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados.", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		}
	}

	public void deletar(Fornecedor f) {
		Connection con = null;
		String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";

		try {
			// Criar a conexao
			con = DriverManager.getConnection(DATABASE_URL, "root", "Uikujgt2@");
			// Criação do comando
			PreparedStatement remove = con.prepareStatement("delete from fornecedor where cnpj like ?");
			remove.setString(1, f.getCnpj());
			// Executar o comando
			remove.executeUpdate();
			// Fechar o comando e a conexão
			remove.close();
			con.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível deletar os dados.", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível deletar os dados.", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		}
	}

	public void alterar(Fornecedor f) {

		Connection con = null;
		String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";

		try {
			// Criar a conexao
			con = DriverManager.getConnection(DATABASE_URL, "root", "Uikujgt2@");
			// Criação do comando
			PreparedStatement alterar = con
					.prepareStatement("update fornecedor set telefone = ?, email = ? , endereco = ? where cnpj like ?");
			alterar.setString(1, f.getTelefone());
			alterar.setString(2, f.getEmail());
			alterar.setString(3, f.getEndereco());
			alterar.setString(4, f.getCnpj());
			// Executar o comando
			alterar.executeUpdate();
			// Fechar o comando e a conexão
			alterar.close();
			con.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível alterar os dados.", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível alterar os dados.", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		}
	}

}
