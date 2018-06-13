package interface_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import codigos.Fornecedor;

public class FormFornecedor extends JFrame {

	// conexao bd teste
	static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";
	String[] colunasTabela = new String[] { "CNPJ", "Nome", "Telefone", "E-mail", "Endereço" };

	/**
		 * 
		 */
	private static final long serialVersionUID = -2990655854353442316L;
	private JTextField tfTelefone;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfEndereco;
	private JTextField tfCNPJ;
	static JTable tab;
	static DefaultTableModel modeloTabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormFornecedor frame = new FormFornecedor();
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
	public FormFornecedor() {

		setTitle("Fornecedor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 398);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome*");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNome.setBounds(289, 36, 46, 14);
		getContentPane().add(lblNome);

		JLabel lblCnpj = new JLabel("CNPJ*");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCnpj.setToolTipText("Somente n\u00FAmeros (12345678901234)");
		lblCnpj.setBounds(10, 36, 46, 14);
		getContentPane().add(lblCnpj);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(138, 36, 46, 14);
		getContentPane().add(lblTelefone);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(10, 87, 46, 14);
		getContentPane().add(lblEmail);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEndereo.setBounds(289, 87, 46, 14);
		getContentPane().add(lblEndereo);

		JLabel lblCadastroDeFornecedor = new JLabel("Cadastro de Fornecedor");
		lblCadastroDeFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCadastroDeFornecedor.setBounds(10, 11, 161, 14);
		getContentPane().add(lblCadastroDeFornecedor);

		tfTelefone = new JTextField();
		tfTelefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				// permite apenas números
				String caracteres = "(0987654321-)";
				if (!caracteres.contains(evt.getKeyChar() + ""))
					evt.consume();
			}

		});
		tfTelefone.setBounds(152, 56, 111, 20);
		getContentPane().add(tfTelefone);
		tfTelefone.setColumns(10);

		tfNome = new JTextField();
		tfNome.setBounds(299, 56, 243, 20);
		getContentPane().add(tfNome);
		tfNome.setColumns(10);

		tfEmail = new JTextField();
		tfEmail.setBounds(20, 112, 243, 20);
		getContentPane().add(tfEmail);
		tfEmail.setColumns(10);

		tfEndereco = new JTextField();
		tfEndereco.setBounds(299, 112, 243, 20);
		getContentPane().add(tfEndereco);
		tfEndereco.setColumns(10);

		tfCNPJ = new JTextField();
		tfCNPJ.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent evt) {
				// permite apenas números
				String caracteres = "0987654321";
				if (!caracteres.contains(evt.getKeyChar() + ""))
					evt.consume();
			}

		});
		tfCNPJ.setBounds(20, 56, 104, 20);
		getContentPane().add(tfCNPJ);
		tfCNPJ.setColumns(10);

		JLabel lblAviso = new JLabel("Campos marcados com * n\u00E3o podem ser alterados");
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAviso.setBounds(30, 143, 249, 14);
		getContentPane().add(lblAviso);

		// -----------------------BOTÕES------------------------//
		// BOTÃO CANCELAR

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfCNPJ.setEnabled(true);
				tfNome.setEnabled(true);
				zerarCampos();

			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(338, 335, 89, 23);
		getContentPane().add(btnCancelar);

		// BOTÃO CADASTRAR
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				((DefaultTableModel) tab.getModel()).setNumRows(0);// essa linha
																	// limpa a
																	// tabela

				Fornecedor objFor = new Fornecedor(tfCNPJ.getText(), tfNome.getText(), tfTelefone.getText(),
						tfEmail.getText(), tfEndereco.getText());

				if (validarCampos()) {
					objFor.salvar(objFor);
					zerarCampos();
					// //////////////////////////////////////////////////////
					atualizaTabela();

					// ///////////////////////////////////////////////////

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

				Fornecedor objFunc = new Fornecedor(tfCNPJ.getText(), tfNome.getText(), tfTelefone.getText(),
						tfEmail.getText(), tfEndereco.getText());

				objFunc.deletar(objFunc);
				zerarCampos();
				tfCNPJ.setEnabled(true);
				tfNome.setEnabled(true);
				((DefaultTableModel) tab.getModel()).setNumRows(0);// essa linha
																	// limpa a
																	// tabela
				// //////////////////////////////////////////////////////
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

				Fornecedor objFunc = new Fornecedor(tfCNPJ.getText(), tfNome.getText(), tfTelefone.getText(),
						tfEmail.getText(), tfEndereco.getText());
				if (validarCampos()) {
					objFunc.alterar(objFunc);
					zerarCampos();
					tfCNPJ.setEnabled(true);
					tfNome.setEnabled(true);
					((DefaultTableModel) tab.getModel()).setNumRows(0);// essa linha
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

					tfCNPJ.setText(tab.getValueAt(tab.getSelectedRow(), 0).toString());
					tfNome.setText(tab.getValueAt(tab.getSelectedRow(), 1).toString());
					tfTelefone.setText(tab.getValueAt(tab.getSelectedRow(), 2).toString());
					tfEmail.setText(tab.getValueAt(tab.getSelectedRow(), 3).toString());
					tfEndereco.setText(tab.getValueAt(tab.getSelectedRow(), 4).toString());

					tfCNPJ.setEnabled(false);
					tfNome.setEnabled(false);
				}
			});
			tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tab.setFillsViewportHeight(true);
			tab.setModel(modeloTabela);

			// DB connection
			con = DriverManager.getConnection(DATABASE_URL, "root", "root");
			stm = con.createStatement();
			rs = stm.executeQuery("select * from fornecedor");
			while (rs.next()) {
				modeloTabela.addRow(new String[] { rs.getString("cnpj"), rs.getString("nome"), rs.getString("telefone"),
						rs.getString("email"), rs.getString("endereco") });

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

	}// fim do construtor do FormFornecedor

	// zerar campos maoe
	public void zerarCampos() {
		tfCNPJ.setText("");
		tfNome.setText("");
		tfTelefone.setText("");
		tfEmail.setText("");
		tfEndereco.setText("");
	}

	public boolean validarCampos() {

		int livre = 0;
		String vazio = "";

		// início cnpj validação
		if ((tfCNPJ.getText().equals(vazio)) || (tfCNPJ.getText().equals(null))) {

			JOptionPane.showMessageDialog(null, "O CNPJ deve ser inserido!", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);

			livre = 1;

		}

		if (tfCNPJ.getText() != "") {
			String strCNPJ = tfCNPJ.getText();
			if (strCNPJ.length() != 14) {

				JOptionPane.showMessageDialog(null, "Digite um valor válido no campo CNPJ", "Erro de validação",
						JOptionPane.ERROR_MESSAGE);
				livre = 1;
			}
		} // fim cnpj validação

		// início telefone validação
		if ((tfTelefone.getText().equals(vazio)) || (tfTelefone.getText().equals(null))) {

			JOptionPane.showMessageDialog(null, "O telefone deve ser inserido!", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);

			livre = 1;

		}

		if (tfTelefone.getText() != "") {
			String strTel = tfTelefone.getText();
			if (strTel.length() >= 15) {

				JOptionPane.showMessageDialog(null, "Digite um valor válido no campo telefone", "Erro de validação",
						JOptionPane.ERROR_MESSAGE);
				livre = 1;
			}
		} // fim telefone validação

		// início nome validação
		if ((tfNome.getText().equals(vazio)) || (tfNome.getText().equals(null))) {

			JOptionPane.showMessageDialog(null, "O nome deve ser inserido!", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);

			livre = 1;

		}
		// fim telefone validação

		if (livre == 0)
			return true;

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
			rs = stm.executeQuery("select * from fornecedor");
			while (rs.next()) {
				modeloTabela.addRow(new String[] { rs.getString("cnpj"), rs.getString("nome"), rs.getString("telefone"),
						rs.getString("email"), rs.getString("endereco") });
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados.", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
