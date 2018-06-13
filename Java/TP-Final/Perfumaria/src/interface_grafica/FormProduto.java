package interface_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import codigos.Fornecedor;
import codigos.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class FormProduto extends JFrame {

	// conexao bd teste
	static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";
	String[] colunasTabela = new String[] { "Cod", "Nome", "Marca", "Preço de Compra", "Preço de Venda", "Fornecedor" };

	/**
		 * 
		 */

	private static final long serialVersionUID = -2990655854353442316L;
	private static JTextField tfMarca;
	private static JTextField tfNome;
	private static JTextField tfPrecoCompra;
	private static JTextField tfCod;
	static JTable tab;
	static DefaultTableModel modeloTabela;
	private static JTextField tfPrecoVenda;
	private static String fornecedorCB = "";

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProduto frame = new FormProduto();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public FormProduto() {

		setTitle("Produto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 398);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNome.setBounds(140, 36, 46, 14);
		getContentPane().add(lblNome);

		JLabel lblCod = new JLabel("C\u00F3digo*");
		lblCod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCod.setToolTipText("Somente n\u00FAmeros (12345)");
		lblCod.setBounds(10, 36, 46, 14);
		getContentPane().add(lblCod);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarca.setBounds(410, 36, 46, 14);
		getContentPane().add(lblMarca);

		JLabel lblPrecoCompra = new JLabel("Pre\u00E7o de Compra");
		lblPrecoCompra.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecoCompra.setBounds(41, 92, 89, 14);
		getContentPane().add(lblPrecoCompra);

		JLabel lblCadastroDeProduto = new JLabel("Cadastro de Produto");
		lblCadastroDeProduto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCadastroDeProduto.setBounds(10, 11, 161, 14);
		getContentPane().add(lblCadastroDeProduto);

		tfMarca = new JTextField();
		tfMarca.setBounds(420, 56, 111, 20);
		getContentPane().add(tfMarca);
		tfMarca.setColumns(10);

		tfNome = new JTextField();
		tfNome.setBounds(150, 56, 243, 20);
		getContentPane().add(tfNome);
		tfNome.setColumns(10);

		tfPrecoCompra = new JTextField();
		tfPrecoCompra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				// só pode digitar números e ponto
				String caracteres = "0987654321.";
				if (!caracteres.contains(evt.getKeyChar() + ""))
					evt.consume();
			}
		});
		tfPrecoCompra.setBounds(67, 117, 104, 20);
		getContentPane().add(tfPrecoCompra);
		tfPrecoCompra.setColumns(10);

		tfCod = new JTextField();
		tfCod.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent evt) {
				// permite apenas números
				String caracteres = "0987654321";
				if (!caracteres.contains(evt.getKeyChar() + ""))
					evt.consume();
			}

		});

		tfCod.setBounds(20, 56, 104, 20);
		getContentPane().add(tfCod);
		tfCod.setColumns(10);

		// -----------------------BOTÕES------------------------//
		// BOTÃO CADASTRAR
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				((DefaultTableModel) tab.getModel()).setNumRows(0);// essa
																	// linha
																	// limpa
																	// a
																	// tabela

				// String a = String.valueOf(ComboBox.getSelectedItem());

				Produto objProd = new Produto();

				objProd.setCod(tfCod.getText());
				objProd.setNome(tfNome.getText());
				objProd.setMarca(tfMarca.getText());
				objProd.setPreco_compra(tfPrecoCompra.getText());
				objProd.setPreco_venda(tfPrecoVenda.getText());
				objProd.setFornecedor(fornecedorCB);

				if (validarCampos()) {
					objProd.salvar(objProd);
					zerarCampos();
					// //////////////////////////////////////////////////////

					atualizaTabela();

				}
			}
		});

		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrar.setBounds(41, 335, 89, 23);
		getContentPane().add(btnCadastrar);
		// FIM BOTÃO CADASTRAR

		// BOTÃO DELETAR
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Produto objProd = new Produto();

				objProd.setCod(tfCod.getText());
				objProd.setNome(tfNome.getText());
				objProd.setMarca(tfMarca.getText());
				objProd.setPreco_compra(tfPrecoCompra.getText());
				objProd.setPreco_venda(tfPrecoVenda.getText());
				objProd.setFornecedor(fornecedorCB);

				objProd.deletar(objProd);
				zerarCampos();
				tfCod.setEnabled(true);
				((DefaultTableModel) tab.getModel()).setNumRows(0);// essa linha
																	// limpa a
																	// tabela

				atualizaTabela();

				// ///////////////////////////////////////////////////

			}
		});

		btnDeletar.setBounds(140, 335, 89, 23);
		getContentPane().add(btnDeletar);
		// FIM BOTÃO DELETAR

		// BOTÃO ALTERAR----------------------ALTERARRARARARAARARARARAR
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (validarCamposAlterar()) {
					Produto objProd = new Produto();

					objProd.setCod(tfCod.getText());
					objProd.setNome(tfNome.getText());
					objProd.setMarca(tfMarca.getText());
					objProd.setPreco_compra(tfPrecoCompra.getText());
					objProd.setPreco_venda(tfPrecoVenda.getText());
					objProd.setFornecedor(fornecedorCB);

					objProd.alterar(objProd);
					zerarCampos();
					tfCod.setEnabled(true);
					((DefaultTableModel) tab.getModel()).setNumRows(0);// essa
																		// linha
					// limpa a
					// tabela
					// //////////////////////////////////////////////////////

					atualizaTabela();

				}
			}
		});

		btnAlterar.setBounds(239, 335, 89, 23);
		getContentPane().add(btnAlterar);
		// FIM BOTÃO ALTERAR

		// BOTÃO SAIR
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(437, 335, 89, 23);
		getContentPane().add(btnSair);
		// FIM BOTÃO SAIR

		// -----------------------FIM BOTÕES------------------------//
		// /////////////////////////////////////////////

		// -------------------TABELA---------------------//
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			// Table Model
			modeloTabela = new DefaultTableModel(null, colunasTabela) {
				/**
					 * 
					 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int rowIndex, int mColIndex) {
					return false;
				}
			};
			tab = new JTable();
			tab.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					// campoNome.setText(tabAplicacao.getValueAt(tabAplicacao.getSelectedRow(),
					// numeroColuna).toString());

					tfCod.setText(tab.getValueAt(tab.getSelectedRow(), 0).toString());
					tfNome.setText(tab.getValueAt(tab.getSelectedRow(), 1).toString());
					tfMarca.setText(tab.getValueAt(tab.getSelectedRow(), 2).toString());
					tfPrecoCompra.setText(tab.getValueAt(tab.getSelectedRow(), 3).toString());
					tfPrecoVenda.setText(tab.getValueAt(tab.getSelectedRow(), 4).toString());

					// tfCod.setEditable(true);

					tfCod.setEnabled(false);

					// String.valueOf((tab.getValueAt(tab.getSelectedRow(), 5)))
					// String.valueOf(ComboBox.getSelectedItem())
					// (tab.getValueAt(tab.getSelectedRow(), 5));

				}
			});
			tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tab.setFillsViewportHeight(true);
			tab.setModel(modeloTabela);

			// DB connection
			con = DriverManager.getConnection(DATABASE_URL, "root", "Uikujgt2@");
			stm = con.createStatement();
			rs = stm.executeQuery("select * from produto");
			while (rs.next()) {
				modeloTabela.addRow(new String[] { rs.getString("cod"), rs.getString("nome"), rs.getString("marca"),
						rs.getString("preco_compra"), rs.getString("preco_venda"), rs.getString("fornecedor") });

			}

			JPanel painelTabela = new JPanel();
			painelTabela.setBounds(21, 171, 521, 153);
			painelTabela.add(new JScrollPane(tab));
			painelTabela.setLayout(new GridLayout(1, 1));
			getContentPane().add(painelTabela, BorderLayout.CENTER);

		} catch (SQLException s) {
			System.err.println(s);
		} catch (Exception e) {
			System.err.println(e);
		}

		// /////////////////////////////////////////////

		// ----------------------FIM TABELA---------------------------//

		JLabel lblAviso = new JLabel("Campos marcados com * n\u00E3o podem ser alterados");
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAviso.setBounds(30, 143, 249, 14);
		getContentPane().add(lblAviso);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// tfCod.setEditable(true);

				tfCod.setEnabled(true);
				zerarCampos();

			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(338, 335, 89, 23);
		getContentPane().add(btnCancelar);

		tfPrecoVenda = new JTextField();
		tfPrecoVenda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				// só pode digitar números e ponto
				String caracteres = "0987654321.";
				if (!caracteres.contains(evt.getKeyChar() + ""))
					evt.consume();
			}
		});
		tfPrecoVenda.setColumns(10);
		tfPrecoVenda.setBounds(239, 117, 111, 20);
		getContentPane().add(tfPrecoVenda);

		JLabel lblPrecoVenda = new JLabel("Pre\u00E7o de Venda");
		lblPrecoVenda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecoVenda.setBounds(225, 92, 89, 14);
		getContentPane().add(lblPrecoVenda);

		JComboBox<String> cboFornecedor = new JComboBox<String>();
		cboFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cboFornecedor.setBounds(392, 117, 111, 20);
		getContentPane().add(cboFornecedor);

		JLabel lblFornecedor = new JLabel("Fornecedor*");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFornecedor.setBounds(384, 92, 83, 14);
		getContentPane().add(lblFornecedor);

		ArrayList<Fornecedor> ArrFor = new ArrayList<Fornecedor>();
		ArrFor = selecionaFornecedor();

		cboFornecedor.addItem("");
		for (Fornecedor f : ArrFor) {
			cboFornecedor.addItem(f.getNome());
		}

		cboFornecedor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				fornecedorCB = (String) cboFornecedor.getSelectedItem();
			}
		});

	}// fim do construtor do FormFuncionario

	// zerar campos maoe
	public static void zerarCampos() {
		tfCod.setText("");
		tfNome.setText("");
		tfMarca.setText("");
		tfPrecoCompra.setText("");
		tfPrecoVenda.setText("");

	}

	public boolean validarCampos() {

		int livre = 0;
		String vazio = "";

		if ((tfCod.getText().equals(vazio)) || (tfCod.getText().equals(null))) {

			JOptionPane.showMessageDialog(null, "O código deve ser inserido!", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);

			livre = 1;

		}

		if ((tfNome.getText().equals(vazio)) || (tfNome.getText().equals(null))) {

			JOptionPane.showMessageDialog(null, "O nome deve ser inserido!", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);

			livre = 1;
		}

		// ----------Preços----------------//

		if ((tfPrecoCompra.getText().equals(vazio)) || (tfPrecoVenda.getText().equals(vazio))
				|| (Double.parseDouble(tfPrecoCompra.getText()) >= Double.parseDouble(tfPrecoVenda.getText()))) {
			JOptionPane.showMessageDialog(null,
					"Digite os preços corretamente! Preço de venda deve ser maior que o preço de compra!",
					"Erro de validação", JOptionPane.ERROR_MESSAGE);

			livre = 1;
		}

		if ((tfMarca.getText().equals(vazio)) || (tfMarca.getText().equals(null))) {

			JOptionPane.showMessageDialog(null, "A marca deve ser inserida!", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);

			livre = 1;
		}

		if ((tfCod.getText().length()) > 5) {

			JOptionPane.showMessageDialog(null, "O código está sendo digitado errado, ele deve conter até 5 dígitos.",
					"Erro de validação", JOptionPane.ERROR_MESSAGE);
			livre = 1;
		}

		if (fornecedorCB == "") {
			JOptionPane.showMessageDialog(null, "Informe um fornecedor.", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);

			livre = 1;
		}
		if (livre == 0)
			return true;

		atualizaTabela();
		return false;
	}

	public ArrayList<Fornecedor> selecionaFornecedor() {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			// Criar a conexao
			con = DriverManager.getConnection(DATABASE_URL, "root", "Uikujgt2@");
			// Criacao comando
			stm = con.createStatement();
			rs = stm.executeQuery("select * from fornecedor");
			// Criar o metadado da tabela

			ArrayList<Fornecedor> ArrFor = new ArrayList<Fornecedor>();
			String cnpj;
			String nome;
			String email;
			String endereco;
			String telefone;
			// utiliza e mostra os mostra
			while (rs.next()) {
				cnpj = rs.getString("cnpj");
				nome = rs.getString("nome");
				email = rs.getString("email");
				endereco = rs.getString("endereco");
				telefone = rs.getString("telefone");
				Fornecedor forn = new Fornecedor(cnpj, nome, email, endereco, telefone);

				ArrFor.add(forn);
			}
			// Fechar os objetos
			rs.close();
			stm.close();
			con.close();
			return ArrFor;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	public boolean validarCamposAlterar() {

		int livre = 0;
		String vazio = "";

		if ((tfCod.getText().equals(vazio)) || (tfCod.getText().equals(null))) {

			JOptionPane.showMessageDialog(null, "O código deve ser inserido!", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);

			livre = 1;

		}

		if ((tfCod.getText().length()) > 5) {

			JOptionPane.showMessageDialog(null, "O código está sendo digitado errado, ele deve conter até 5 dígitos.",
					"Erro de validação", JOptionPane.ERROR_MESSAGE);
			livre = 1;
		}

		if ((tfNome.getText().equals(vazio)) || (tfNome.getText().equals(null))) {

			JOptionPane.showMessageDialog(null, "O nome deve ser inserido!", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);

			livre = 1;
		}

		if ((tfMarca.getText().equals(vazio)) || (tfMarca.getText().equals(null))) {

			JOptionPane.showMessageDialog(null, "A marca deve ser inserida!", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);

			livre = 1;
		}

		// ----------Preços----------------//

		if ((tfPrecoCompra.getText().equals(vazio)) || (tfPrecoVenda.getText().equals(vazio))
				|| (Double.parseDouble(tfPrecoCompra.getText()) >= Double.parseDouble(tfPrecoVenda.getText()))) {
			JOptionPane.showMessageDialog(null,
					"Digite os preços corretamente! Preço de venda deve ser maior que o preço de compra!",
					"Erro de validação", JOptionPane.ERROR_MESSAGE);
			livre = 1;
		}

		if (livre == 0) {
			return true;
		}

		atualizaTabela();
		return false;
	}

	public static void atualizaTabela() {

		((DefaultTableModel) tab.getModel()).setNumRows(0);// essa linha limpa a
															// tabela
		// ////////////////////////////////////////////////////
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(DATABASE_URL, "root", "Uikujgt2@");
			stm = con.createStatement();
			rs = stm.executeQuery("select * from produto");
			while (rs.next()) {
				modeloTabela.addRow(new String[] { rs.getString("cod"), rs.getString("nome"), rs.getString("marca"),
						rs.getString("preco_compra"), rs.getString("preco_venda"), rs.getString("fornecedor") });
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível carregar os dados da tabela.", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
}
