package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import bo.ApreciadorBo;
import classes.Apreciador;

public class Cadastro_Apreciador extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textEmail;
	private JTextField textDataNasc;
	private JTextField textTelefone;
	private JTextField textUser;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void cadastrarApreciador() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Apreciador frame = new Cadastro_Apreciador();
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
	public Cadastro_Apreciador() {
		setTitle("Novo Apreciador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 424, 351);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(38, 32, 46, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(38, 49, 160, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(218, 32, 46, 14);
		contentPane.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(216, 49, 160, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(38, 125, 46, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(38, 138, 338, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data de nascimento: ");
		lblDataNasc.setBounds(218, 80, 135, 14);
		contentPane.add(lblDataNasc);
		

		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			textDataNasc = new JFormattedTextField(mask);
			textDataNasc.setToolTipText("Dia/m\u00EAs/Ano");
			textDataNasc.setBounds(218, 94, 160, 20);
			contentPane.add(textDataNasc);
			textDataNasc.setColumns(10);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(38, 80, 61, 14);
		contentPane.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(38, 94, 160, 20);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblUser = new JLabel("Usu\u00E1rio: ");
		lblUser.setBounds(38, 169, 61, 14);
		contentPane.add(lblUser);
		
		textUser = new JTextField();
		textUser.setBounds(38, 182, 160, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(218, 169, 46, 14);
		contentPane.add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setBounds(218, 182, 160, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					cadastrar();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnCadastrar.setBackground(Color.GREEN);
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBounds(149, 224, 108, 31);
		contentPane.add(btnCadastrar);
		
		JButton btnProdutor = new JButton("Novo Produtor");
		btnProdutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cadastro_Produtor cadProd = new Cadastro_Produtor();
				cadProd.telaCadastroProdutor();
				dispose();
			}
		});
		btnProdutor.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnProdutor.setBounds(154, 281, 98, 20);
		contentPane.add(btnProdutor);
		
	}
	
	public void cadastrar() throws Exception  {
		Apreciador apreciadorTemp = new Apreciador();
		ApreciadorBo bo = new ApreciadorBo();
		apreciadorTemp.setNome(textNome.getText());
		apreciadorTemp.setCpf(textCPF.getText());
		apreciadorTemp.setEmail(textEmail.getText());
		apreciadorTemp.setTelefone(textTelefone.getText());
		apreciadorTemp.setUsuarioA(textUser.getText());
		apreciadorTemp.setSenhaA(textSenha.getText());
		String nascimento = textDataNasc.getText();
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascInput = sdf.parse(nascimento);
		apreciadorTemp.setDatanasc(dataNascInput);
		try {
			bo.salvar(apreciadorTemp);
			JOptionPane.showMessageDialog(null, "Bem vindo!");
			dispose();
			Inicial frameNew = new Inicial();
			frameNew.main(null);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	public void formatarData() {
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			mask.install((JFormattedTextField) textDataNasc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
}
