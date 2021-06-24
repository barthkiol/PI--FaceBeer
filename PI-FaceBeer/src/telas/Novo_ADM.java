package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Administrador;
import dao.AdministradorDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Novo_ADM extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textUser;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void telaNovoAdm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Novo_ADM frame = new Novo_ADM();
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
	 */
	public Novo_ADM() {
		setTitle("Novo ADM");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 226, 334);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(25, 52, 46, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(25, 66, 150, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblUser = new JLabel("Usu\u00E1rio");
		lblUser.setBounds(25, 113, 46, 14);
		contentPane.add(lblUser);
		
		textUser = new JTextField();
		textUser.setBounds(25, 127, 150, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(25, 175, 46, 14);
		contentPane.add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setBounds(25, 188, 150, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JButton btnNovo = new JButton("Criar");
		btnNovo.setBackground(Color.GREEN);
		btnNovo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarAdm();
				dispose();
			}
		});
		btnNovo.setBounds(57, 240, 89, 23);
		contentPane.add(btnNovo);
	}
	
	public void cadastrarAdm() {
		Administrador adm = new Administrador();
		adm.setNomeAdm(textNome.getText());
		adm.setUsuarioAdm(textUser.getText());
		adm.setSenhaAdm(textSenha.getText());
		AdministradorDao dao = new AdministradorDao();
		try {
			dao.salvar(adm);
			JOptionPane.showMessageDialog(null, "Administrador criado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
