package telas;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Produtor;

public class Menu_Produtor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void menuProdutor(Produtor produtor) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Produtor frame = new Menu_Produtor(produtor);
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
	public Menu_Produtor(Produtor produtor) {
		setTitle("Ol\u00E1 " + produtor.getNome());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 254, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMinhasCerv = new JButton("Minhas Cervejas");
		btnMinhasCerv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cervejas_Produtor telaProdCer = new Cervejas_Produtor(produtor);
				telaProdCer.cervejasProdutor(produtor);
			}
		});
		btnMinhasCerv.setBounds(52, 66, 133, 23);
		contentPane.add(btnMinhasCerv);
		
		JButton btnNovaCerveja = new JButton("Nova Cerveja");
		btnNovaCerveja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Nova_Cerveja novaCerTela = new Nova_Cerveja(produtor);
				novaCerTela.telaCadastroCerveja(produtor);
			}
		});
		btnNovaCerveja.setBounds(52, 123, 133, 23);
		contentPane.add(btnNovaCerveja);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inicial inicio = new Inicial();
				inicio.main(null);
				dispose();
			}
		});
		btnSair.setBounds(52, 179, 133, 23);
		contentPane.add(btnSair);
	}
}
