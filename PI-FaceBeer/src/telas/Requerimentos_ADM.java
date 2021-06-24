package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class Requerimentos_ADM extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void telaSuporte() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Requerimentos_ADM frame = new Requerimentos_ADM();
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
	public Requerimentos_ADM() {
		setTitle("Requerimentos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 431, 282);
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
				"ID", "Descricao", "Produtor"
				}
				));
		table.setBounds(35, 50, 257, 181);
		//contentPane.add(table);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(35, 50, 257, 181);
		contentPane.add(scroll);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(Color.RED);
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				excluir();
			}
		});
		btnExcluir.setBounds(316, 130, 89, 23);
		contentPane.add(btnExcluir);
		
		
		listaSuportes();
	}
	
	private DefaultTableModel getModelo() {
		String[][] linhas= new String[][] {{"1", "Nome", "1"}};
		String[] colunas = new String []{"ID", "Nome", "Produtor"};
		return new DefaultTableModel(linhas, colunas);
		}
	
	private void listaSuportes() {
		// Carregar o model na JTable
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		SuporteDao dao = new SuporteDao();
		try {
			List<Suporte>  lista  = dao.consultar();
			
			for (Suporte tipo : lista) {
				modelo.addRow(
						new Object[] {
								tipo.getId(),
								tipo.getTexto(),
								tipo.getProdutor().nomeProdutor()
						}
					);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  "Erro consultando: "+e.getMessage());
		}
	}
	
	private void excluir() {
		int linha = table.getSelectedRow();
		int id = (Integer)table.getValueAt(linha, 0);
		Suporte suporte = new Suporte();
		SuporteDao dao = new SuporteDao();
		suporte = dao.getSuporte(id);
		try {
			dao.deletar(suporte);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	

}
