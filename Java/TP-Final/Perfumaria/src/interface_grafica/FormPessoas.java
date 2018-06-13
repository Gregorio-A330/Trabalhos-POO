package interface_grafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FormPessoas extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPessoas frame = new FormPessoas();
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
	public FormPessoas() {
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 259, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnPessoaFisica = new JButton("Pessoa F\u00EDsica - Funcionario");
		btnPessoaFisica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				FormPessoaFisica pf = new FormPessoaFisica();
				pf.setVisible(true);

			}
		});
		btnPessoaFisica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPessoaFisica.setBounds(10, 11, 235, 76);
		contentPane.add(btnPessoaFisica);

		JButton btnPessoaJuridica = new JButton("Pessoa Jur\u00EDdica - Fornecedor");
		btnPessoaJuridica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				FormPessoaJuridica pj = new FormPessoaJuridica();
				pj.setVisible(true);

			}
		});
		btnPessoaJuridica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPessoaJuridica.setBounds(10, 98, 235, 76);
		contentPane.add(btnPessoaJuridica);

	}
}
