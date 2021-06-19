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

public class AromaAdm extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void telaAroma() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AromaAdm frame = new AromaAdm();
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
	public AromaAdm() {
		setTitle("Aromas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 431, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				"ID", "Nome"
				}
				));
		table.setBounds(35, 50, 257, 181);
		//contentPane.add(table);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(35, 50, 257, 181);
		contentPane.add(scroll);
		
		JButton btnNovoTipo = new JButton("Novo");
		btnNovoTipo.setBackground(Color.GREEN);
		btnNovoTipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AromaNovo novoAroma = new AromaNovo();
				novoAroma.novoAromaCer();
			}
		});
		btnNovoTipo.setBounds(319, 67, 89, 23);
		contentPane.add(btnNovoTipo);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarAromaAlter();
			}
		});
		btnAlterar.setBounds(319, 139, 89, 23);
		contentPane.add(btnAlterar);
		
		
		listaAromas();
	}
	
	private DefaultTableModel getModelo() {
		String[][] linhas= new String[][] {{"1", "Nome"}};
		String[] colunas = new String []{"ID", "Nome"};
		return new DefaultTableModel(linhas, colunas);
		}
	
	private void listaAromas() {
		// Carregar o model na JTable
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		AromaDao dao = new AromaDao();
		try {
			List<Aroma>  lista  = dao.consultar();
			
			for (Aroma tipo : lista) {
				modelo.addRow(
						new Object[] {
								tipo.getId(),
								tipo.getNome()								
						}
					);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  "Erro consultando: "+e.getMessage());
		}
	}
	
	private void selecionarAromaAlter() {
		int linha = table.getSelectedRow();
		int id = (Integer)table.getValueAt(linha, 0);
		String nome = (String)table.getValueAt(linha, 1);
		Aroma aroma = new Aroma();
		AromaDao dao = new AromaDao();
		aroma = dao.getAroma(id);
		AromaAlterar alterarAroma = new AromaAlterar(aroma);
		alterarAroma.alteraAroma(aroma);
	}
	

}
