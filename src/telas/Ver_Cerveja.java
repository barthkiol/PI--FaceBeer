package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bo.*;
import dao.*;
import classes.*;
import telas.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Ver_Cerveja extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void visualizarCerveja(Cerveja cerveja, Apreciador apreciador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ver_Cerveja frame = new Ver_Cerveja(cerveja, apreciador);
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
	public Ver_Cerveja(Cerveja cerveja, Apreciador apreciador) {
		setTitle(cerveja.getNome());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 365, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: " + cerveja.getNome());
		lblNome.setBounds(10, 23, 260, 14);
		contentPane.add(lblNome);
		
		JLabel lblProdutor = new JLabel("Produtor: " + cerveja.getProdutor().nomeProdutor());
		lblProdutor.setBounds(10, 48, 311, 14);
		contentPane.add(lblProdutor);
		
		JLabel lblPais = new JLabel("Pais: " + cerveja.getPais());
		lblPais.setBounds(10, 73, 156, 14);
		contentPane.add(lblPais);
		
		JLabel lblEstilo = new JLabel("Estilo: " + cerveja.getEstilo());
		lblEstilo.setBounds(203, 73, 156, 14);
		contentPane.add(lblEstilo);
		
		JLabel lblAmargor = new JLabel("Amargor: " + cerveja.getAmargor());
		lblAmargor.setBounds(10, 98, 156, 14);
		contentPane.add(lblAmargor);
		
		JLabel lblAromas = new JLabel("Aromas: " + cerveja.getAromas());
		lblAromas.setBounds(10, 123, 156, 14);
		contentPane.add(lblAromas);
		
		JLabel lblTemperatura = new JLabel("Temperatura ideal: " + cerveja.getTemperatura() + " °C");
		lblTemperatura.setBounds(10, 148, 156, 14);
		contentPane.add(lblTemperatura);
		
		JLabel lblVolume = new JLabel("Volume: " + cerveja.getVolume() + "ml");
		lblVolume.setBounds(203, 148, 156, 14);
		contentPane.add(lblVolume);
		
		JLabel lblTeorAlc = new JLabel("Teor Alco\u00F3lico: " + cerveja.getTeorAlc() + "%");
		lblTeorAlc.setBounds(203, 123, 156, 14);
		contentPane.add(lblTeorAlc);
		
		JButton btnAvaliar = new JButton("Avaliar");
		btnAvaliar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(cerveja);
				System.out.println(apreciador);
				Avaliar av = new Avaliar(cerveja, apreciador);
				av.telaAvaliar(cerveja, apreciador);
			}
		});
		btnAvaliar.setBounds(232, 297, 89, 23);
		contentPane.add(btnAvaliar);
		
		JLabel lblNota = new JLabel();
		AvaliacaoDao avDao = new AvaliacaoDao();
		if (avDao.temNota(cerveja) == true) {
			lblNota.setText("Nota: Sem avaliação :C");
		} else {
			double f = avDao.mediaNota(cerveja);
			lblNota.setText("Nota:" + f);
		}
		
		lblNota.setBounds(10, 173, 149, 14);
		contentPane.add(lblNota);
		
		JTextPane textDescricao = new JTextPane();
		textDescricao.setEditable(false);
		textDescricao.setBounds(10, 198, 260, 80);
		contentPane.add(textDescricao);
		textDescricao.setText(cerveja.getDescricao());
		
		JButton btnVerAvali = new JButton("Ver Avalia\u00E7\u00F5es");
		btnVerAvali.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Avaliacoes_Cerveja avCerveja = new Avaliacoes_Cerveja(cerveja);
				avCerveja.telaAvalicoesCerveja(cerveja);
			}
		});
		btnVerAvali.setBounds(10, 297, 120, 23);
		contentPane.add(btnVerAvali);
		
	}
}
