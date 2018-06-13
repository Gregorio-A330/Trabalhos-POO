package codigos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Produto implements CRUDProdutoInterface {

	// atributos
	private String cod, nome, marca, preco_compra, preco_venda, fornecedor;

	public Produto(/*
					 * String cod, String nome, String marca,double preco_compra, double preco_venda
					 */) {
		/*
		 * this.cod = cod; this.preco_venda = preco_venda; this.preco_compra =
		 * preco_compra; this.nome = nome; this.marca = marca;
		 */
	}

	// //////////////////////////////////
	// ------------toString()-------------//
	@Override
	public String toString() {
		return "Produto: \nCod: " + cod + "\nPreco_venda: " + preco_venda + "\nPreco_compra: " + preco_compra
				+ "\nNome: " + nome + "\nMarca: " + marca;
	}

	// ------Fim toString()----------//

	// GET E SET
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(String preco_venda) {
		this.preco_venda = preco_venda;
	}

	public String getPreco_compra() {
		return preco_compra;
	}

	public void setPreco_compra(String preco_compra) {
		this.preco_compra = preco_compra;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	// ////FIM GET E SET///

	// ---------------MÉTODOS------------------//

	@Override
	public void salvar(Produto p) {
		Connection con = null;
		String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";

		try {
			// Criar a conexao
			con = DriverManager.getConnection(DATABASE_URL, "root", "Uikujgt2@");
			// Criação do comando
			PreparedStatement insere = con.prepareStatement(
					"insert into produto(cod, nome, marca, preco_compra, preco_venda, fornecedor) values (?,?,?,?,?,?)");
			insere.setString(1, p.getCod());
			insere.setString(2, p.getNome());
			insere.setString(3, p.getMarca());
			insere.setString(4, p.getPreco_compra());
			insere.setString(5, p.getPreco_venda());
			insere.setString(6, p.getFornecedor());
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

	@Override
	public void deletar(Produto p) {
		Connection con = null;
		String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";

		try {
			// Criar a conexao
			con = DriverManager.getConnection(DATABASE_URL, "root", "Uikujgt2@");
			// Criação do comando
			PreparedStatement remove = con.prepareStatement("delete from produto where cod like ?");
			remove.setString(1, p.getCod());
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

	@Override
	public void alterar(Produto p) {
		Connection con = null;
		String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";

		try {
			// Criar a conexao
			con = DriverManager.getConnection(DATABASE_URL, "root", "Uikujgt2@");
			// Criação do comando
			PreparedStatement alterar = con.prepareStatement(
					"update produto set nome = ?, marca = ?, preco_compra = ?, preco_venda = ? where cod like ?");
			alterar.setString(1, p.getNome());
			alterar.setString(2, p.getMarca());
			alterar.setString(3, p.getPreco_compra());
			alterar.setString(4, p.getPreco_venda());
			alterar.setString(5, p.getCod());
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
