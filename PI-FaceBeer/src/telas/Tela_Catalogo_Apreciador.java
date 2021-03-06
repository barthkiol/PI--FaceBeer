package telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classes.Amargor;
import classes.Apreciador;
import classes.Cerveja;
import classes.Estilo;
import classes.Pais;
import dao.CervejaDao;
import java.awt.Color;

public class Tela_Catalogo_Apreciador extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textPesquisa;

	/**
	 * Launch the application.
	 */
	public static void catlogApreciador(Apreciador apreciador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Catalogo_Apreciador frame = new Tela_Catalogo_Apreciador(apreciador);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {						 
						    Menu_Apreciador frameNew = new Menu_Apreciador(apreciador);
						    frameNew.menuApreciador(apreciador);
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
	
	public Tela_Catalogo_Apreciador(Apreciador apreciador) {
		setTitle("Ol\u00E1 " + apreciador.getNome());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 332);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				"Nome", "Amargor", "Estilo", "Pais"
				}
				));
		table.setBounds(21, 46, 261, 141);
		//contentPane.add(table);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 62, 261, 141);
		contentPane.add(scroll);
		
		textPesquisa = new JTextField();
		textPesquisa.setBounds(10, 31, 156, 20);
		contentPane.add(textPesquisa);
		textPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(Color.GREEN);
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//pesquisaCervejaPerso();
			}
		});
		btnPesquisar.setBounds(176, 30, 95, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnVerCerveja = new JButton("Ver Cerveja");
		btnVerCerveja.setBackground(Color.WHITE);
		btnVerCerveja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarVerCerveja(apreciador);
			}
		});
		btnVerCerveja.setBounds(10, 234, 107, 23);
		contentPane.add(btnVerCerveja);
		
		JButton btnDesFavoritar = new JButton("Desfavoritar");
		btnDesFavoritar.setBackground(Color.RED);
		btnDesFavoritar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				desFavoritarCerveja(apreciador);
			}
		});
		btnDesFavoritar.setBounds(164, 234, 107, 23);
		contentPane.add(btnDesFavoritar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu_Apreciador frameNew = new Menu_Apreciador(apreciador);
			    frameNew.menuApreciador(apreciador);
			    dispose();
			}
		});
		btnVoltar.setBounds(93, 268, 89, 23);
		contentPane.add(btnVoltar);
		pesquisaCerveja(apreciador.getId());
		
	}
	
	private DefaultTableModel getModelo() {
		String[][] linhas= new String[][] {{"Cerveja", "Leve", "Pilsen", "Brasil"}};
		String[] colunas = new String []{"Nome", "Amargor", "Estilo", "Pais"};
		return new DefaultTableModel(linhas, colunas);
		}
	
	private void pesquisaCerveja(Integer idApreciador) {
		// Carregar o model na JTable
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		CervejaDao dao = new CervejaDao();
		try {
			List<Cerveja>  lista  = dao.consultarFavoritos(idApreciador);
			
			for (Cerveja cerveja : lista) {
				modelo.addRow(
						new Object[] {
								cerveja.getNome(),
								cerveja.getAmargor(),
								cerveja.getEstilo(),
								cerveja.getPais()
						}
					);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  "Erro consultando: "+e.getMessage());
		}
	}
	
	private void pesquisaCervejaPerso() {
		// Carregar o model na JTable
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		CervejaDao dao = new CervejaDao();
		String pesquisa = textPesquisa.getText();
		try {
			List<Cerveja>  lista  = dao.pesquisaPerso(pesquisa, 0, 0, 0);
			
			for (Cerveja cerveja : lista) {
				modelo.addRow(
						new Object[] {
								cerveja.getNome(),
								cerveja.getAmargor(),
								cerveja.getEstilo(),
								cerveja.getPais()
						}
					);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  "Erro consultando: "+e.getMessage());
		}
	}
	
	private void selecionarVerCerveja(Apreciador apreciador) {
		int linha = table.getSelectedRow();
		String nome = (String)table.getValueAt(linha, 0);
		Amargor amargor = (Amargor) table.getValueAt(linha, 1);
		Estilo estilo = (Estilo) table.getValueAt(linha, 2);
		Pais pais = (Pais) table.getValueAt(linha, 3);
		Cerveja cerveja = new Cerveja();
		CervejaDao dao = new CervejaDao();
		cerveja = dao.getCerveja(nome);
		Ver_Cerveja verCerveja = new Ver_Cerveja(cerveja, apreciador);
		verCerveja.visualizarCerveja(cerveja, apreciador);
	}
	
	
	
	private void desFavoritarCerveja(Apreciador apreciador) {
		int linha = table.getSelectedRow();
		String nome = (String)table.getValueAt(linha, 0);
		Amargor amargor = (Amargor) table.getValueAt(linha, 1);
		Estilo estilo = (Estilo) table.getValueAt(linha, 2);
		Pais pais = (Pais) table.getValueAt(linha, 3);
		Cerveja cerveja = new Cerveja();
		CervejaDao dao = new CervejaDao();
		cerveja = dao.getCerveja(nome);
		try {
			dao.desfavoritar(cerveja, apreciador);
		} catch (Exception eDesFav) {
			JOptionPane.showMessageDialog(null, eDesFav);
		}
		
	}

}
