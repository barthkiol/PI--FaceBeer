package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import classes.Produtor;
import classes.Suporte;
import dao.SuporteDao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Produtor_NovoReqSuporte extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void telaNovoSuporte(Produtor produtor) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produtor_NovoReqSuporte frame = new Produtor_NovoReqSuporte(produtor);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {						 
						    Menu_Produtor frameNew = new Menu_Produtor(produtor);
						    frameNew.menuProdutor(produtor);
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
	public Produtor_NovoReqSuporte(Produtor produtor) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 269, 327);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textTextoSuporte = new JTextPane();
		textTextoSuporte.setBounds(10, 88, 233, 151);
		contentPane.add(textTextoSuporte);
		
		JLabel lblReqSuporte = new JLabel("Requerimento de Suporte");
		lblReqSuporte.setForeground(Color.BLACK);
		lblReqSuporte.setBackground(Color.CYAN);
		lblReqSuporte.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblReqSuporte.setBounds(20, 11, 233, 31);
		contentPane.add(lblReqSuporte);
		
		JLabel lblDescricao = new JLabel("Descorra o seu problema abaixo:");
		lblDescricao.setBounds(10, 70, 164, 14);
		contentPane.add(lblDescricao);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EnviarReq(produtor, textTextoSuporte.getText());
				dispose();
			}
		});
		btnEnviar.setBackground(Color.GREEN);
		btnEnviar.setBounds(80, 254, 89, 23);
		contentPane.add(btnEnviar);
		
	}
	
	public void EnviarReq(Produtor produtor, String texto) {
		String desc = texto;
		Suporte suporte = new Suporte();
		suporte.setTexto(desc);
		suporte.setProdutor(produtor);
		SuporteDao dao = new SuporteDao();
		try {
			dao.salvar(suporte);
			JOptionPane.showMessageDialog(null, "Seu requerimento foi enviado com succeso e será avaliado pelos Administradores!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
