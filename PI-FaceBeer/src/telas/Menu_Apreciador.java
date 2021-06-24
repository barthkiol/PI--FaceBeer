package telas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classes.*;
import dao.*;
import bo.*;
import telas.*;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Menu_Apreciador extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textPesquisa;

	/**
	 * Launch the application.
	 */
	public static void menuApreciador(Apreciador apreciador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Apreciador frame = new Menu_Apreciador(apreciador);
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
	public Menu_Apreciador(Apreciador apreciador) {
		setTitle("Ol\u00E1 " + apreciador.getNome());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cbAmargor = new JComboBox();
		cbAmargor.setBounds(10, 68, 73, 20);
		contentPane.add(cbAmargor);
		Amargor amargorNulo = new Amargor(0," ");
		cbAmargor.addItem(amargorNulo);
		AmargorDao amargorDao = new AmargorDao();
		try {
			List<Amargor> listAmargor = amargorDao.consultar();
			for (Amargor amargor : listAmargor) {
				cbAmargor.addItem(amargor);
			}
		} catch(Exception eAmargor) {
			JOptionPane.showMessageDialog(null, eAmargor);
		}
		
		JComboBox cbEstilo = new JComboBox();
		cbEstilo.setBounds(93, 68, 83, 20);
		contentPane.add(cbEstilo);
		Estilo estiloNulo = new Estilo(0," ");
		cbEstilo.addItem(estiloNulo);
		EstiloDao estiloDao = new EstiloDao();
		try {
			List<Estilo> listEstilo = estiloDao.consultar();
			for (Estilo estilo : listEstilo) {
				cbEstilo.addItem(estilo);
			}
		} catch(Exception eEstilo) {
			JOptionPane.showMessageDialog(null, eEstilo);
		}
		
		JComboBox cbPais = new JComboBox();
		cbPais.setBounds(186, 68, 85, 20);
		contentPane.add(cbPais);
		Pais paisNulo = new Pais(0," ");
		cbPais.addItem(paisNulo);
		PaisDao paisDao = new PaisDao();
		try {
			List<Pais> listPais = paisDao.consultar();
			for (Pais pais : listPais) {
				cbPais.addItem(pais);
			}
		} catch(Exception ePais) {
			JOptionPane.showMessageDialog(null, ePais);
		}
		
		JLabel lblAmargor = new JLabel("Amargor");
		lblAmargor.setBounds(10, 55, 73, 14);
		contentPane.add(lblAmargor);
		
		JLabel lblEstilo = new JLabel("Estilo");
		lblEstilo.setBounds(93, 55, 46, 14);
		contentPane.add(lblEstilo);
		
		JLabel lblPais = new JLabel("Pa\u00EDs");
		lblPais.setBounds(186, 55, 46, 14);
		contentPane.add(lblPais);
		
		
		JButton btnPerfil = new JButton("Ver perfil");
		btnPerfil.setBackground(Color.WHITE);
		btnPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Perfil_Apreciador perfilAp = new Perfil_Apreciador(apreciador);
				perfilAp.perfilApreciador(apreciador);
			}
		});
		btnPerfil.setPreferredSize(new Dimension(20, 23));
		btnPerfil.setMinimumSize(new Dimension(20, 23));
		btnPerfil.setMaximumSize(new Dimension(20, 23));
		btnPerfil.setBounds(10, 249, 91, 23);
		contentPane.add(btnPerfil);
		
		JButton btnMeuCat = new JButton("Meu cat\u00E1logo");
		btnMeuCat.setBackground(Color.CYAN);
		btnMeuCat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tela_Catalogo_Apreciador telaCatAp = new Tela_Catalogo_Apreciador(apreciador);
				telaCatAp.catlogApreciador(apreciador);
				dispose();
			}
		});
		btnMeuCat.setBounds(125, 249, 117, 23);
		contentPane.add(btnMeuCat);
		
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
		scroll.setBounds(10, 97, 261, 141);
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
				pesquisaCervejaPerso((Estilo) cbEstilo.getSelectedItem(), (Pais) cbPais.getSelectedItem(), (Amargor) cbAmargor.getSelectedItem());
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
		btnVerCerveja.setBounds(317, 65, 107, 23);
		contentPane.add(btnVerCerveja);
		
		JButton btnFavoritar = new JButton("Favoritar");
		btnFavoritar.setBackground(Color.PINK);
		btnFavoritar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				favoritarCerveja(apreciador);
			}
		});
		btnFavoritar.setBounds(317, 117, 107, 23);
		contentPane.add(btnFavoritar);
		
		JButton Sair = new JButton("Sair");
		Sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inicial frameNew = new Inicial();
			    frameNew.main(null);
			    dispose();
			}
		});
		Sair.setBounds(335, 249, 89, 23);
		contentPane.add(Sair);
		
		pesquisaCerveja();
		
	}
	
	private DefaultTableModel getModelo() {
		String[][] linhas= new String[][] {{"Cerveja", "Leve", "Pilsen", "Brasil"}};
		String[] colunas = new String []{"Nome", "Amargor", "Estilo", "Pais"};
		return new DefaultTableModel(linhas, colunas);
		}
	
	private void pesquisaCerveja() {
		// Carregar o model na JTable
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		CervejaDao dao = new CervejaDao();
		try {
			List<Cerveja>  lista  = dao.consultar();
			
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
	
	private void pesquisaCervejaPerso(Estilo comboEstilo, Pais comboPais, Amargor comboAmargor) {
		// Carregar o model na JTable
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		CervejaDao dao = new CervejaDao();
		String pesquisa = textPesquisa.getText();
		int idEstilo = comboEstilo.getId();
		int idPais = comboPais.getId();
		int idAmargor = comboAmargor.getId();
		try {
			List<Cerveja>  lista  = dao.pesquisaPerso(pesquisa, idEstilo, idPais, idAmargor);
			
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
	
	private void favoritarCerveja(Apreciador apreciador) {
		int linha = table.getSelectedRow();
		String nome = (String)table.getValueAt(linha, 0);
		Amargor amargor = (Amargor) table.getValueAt(linha, 1);
		Estilo estilo = (Estilo) table.getValueAt(linha, 2);
		Pais pais = (Pais) table.getValueAt(linha, 3);
		Cerveja cerveja = new Cerveja();
		CervejaDao dao = new CervejaDao();
		cerveja = dao.getCerveja(nome);
		try {
			dao.favoritar(cerveja, apreciador);
		} catch (Exception eFav) {
			JOptionPane.showMessageDialog(null, eFav);
		}
		
	}
}
