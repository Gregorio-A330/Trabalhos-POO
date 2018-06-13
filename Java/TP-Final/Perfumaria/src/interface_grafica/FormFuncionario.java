package interface_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import codigos.Funcionario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormFuncionario extends JFrame {

	// conexao bd teste
	static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";
	String[] colunasTabela = new String[] { "CPF", "Nome", "Telefone",
			"E-mail", "Endere�o" };

	/**
	 * 
	 */
	private static final long serialVersionUID = -2990655854353442316L;
	private JTextField tfTelefone;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfEndereco;
	private JTextField tfCPF;
	static JTable tab;
	static DefaultTableModel modeloTabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormFuncionario frame = new FormFuncionario();
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
	public FormFuncionario() {

		setTitle("Funcion\u00E1rio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 398);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome*");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNome.setBounds(289, 36, 46, 14);
		getContentPane().add(lblNome);

		JLabel lblCpf = new JLabel("CPF*");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCpf.setToolTipText("Somente n\u00FAmeros (12345678900)");
		lblCpf.setBounds(10, 36, 46, 14);
		getContentPane().add(lblCpf);

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

		JLabel lblCadastroDeFuncionrio = new JLabel(
				"Cadastro de Funcion\u00E1rio");
		lblCadastroDeFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCadastroDeFuncionrio.setBounds(10, 11, 161, 14);
		getContentPane().add(lblCadastroDeFuncionrio);

		tfTelefone = new JTextField();
		tfTelefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				// permite apenas n�meros
				String caracteres = "(0987654321-)";
				if (!caracteres.contains(evt.getKeyChar() + ""))
					evt.consume();
			}

		});
		tfTelefone.setBounds(152, 56, 111, 20);
		getContentPane().add(tfTelefone);
		tfTelefone.setColumns(10);

		tfNome = new JTextField();
		tfNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {

				String caracteres = "(0987654321-/\"*+=�������90!@#$%�&*()_[]{};:><,|?)";
				if (caracteres.contains(evt.getKeyChar() + ""))
					evt.consume();
			}

		});
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

		tfCPF = new JTextField();
		tfCPF.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent evt) {
				// permite apenas n�meros
				String caracteres = "0987654321";
				if (!caracteres.contains(evt.getKeyChar() + ""))
					evt.consume();
			}

		});
		tfCPF.setBounds(20, 56, 104, 20);
		getContentPane().add(tfCPF);
		tfCPF.setColumns(10);


		JLabel lblAviso = new JLabel(
				"Campos marcados com * n\u00E3o podem ser alterados");
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAviso.setBounds(30, 143, 249, 14);
		getContentPane().add(lblAviso);

		
		// -----------------------BOT�ES------------------------//
		//BOT�O CANCELAR
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tfCPF.setEnabled(true);
				tfNome.setEnabled(true);
				zerarCampos();

			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(338, 335, 89, 23);
		getContentPane().add(btnCancelar);
		
		// BOT�O CADASTRAR
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				((DefaultTableModel) tab.getModel()).setNumRows(0);// essa linha
																	// limpa a
																	// tabela

				Funcionario objFunc = new Funcionario(tfCPF.getText(), tfNome
						.getText(), tfTelefone.getText(), tfEmail.getText(),
						tfEndereco.getText());
				if (validarCampos()) {
					objFunc.salvar(objFunc);
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
		// FIM BOT�O CADASTRAR

		// BOT�O DELETAR
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Funcionario objFunc = new Funcionario(tfCPF.getText(), tfNome
						.getText(), tfTelefone.getText(), tfEmail.getText(),
						tfEndereco.getText());

				objFunc.deletar(objFunc);
				zerarCampos();
				tfCPF.setEnabled(true);
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
		// FIM BOT�O DELETAR

		// BOT�O ALTERAR----------------------ALTERARRARARARAARARARARAR
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Funcionario objFunc = new Funcionario(tfCPF.getText(), tfNome
						.getText(), tfTelefone.getText(), tfEmail.getText(),
						tfEndereco.getText());

				if (validarCampos()) {
					objFunc.alterar(objFunc);
					zerarCampos();
					tfCPF.setEnabled(true);
					tfNome.setEnabled(true);
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
		// FIM BOT�O ALTERAR

		// BOT�O SAIR
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(437, 335, 89, 23);
		getContentPane().add(btnSair);
		// FIM BOT�O SAIR

		// -----------------------FIM BOT�ES------------------------//
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

					tfCPF.setText(tab.getValueAt(tab.getSelectedRow(), 0)
							.toString());
					tfNome.setText(tab.getValueAt(tab.getSelectedRow(), 1)
							.toString());
					tfTelefone.setText(tab.getValueAt(tab.getSelectedRow(), 2)
							.toString());
					tfEmail.setText(tab.getValueAt(tab.getSelectedRow(), 3)
							.toString());
					tfEndereco.setText(tab.getValueAt(tab.getSelectedRow(), 4)
							.toString());
					
					tfCPF.setEnabled(false);
					tfNome.setEnabled(false);
				}
			});
			tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tab.setFillsViewportHeight(true);
			tab.setModel(modeloTabela);

			// DB connection
			con = DriverManager.getConnection(DATABASE_URL, "root", "root");
			stm = con.createStatement();
			rs = stm.executeQuery("select * from funcionario");
			while (rs.next()) {
				modeloTabela.addRow(new String[] { rs.getString("cpf"),
						rs.getString("nome"), rs.getString("telefone"),
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

	}// fim do construtor do FormFuncionario

	// zerar campos maoe
	public void zerarCampos() {
		tfCPF.setText("");
		tfNome.setText("");
		tfTelefone.setText("");
		tfEmail.setText("");
		tfEndereco.setText("");
	}

	public boolean validarCampos() {

		int livre = 0;
		String vazio = "";

		// in�cio cpf valida��o
		if ((tfCPF.getText().equals(vazio)) || (tfCPF.getText().equals(null))) {

			JOptionPane.showMessageDialog(null, "O CPF deve ser inserido!",
					"Erro de valida��o", JOptionPane.ERROR_MESSAGE);

			livre = 1;

		}

		if (tfCPF.getText() != "") {
			String strCPF = tfCPF.getText();
			if (strCPF.length() != 11) {

				JOptionPane.showMessageDialog(null,
						"Digite um valor v�lido no campo CPF",
						"Erro de valida��o", JOptionPane.ERROR_MESSAGE);
				livre = 1;
			}
		}// fim cpf valida��o

		// in�cio telefone valida��o
		if ((tfTelefone.getText().equals(vazio))
				|| (tfTelefone.getText().equals(null))) {

			JOptionPane.showMessageDialog(null,
					"O telefone deve ser inserido!", "Erro de valida��o",
					JOptionPane.ERROR_MESSAGE);

			livre = 1;

		}

		if (tfTelefone.getText() != "") {
			String strTel = tfTelefone.getText();
			if (strTel.length() >= 15) {

				JOptionPane.showMessageDialog(null,
						"Digite um valor v�lido no campo telefone",
						"Erro de valida��o", JOptionPane.ERROR_MESSAGE);
				livre = 1;
			}
		}// fim telefone valida��o

		// in�cio nome valida��o
		if ((tfNome.getText().equals(vazio)) || (tfNome.getText().equals(null))) {

			JOptionPane.showMessageDialog(null, "O nome deve ser inserido!",
					"Erro de valida��o", JOptionPane.ERROR_MESSAGE);

			livre = 1;

		}
		// fim telefone valida��o

		// in�cio endere�o valida��o
		if ((tfEndereco.getText().equals(vazio))
				|| (tfEndereco.getText().equals(null))) {

			JOptionPane.showMessageDialog(null,
					"O endereco deve ser inserido!", "Erro de valida��o",
					JOptionPane.ERROR_MESSAGE);

			livre = 1;

		}
		// fim endere�o valida��o

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
			rs = stm.executeQuery("select * from funcionario");
			while (rs.next()) {
				modeloTabela.addRow(new String[] { rs.getString("cpf"),
						rs.getString("nome"), rs.getString("telefone"),
						rs.getString("email"), rs.getString("endereco") });
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"N�o foi poss�vel salvar os dados cadastrados.",
					"Erro de valida��o", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
