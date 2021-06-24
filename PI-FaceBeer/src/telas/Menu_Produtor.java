package telas;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Produtor;
import dao.SuporteDao;
import java.awt.Color;

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
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {						 
						    Inicial frameNew = new Inicial();
						    frameNew.main(null);
						}						 
						  });
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
		setBounds(100, 100, 256, 291);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMinhasCerv = new JButton("Minhas Cervejas");
		btnMinhasCerv.setBackground(Color.WHITE);
		btnMinhasCerv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cervejas_Produtor telaProdCer = new Cervejas_Produtor(produtor);
				telaProdCer.cervejasProdutor(produtor);
				dispose();
			}
		});
		btnMinhasCerv.setBounds(50, 33, 133, 23);
		contentPane.add(btnMinhasCerv);
		
		JButton btnNovaCerveja = new JButton("Nova Cerveja");
		btnNovaCerveja.setBackground(Color.GREEN);
		btnNovaCerveja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Nova_Cerveja novaCerTela = new Nova_Cerveja(produtor);
				novaCerTela.telaCadastroCerveja(produtor);
				dispose();
			}
		});
		btnNovaCerveja.setBounds(50, 79, 133, 23);
		contentPane.add(btnNovaCerveja);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBackground(Color.RED);
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inicial inicio = new Inicial();
				inicio.main(null);
				dispose();
			}
		});
		btnSair.setBounds(50, 205, 133, 23);
		contentPane.add(btnSair);
		
		JButton btnSuporte = new JButton("<html>Abrir Req.<br>Suporte</html>");
		btnSuporte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SuporteDao dao = new SuporteDao();
				boolean reqSup = false;
				try {
					reqSup = dao.buscaReq(produtor);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (reqSup == true) {
					Produtor_NovoReqSuporte telaReq = new Produtor_NovoReqSuporte(produtor);
					telaReq.telaNovoSuporte(produtor);
				} else {
					JOptionPane.showMessageDialog(null, "Você ja possui um requerimento em aberto");
				}
			}
		});
		btnSuporte.setBounds(50, 124, 133, 32);
		contentPane.add(btnSuporte);
	}
}
