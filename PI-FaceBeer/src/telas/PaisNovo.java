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

public class PaisNovo extends JFrame {

	private JPanel contentPane;
	private JTextField textPais;
	
	/**
	 * Launch the application.
	 */
	public static void novoPaisCer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaisNovo frame = new PaisNovo();
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
	public PaisNovo() {
		setTitle("Novo País");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 296, 152);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPais = new JTextField();
		textPais.setBounds(33, 67, 115, 20);
		contentPane.add(textPais);
		textPais.setColumns(10);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBackground(Color.GREEN);
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomePais = textPais.getText();
				Pais pais = new Pais();
				pais.setNome(nomePais);
				PaisDao dao = new PaisDao();
				try {
					dao.salvar(pais);
					JOptionPane.showMessageDialog(null, "Pais Criado");
					PaisAdm telaPaisAdm = new PaisAdm();
					telaPaisAdm.telaPais();
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
