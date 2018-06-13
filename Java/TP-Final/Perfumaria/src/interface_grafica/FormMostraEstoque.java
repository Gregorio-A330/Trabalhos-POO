package interface_grafica;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;

public class FormMostraEstoque extends JFrame {

	// Usar o fileChooser() para selecionar onde o usuário salva

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";
	String[] colunasTabela = new String[] { "Cod", "Nome", "Marca", "Preço de Compra", "Preço de Venda", "Fornecedor" };
	private JPanel contentPane;
	static JTable tab;
	static DefaultTableModel modeloTabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMostraEstoque frame = new FormMostraEstoque();
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
	public FormMostraEstoque() {
		setResizable(false);
		setTitle("Estoque");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 692, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
			tab.setEnabled(false);
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
			painelTabela.setBounds(10, 11, 664, 394);
			painelTabela.add(new JScrollPane(tab));
			painelTabela.setLayout(new GridLayout(1, 1));
			contentPane.add(painelTabela);

		} catch (SQLException s) {
			System.err.println(s);
		} catch (Exception e) {
			System.err.println(e);
		}

		// /----------BOTÕES!!!------///
		JButton btnExportarDados = new JButton("Exportar Dados");
		btnExportarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvaArquivo();
			}
		});
		btnExportarDados.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnExportarDados.setBounds(20, 416, 112, 23);
		contentPane.add(btnExportarDados);

		JButton btnAtualizar = new JButton("Atualizar Dados");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				atualizaTabela();

			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtualizar.setBounds(153, 416, 112, 23);
		contentPane.add(btnAtualizar);
	}

	public void salvaArquivo() {
		{

			try {
				// o true significa q o arquivo será constante
				StringBuilder b, cabecalho;
				String local = "C:\\Users\\GabrielCouto\\Desktop\\Estoque.txt";

				FileWriter x = new FileWriter(local);

				// String conteudo = jTextField1.getText().toString();

				ArrayList<StringBuilder> linhas = new ArrayList<StringBuilder>();

				cabecalho = new StringBuilder();
				cabecalho.append("-------------- Estoque --------------");
				cabecalho.append(System.getProperty("line.separator"));
				cabecalho.append("Cod; Nome; Marca; Preço de Compra; Preço de Venda; Fornecedor;");
				cabecalho.append(System.getProperty("line.separator"));
				linhas.add(cabecalho);

				for (int i = 0; i < (FormMostraEstoque.tab).getRowCount(); i++) {
					b = new StringBuilder();
					for (int j = 0; j < (FormMostraEstoque.tab).getColumnCount(); j++) {

						b.append((FormMostraEstoque.tab).getValueAt(i, j)).append(";");

						if (j == 5) {
							b.append(System.getProperty("line.separator"));
						}
					}
					linhas.add(b);
				} // é pra fechar aqui!! e por isso que existe indentação!

				// conteudo += "\n\r"; // criando nova linha e recuo no arquivo
				// x.write(conteudo); // armazena o texto no objeto x, que aponta
				// para o arquivo
				for (StringBuilder builder : linhas) {
					x.write(builder.toString());
				}

				x.close(); // cria o arquivo
				// } //não é pra fechar aqui!

				JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso", "Concluído",
						JOptionPane.INFORMATION_MESSAGE);
			}
			// em caso de erro apreenta mensagem abaixo
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
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
