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
import java.awt.Color;

public class Cervejas_ADM extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void cervejasADM() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cervejas_ADM frame = new Cervejas_ADM();
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
	public Cervejas_ADM() {
		setTitle("Cervejas");
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
			}
		});
		btnDeletar.setBounds(378, 153, 113, 23);
		contentPane.add(btnDeletar);
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
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
