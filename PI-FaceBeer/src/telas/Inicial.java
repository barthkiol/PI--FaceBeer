package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classes.*;
import dao.*;
import bo.*;

public class Inicial extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial frame = new Inicial();
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
	public Inicial() {
		setTitle("FaceBeer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFaceBeer = new JLabel("FaceBeer");
		lblFaceBeer.setForeground(Color.ORANGE);
		lblFaceBeer.setFont(new Font("Impact", Font.PLAIN, 40));
		lblFaceBeer.setBounds(131, 33, 217, 96);
		contentPane.add(lblFaceBeer);
		
		textUser = new JTextField();
		textUser.setBounds(162, 140, 86, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblUser = new JLabel("Usu\u00E1rio");
		lblUser.setBounds(116, 143, 46, 14);
		contentPane.add(lblUser);
		
		textSenha = new JTextField();
		textSenha.setBounds(162, 182, 86, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(116, 185, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String senhaTemp = textSenha.getText();
				String userTemp = textUser.getText();
				Apreciador apreciador = new Apreciador();
				ApreciadorDao dao = new ApreciadorDao();
				apreciador = dao.getApreciador(userTemp, senhaTemp);
				Produtor produtor = new Produtor();
				ProdutorDao daop = new ProdutorDao();
				produtor = daop.getProdutor(userTemp, senhaTemp);
				if(apreciador == null) {
					if (produtor == null) {
						System.out.println("erro");
					}
					else {
						System.out.println("certo produtor");
					}

				}
				else {
					System.out.println("certo apreciador");
				}
			}
		});
		btnEntrar.setBackground(Color.GREEN);
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setBounds(162, 227, 89, 23);
		contentPane.add(btnEntrar);
	}
}