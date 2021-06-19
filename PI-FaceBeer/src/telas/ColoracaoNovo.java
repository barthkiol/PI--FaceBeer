package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classes.*;
import dao.*;

public class ColoracaoNovo extends JFrame {

	private JPanel contentPane;
	private JTextField textColoracao;
	
	/**
	 * Launch the application.
	 */
	public static void novoColoracaoCer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColoracaoNovo frame = new ColoracaoNovo();
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
	public ColoracaoNovo() {
		setTitle("Nova Coloração");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 296, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textColoracao = new JTextField();
		textColoracao.setBounds(33, 67, 115, 20);
		contentPane.add(textColoracao);
		textColoracao.setColumns(10);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBackground(Color.GREEN);
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomeColoracao = textColoracao.getText();
				Coloracao coloracao = new Coloracao();
				coloracao.setNome(nomeColoracao);
				ColoracaoDao dao = new ColoracaoDao();
				try {
					dao.salvar(coloracao);
					JOptionPane.showMessageDialog(null, "Coloção Criada");
					dispose();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnCriar.setBounds(170, 66, 89, 23);
		contentPane.add(btnCriar);
		
		
	}
	

}
