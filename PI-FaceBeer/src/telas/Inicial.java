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
import telas.*;
import javax.swing.JPasswordField;
public class Inicial extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField passWordSenha;

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
		setBounds(100, 100, 450, 365);
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
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(116, 185, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String senhaTemp = passWordSenha.getText();
				String userTemp = textUser.getText();
				Apreciador apreciador = new Apreciador();
				ApreciadorDao dao = new ApreciadorDao();
				apreciador = dao.getApreciador(userTemp, senhaTemp);
				Produtor produtor = new Produtor();
				ProdutorDao daop = new ProdutorDao();
				produtor = daop.getProdutor(userTemp, senhaTemp);
				Administrador adm = new Administrador();
				AdministradorDao admDao = new AdministradorDao();
				adm = admDao.getAdministrador(userTemp, senhaTemp);
				if(apreciador == null) {
					if (produtor == null) {
						if(adm == null) {
							JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos");
						} else {
							System.out.println("certo adm");
							System.out.println(adm);
							Menu_Adm menuAdm = new Menu_Adm();
							menuAdm.menuAdm();
							dispose();
						}
					}
					else {
						System.out.println("certo produtor");
						System.out.println(produtor);
						Menu_Produtor menup = new Menu_Produtor(produtor);
						menup.menuProdutor(produtor);
						dispose();
					}

				}
				else {
					System.out.println("certo apreciador");
					System.out.println(apreciador);
					Menu_Apreciador menuA = new Menu_Apreciador(apreciador);
					menuA.menuApreciador(apreciador);
					dispose();
				}
			}
		});
		btnEntrar.setBackground(Color.GREEN);
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setBounds(142, 227, 109, 31);
		contentPane.add(btnEntrar);
		
		JButton btnRegister = new JButton("Cadastrar-se");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cadastro_Apreciador cadApre = new Cadastro_Apreciador();
				cadApre.cadastrarApreciador();
				dispose();
			}
		});
		btnRegister.setBounds(142, 269, 109, 23);
		contentPane.add(btnRegister);
		
		passWordSenha = new JPasswordField();
		passWordSenha.setBounds(162, 182, 86, 20);
		contentPane.add(passWordSenha);
	}
}
