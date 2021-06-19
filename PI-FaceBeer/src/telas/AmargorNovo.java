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

public class AmargorNovo extends JFrame {

	private JPanel contentPane;
	private JTextField textAmargor;
	
	/**
	 * Launch the application.
	 */
	public static void novoAmargorCer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AmargorNovo frame = new AmargorNovo();
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
	public AmargorNovo() {
		setTitle("Novo Amargor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 296, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textAmargor = new JTextField();
		textAmargor.setBounds(33, 67, 115, 20);
		contentPane.add(textAmargor);
		textAmargor.setColumns(10);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBackground(Color.GREEN);
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomeAmargor = textAmargor.getText();
				Amargor amargor = new Amargor();
				amargor.setNome(nomeAmargor);
				AmargorDao dao = new AmargorDao();
				try {
					dao.salvar(amargor);
					JOptionPane.showMessageDialog(null, "Amargor Criado");
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
