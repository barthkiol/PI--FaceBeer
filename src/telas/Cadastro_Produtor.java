package telas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bo.ProdutorBo;
import classes.Produtor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cadastro_Produtor extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCnpj;
	private JTextField textEmail;
	private JTextField textTelefone;
	private JTextField textUser;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void telaCadastroProdutor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Produtor frame = new Cadastro_Produtor();
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
	public Cadastro_Produtor() {
		setTitle("Novo Produtor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 393, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(23, 32, 46, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(23, 45, 154, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCNPJ = new JLabel("CNPJ: ");
		lblCNPJ.setBounds(195, 32, 46, 14);
		contentPane.add(lblCNPJ);
		
		textCnpj = new JTextField();
		textCnpj.setBounds(195, 44, 154, 20);
		contentPane.add(textCnpj);
		textCnpj.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mai: ");
		lblEmail.setBounds(23, 81, 46, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(23, 94, 154, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds(195, 81, 69, 14);
		contentPane.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(195, 94, 154, 20);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblUser = new JLabel("Usu\u00E1rio: ");
		lblUser.setBounds(23, 125, 62, 14);
		contentPane.add(lblUser);
		
		textUser = new JTextField();
		textUser.setBounds(23, 138, 154, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(195, 125, 46, 14);
		contentPane.add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setBounds(195, 138, 154, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar-se");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarProdutor();
				JOptionPane.showMessageDialog(null, "Bem vindo!");
				dispose();
			}
		});
		btnCadastrar.setBackground(Color.GREEN);
		btnCadastrar.setBounds(127, 188, 123, 39);
		contentPane.add(btnCadastrar);
	}

	public void cadastrarProdutor() {
		Produtor prodTemp = new Produtor();
		prodTemp.setNome(textNome.getText());
		prodTemp.setCnpj(textCnpj.getText());
		prodTemp.setEmail(textEmail.getText());
		prodTemp.setTelefone(textTelefone.getText());
		prodTemp.setUsuarioP(textUser.getText());
		prodTemp.setSenhaP(textSenha.getText());
		ProdutorBo bo = new ProdutorBo();
		try{
			bo.salvar(prodTemp);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		
	}
}
