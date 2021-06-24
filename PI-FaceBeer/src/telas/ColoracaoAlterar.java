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

public class ColoracaoAlterar extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	
	/**
	 * Launch the application.
	 */
	public static void alteraColoracao(Coloracao coloracao) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColoracaoAlterar frame = new ColoracaoAlterar(coloracao);
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
	public ColoracaoAlterar(Coloracao coloracao) {
		setTitle("Alterar Coloração");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 309, 163);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setText(Integer.toString(coloracao.getId()));
		txtId.setBounds(10, 69, 51, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setText(coloracao.getNome());
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
				Coloracao coloracao = new Coloracao(id, nome);
				ColoracaoDao dao = new ColoracaoDao();
				try {
					dao.alterar(coloracao);
					JOptionPane.showMessageDialog(null, "Alterado");
					ColoracaoAdm telaColoracaoAdm = new ColoracaoAdm();
					telaColoracaoAdm.telaColoracao();
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
