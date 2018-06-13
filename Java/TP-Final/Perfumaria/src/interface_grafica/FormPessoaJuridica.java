package interface_grafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPessoaJuridica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";
	String[] colunasTabela = new String[] { "CNPJ", "Nome", "Telefone", "E-mail", "Endere�o" };
	static JTable tab;
	static DefaultTableModel modeloTabela;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPessoaJuridica frame = new FormPessoaJuridica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormPessoaJuridica() {
		setResizable(false);
		setTitle("Pessoa Jur�dica - Fornecedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/// ----------TABELA!!!!-----------///

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
			tab.setEnabled(false);
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
			painelTabela.setBounds(10, 11, 774, 515);
			painelTabela.add(new JScrollPane(tab));
			painelTabela.setLayout(new GridLayout(1, 1));
			contentPane.add(painelTabela);

		} catch (SQLException s) {
			System.err.println(s);
		} catch (Exception e) {
			System.err.println(e);
		}
		// /////////////////////////////////////////////

		// ----------------------FIM TABELA---------------------------//

		// BOT�ES
		JButton btnExportarDados = new JButton("Exportar Dados");
		btnExportarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvaArquivo();
			}
		});
		btnExportarDados.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnExportarDados.setBounds(20, 537, 112, 23);
		contentPane.add(btnExportarDados);

		JButton btnAtualizar = new JButton("Atualizar Dados");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				atualizaTabela();

			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtualizar.setBounds(153, 537, 112, 23);
		contentPane.add(btnAtualizar);

	}

	public void salvaArquivo() {
		{

			try {
				// o true significa q o arquivo ser� constante
				StringBuilder b, cabecalho;
				String local = "C:\\Users\\Camila\\Desktop\\Fornecedor.txt";

				FileWriter x = new FileWriter(local);

				// String conteudo = jTextField1.getText().toString();

				ArrayList<StringBuilder> linhas = new ArrayList<StringBuilder>();

				cabecalho = new StringBuilder();
				cabecalho.append("--------------Lista de Fornecedores--------------");
				cabecalho.append(System.getProperty("line.separator"));
				cabecalho.append("CNPJ; Nome; Telefone; E-mail; Endere�o;");
				cabecalho.append(System.getProperty("line.separator"));
				linhas.add(cabecalho);

				for (int i = 0; i < tab.getRowCount(); i++) {
					b = new StringBuilder();
					for (int j = 0; j < tab.getColumnCount(); j++) {

						b.append(tab.getValueAt(i, j)).append(";");

						if (j == 4) {
							b.append(System.getProperty("line.separator"));
						}
					}
					linhas.add(b);
				} // � pra fechar aqui!! e por isso que existe indenta��o!

				// conteudo += "\n\r"; // criando nova linha e recuo no arquivo
				// x.write(conteudo); // armazena o texto no objeto x, que aponta
				// para o arquivo
				for (StringBuilder builder : linhas) {
					x.write(builder.toString());
				}

				x.close(); // cria o arquivo
				// } //n�o � pra fechar aqui!

				JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso", "Conclu�do",
						JOptionPane.INFORMATION_MESSAGE);
			}
			// em caso de erro apreenta mensagem abaixo
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Aten��o", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public static void atualizaTabela() {

		((DefaultTableModel) tab.getModel()).setNumRows(0);// essa linha limpa a
															// tabela
		// ////////////////////////////////////////////////////
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(DATABASE_URL, "root", "root");
			stm = con.createStatement();
			rs = stm.executeQuery("select * from fornecedor");
			while (rs.next()) {
				modeloTabela.addRow(new String[] { rs.getString("cnpj"), rs.getString("nome"), rs.getString("telefone"),
						rs.getString("email"), rs.getString("endereco") });
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel salvar os dados.", "Erro de valida��o",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

}