package interface_grafica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PerfumariaPrincipal extends JFrame {

	/**
	 * 
	 */

	FormPessoas p = new FormPessoas();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfumariaPrincipal frame = new PerfumariaPrincipal();
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
	public PerfumariaPrincipal() {
		setTitle("Controle de Estoque - Imperium Fragrance");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Janelas de cadastro

		JLabel lblNewLabel = new JLabel("Cadastros");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 11, 61, 14);
		contentPane.add(lblNewLabel);

		JButton btnProduto = new JButton("Produto");
		btnProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				FormProduto prod = new FormProduto();
				prod.setVisible(true);

			}
		});
		btnProduto.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btnProduto.setBounds(20, 45, 89, 23);
		contentPane.add(btnProduto);

		JButton btnFuncionrio = new JButton("Funcion\u00E1rio");
		btnFuncionrio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				FormFuncionario func = new FormFuncionario();
				func.setVisible(true);

			}
		});
		btnFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFuncionrio.setBounds(119, 45, 89, 23);
		contentPane.add(btnFuncionrio);

		JButton btnFornecedor = new JButton("Fornecedor");
		btnFornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				FormFornecedor forn = new FormFornecedor();
				forn.setVisible(true);

			}
		});
		btnFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFornecedor.setBounds(218, 45, 89, 23);
		contentPane.add(btnFornecedor);

		JLabel lblRelatrios = new JLabel("Relat\u00F3rios");
		lblRelatrios.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRelatrios.setBounds(10, 79, 72, 14);
		contentPane.add(lblRelatrios);

		JButton btnPessoas = new JButton("Pessoas");
		btnPessoas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (!p.isVisible()) {
					p.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Escolha uma opção", "Informação",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnPessoas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPessoas.setBounds(119, 109, 89, 23);
		contentPane.add(btnPessoas);

		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				FormMostraEstoque estoq = new FormMostraEstoque();
				estoq.setVisible(true);

			}
		});
		btnEstoque.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEstoque.setBounds(20, 109, 89, 23);
		contentPane.add(btnEstoque);

		JLabel lblImperiumFragrance = new JLabel("Imperium");
		lblImperiumFragrance.setFont(new Font("Dialog", Font.ITALIC, 26));
		lblImperiumFragrance.setBounds(288, 71, 116, 61);
		contentPane.add(lblImperiumFragrance);

		JLabel lblFragrance = new JLabel("Fragrance");
		lblFragrance.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblFragrance.setBounds(234, 109, 135, 61);
		contentPane.add(lblFragrance);
		setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { contentPane, btnProduto, btnFuncionrio, btnFornecedor, btnPessoas, btnEstoque }));
	}
}
