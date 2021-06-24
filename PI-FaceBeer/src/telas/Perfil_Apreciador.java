package telas;

import java.awt.EventQueue;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Apreciador;
import java.awt.Color;

public class Perfil_Apreciador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void perfilApreciador(Apreciador apreciador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil_Apreciador frame = new Perfil_Apreciador(apreciador);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param apreciador 
	 */
	public Perfil_Apreciador(Apreciador apreciador) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 279, 299);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String nome = apreciador.getNome();
		JLabel lblNome = new JLabel("Nome: " + nome);
		lblNome.setBounds(10, 41, 348, 14);
		contentPane.add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF: " + apreciador.getCpf());
		lblCPF.setBounds(10, 63, 220, 14);
		contentPane.add(lblCPF);
		
		JLabel lblTelefone = new JLabel("Telefone: " + apreciador.getTelefone());
		lblTelefone.setBounds(10, 86, 334, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email: " + apreciador.getEmail());
		lblEmail.setBounds(10, 106, 220, 14);
		contentPane.add(lblEmail);
		
		Date date = apreciador.getDatanasc(); 
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
        String dataStr = dateFormat.format(date);
		JLabel lblDataNasc = new JLabel("Data de Nascimento: " + dataStr);
		lblDataNasc.setBounds(10, 128, 334, 14);
		contentPane.add(lblDataNasc);
	}
}
