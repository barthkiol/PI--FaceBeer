package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Menu_Adm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void menuAdm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Adm frame = new Menu_Adm();
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
	public Menu_Adm() {
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 270, 296);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCervejas = new JButton("Cervejas");
		btnCervejas.setBackground(Color.WHITE);
		btnCervejas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cervejas_ADM telaCerAdm = new Cervejas_ADM();
				telaCerAdm.cervejasADM();
			}
		});
		btnCervejas.setBounds(15, 36, 98, 23);
		contentPane.add(btnCervejas);
		
		JButton btnEstilos = new JButton("Estilos");
		btnEstilos.setBackground(Color.WHITE);
		btnEstilos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EstiloAdm tEstiloAdm = new EstiloAdm();
				tEstiloAdm.telaEstilo();
			}
		});
		btnEstilos.setBounds(144, 36, 98, 23);
		contentPane.add(btnEstilos);
		
		JButton btnPaises = new JButton("Pa\u00EDses");
		btnPaises.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPaises.setBackground(Color.WHITE);
		btnPaises.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PaisAdm tPaisAdm = new PaisAdm();
				tPaisAdm.telaPais();
			}
		});
		btnPaises.setBounds(144, 87, 98, 23);
		contentPane.add(btnPaises);
		
		JButton btnAromas = new JButton("Aromas");
		btnAromas.setBackground(Color.WHITE);
		btnAromas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AromaAdm tAromaAdm = new AromaAdm();
				tAromaAdm.telaAroma();
			}
		});
		btnAromas.setBounds(144, 132, 98, 23);
		contentPane.add(btnAromas);
		
		JButton btnAmargores = new JButton("Amargores");
		btnAmargores.setBackground(Color.WHITE);
		btnAmargores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AmargorAdm tAmargorAdm = new AmargorAdm();
				tAmargorAdm.telaAmargor();
				dispose();
			}
		});
		btnAmargores.setBounds(15, 87, 98, 23);
		contentPane.add(btnAmargores);
		
		JButton btnCores = new JButton("Cores");
		btnCores.setBackground(Color.WHITE);
		btnCores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ColoracaoAdm tCorAdm = new ColoracaoAdm();
				tCorAdm.telaColoracao();
			}
		});
		btnCores.setBounds(15, 132, 98, 23);
		contentPane.add(btnCores);
		
		JButton btnNewAdm = new JButton("<html>Novo<br>Admin</html>");
		btnNewAdm.setBackground(Color.GREEN);
		btnNewAdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Novo_ADM newAdm = new Novo_ADM();
				newAdm.telaNovoAdm();
			}
		});
		btnNewAdm.setBounds(86, 175, 78, 37);
		contentPane.add(btnNewAdm);
		
		JButton btnRequerimentos = new JButton("Requerimentos");
		btnRequerimentos.setBackground(Color.CYAN);
		btnRequerimentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Requerimentos_ADM reqAdm = new Requerimentos_ADM();
				reqAdm.telaSuporte();
			}
		});
		btnRequerimentos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRequerimentos.setBounds(70, 223, 115, 23);
		contentPane.add(btnRequerimentos);
	}
}
