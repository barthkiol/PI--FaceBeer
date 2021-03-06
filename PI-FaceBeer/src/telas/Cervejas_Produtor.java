package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classes.Amargor;
import classes.Apreciador;
import classes.Cerveja;
import classes.Estilo;
import classes.Pais;
import classes.Produtor;
import dao.CervejaDao;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class Cervejas_Produtor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void cervejasProdutor(Produtor produtor) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cervejas_Produtor frame = new Cervejas_Produtor(produtor);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {						 
						    Menu_Produtor frameNew = new Menu_Produtor(produtor);
						    frameNew.menuProdutor(produtor);
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
	public Cervejas_Produtor(Produtor produtor) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 317);
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
		table.setBounds(23, 88, 333, 220);
		//contentPane.add(table);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 33, 333, 220);
		contentPane.add(scroll);
		
		JButton btnVerCerveja = new JButton("Ver Cerveja");
		btnVerCerveja.setBackground(Color.WHITE);
		btnVerCerveja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarCerveja();
			}
		});
		btnVerCerveja.setBounds(378, 56, 112, 23);
		contentPane.add(btnVerCerveja);
		
		JButton btnDeletar = new JButton("Excluir");
		btnDeletar.setBackground(Color.RED);
		btnDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				excluirCerveja();
				pesquisaCerveja(produtor);
			}
		});
		btnDeletar.setBounds(378, 153, 113, 23);
		contentPane.add(btnDeletar);
		pesquisaCerveja(produtor);
	}
	
	
	private DefaultTableModel getModelo() {
		String[][] linhas= new String[][] {{"Cerveja", "Leve", "Pilsen", "Brasil"}};
		String[] colunas = new String []{"Nome", "Amargor", "Estilo", "Pais"};
		return new DefaultTableModel(linhas, colunas);
		}
	
	private void pesquisaCerveja(Produtor produtor) {
		// Carregar o model na JTable
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		CervejaDao dao = new CervejaDao();
		try {
			List<Cerveja>  lista  = dao.consultarCervProdutor(produtor);
			
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
	
	private void selecionarCerveja() {
		int linha = table.getSelectedRow();
		String nome = (String)table.getValueAt(linha, 0);
		Cerveja cerveja = new Cerveja();
		CervejaDao dao = new CervejaDao();
		cerveja = dao.getCerveja(nome);
		Ver_Cerveja_Produtor verCerveja = new Ver_Cerveja_Produtor(cerveja);
		verCerveja.visualizarCerveja(cerveja);
	}
	
	private void excluirCerveja() {
		int linha = table.getSelectedRow();
		String nome = (String)table.getValueAt(linha, 0);
		Cerveja cerveja = new Cerveja();
		CervejaDao dao = new CervejaDao();
		cerveja = dao.getCerveja(nome);
		try {
			dao.deletar(cerveja);
			JOptionPane.showMessageDialog(null, "Cerveja excluida!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
