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

public class AromaAlterar extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	
	/**
	 * Launch the application.
	 */
	public static void alteraAroma(Aroma aroma) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AromaAlterar frame = new AromaAlterar(aroma);
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
	public AromaAlterar(Aroma aroma) {
		setTitle("Alterar Aroma");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 309, 163);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setText(Integer.toString(aroma.getId()));
		txtId.setBounds(10, 69, 51, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setText(aroma.getNome());
		txtNome.setBounds(72, 69, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(Color.GREEN);
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = txtNome.getText();
				int id = Integer.parseInt(txtId.getText());
				Aroma aroma = new Aroma(id, nome);
				AromaDao dao = new AromaDao();
				try {
					dao.alterar(aroma);
					JOptionPane.showMessageDialog(null, "Alterado");
					AromaAdm telaAromaAdm = new AromaAdm();
					telaAromaAdm.telaAroma();
					dispose();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnAlterar.setBounds(179, 68, 89, 23);
		contentPane.add(btnAlterar);
	}

}
