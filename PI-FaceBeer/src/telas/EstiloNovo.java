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

public class EstiloNovo extends JFrame {

	private JPanel contentPane;
	private JTextField textEstilo;
	
	/**
	 * Launch the application.
	 */
	public static void novoEstiloCer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstiloNovo frame = new EstiloNovo();
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
	public EstiloNovo() {
		setTitle("Novo Estilo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 296, 152);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textEstilo = new JTextField();
		textEstilo.setBounds(33, 67, 115, 20);
		contentPane.add(textEstilo);
		textEstilo.setColumns(10);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBackground(Color.GREEN);
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomeEstilo = textEstilo.getText();
				Estilo estilo = new Estilo();
				estilo.setNome(nomeEstilo);
				EstiloDao dao = new EstiloDao();
				try {
					dao.salvar(estilo);
					JOptionPane.showMessageDialog(null, "Estilo Criado");
					EstiloAdm telaEstiloAdm = new EstiloAdm();
					telaEstiloAdm.telaEstilo();
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
