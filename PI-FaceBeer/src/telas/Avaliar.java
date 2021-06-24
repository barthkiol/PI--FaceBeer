package telas;

import java.awt.EventQueue;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import dao.*;
import classes.*;
import bo.*;

public class Avaliar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void telaAvaliar(Cerveja cerveja, Apreciador apreciador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Avaliar frame = new Avaliar(cerveja, apreciador);
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
	public Avaliar(Cerveja cerveja, Apreciador apreciador) {
		setTitle("Avaliar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 325);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeCer = new JLabel("Cerveja: " + cerveja.getNome());
		lblNomeCer.setBounds(10, 31, 267, 14);
		contentPane.add(lblNomeCer);
		
		JTextPane textDescricao = new JTextPane();
		textDescricao.setBounds(10, 125, 264, 105);
		contentPane.add(textDescricao);
		
		
		JLabel lblComment = new JLabel("Coment\u00E1rio:");
		lblComment.setBounds(10, 107, 80, 14);
		contentPane.add(lblComment);
		
		JRadioButton rdbtnNota1 = new JRadioButton("1");
		rdbtnNota1.setBackground(Color.ORANGE);
		rdbtnNota1.setBounds(87, 105, 40, 18);
		contentPane.add(rdbtnNota1);
		
		JRadioButton rdbtnNota2 = new JRadioButton("2");
		rdbtnNota2.setBackground(Color.ORANGE);
		rdbtnNota2.setBounds(129, 105, 40, 18);
		contentPane.add(rdbtnNota2);
		
		JRadioButton rdbtnNota3 = new JRadioButton("3");
		rdbtnNota3.setBackground(Color.ORANGE);
		rdbtnNota3.setBounds(171, 105, 40, 18);
		contentPane.add(rdbtnNota3);
		
		JRadioButton rdbtnNota4 = new JRadioButton("4");
		rdbtnNota4.setBackground(Color.ORANGE);
		rdbtnNota4.setBounds(213, 105, 40, 18);
		contentPane.add(rdbtnNota4);
		
		JRadioButton rdbtnNota5 = new JRadioButton("5");
		rdbtnNota5.setBackground(Color.ORANGE);
		rdbtnNota5.setBounds(255, 105, 40, 18);
		contentPane.add(rdbtnNota5);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnNota1);
		G.add(rdbtnNota2);
		G.add(rdbtnNota3);
		G.add(rdbtnNota4);
		G.add(rdbtnNota5);
		
		JButton btnAvaliar = new JButton("Avaliar");
		btnAvaliar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setDescricao(textDescricao.getText());
				avaliacao.setNota(getSelectedButtonText(G));
				avaliacao.setApreciador(apreciador);
				avaliacao.setCerveja(cerveja);
				AvaliacaoDao dao = new AvaliacaoDao();
				try {
					dao.salvar(avaliacao);
					dispose();
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
				}
			}
		});
		btnAvaliar.setBackground(Color.GREEN);
		btnAvaliar.setBounds(100, 252, 89, 23);
		contentPane.add(btnAvaliar);
		
	}
	
	public float getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
            	String s = button.getText();
            	float nota = Float.parseFloat(s);
                return nota;
            }
        }

        return 0;
    }
	
}
