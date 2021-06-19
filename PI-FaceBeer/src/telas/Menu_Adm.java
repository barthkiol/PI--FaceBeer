package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Menu_Adm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void menuAdm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Adm frame = new Menu_Adm();
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
	public Menu_Adm() {
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 263, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCervejas = new JButton("Cervejas");
		btnCervejas.setBounds(24, 36, 89, 23);
		contentPane.add(btnCervejas);
		
		JButton btnProdutores = new JButton("Produtores");
		btnProdutores.setBounds(24, 87, 89, 23);
		contentPane.add(btnProdutores);
		
		JButton btnApreciadores = new JButton("Apreciadores");
		btnApreciadores.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnApreciadores.setBounds(18, 132, 95, 23);
		contentPane.add(btnApreciadores);
		
		JButton btnEstilos = new JButton("Estilos");
		btnEstilos.setBounds(144, 36, 89, 23);
		contentPane.add(btnEstilos);
		
		JButton btnPaises = new JButton("Pa\u00EDses");
		btnPaises.setBounds(144, 87, 89, 23);
		contentPane.add(btnPaises);
		
		JButton btnAromas = new JButton("Aromas");
		btnAromas.setBounds(144, 132, 89, 23);
		contentPane.add(btnAromas);
		
		JButton btnAmargores = new JButton("Amargores");
		btnAmargores.setBounds(144, 179, 89, 23);
		contentPane.add(btnAmargores);
		
		JButton btnCores = new JButton("Cores");
		btnCores.setBounds(24, 179, 89, 23);
		contentPane.add(btnCores);
		
		JButton btnNewAdm = new JButton("<html>Novo<br>Admin</html>");
		btnNewAdm.setBounds(81, 223, 78, 37);
		contentPane.add(btnNewAdm);
	}
}
