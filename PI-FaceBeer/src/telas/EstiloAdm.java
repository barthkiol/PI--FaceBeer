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

public class EstiloAdm extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void telaEstilo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstiloAdm frame = new EstiloAdm();
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
	public EstiloAdm() {
		setTitle("Estilos");
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
				EstiloNovo novoEstilo = new EstiloNovo();
				novoEstilo.novoEstiloCer();
			}
		});
		btnNovoTipo.setBounds(319, 67, 89, 23);
		contentPane.add(btnNovoTipo);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarEstiloAlter();
			}
		});
		btnAlterar.setBounds(319, 139, 89, 23);
		contentPane.add(btnAlterar);
		
		
		listaEstilos();
	}
	
	private DefaultTableModel getModelo() {
		String[][] linhas= new String[][] {{"1", "Nome"}};
		String[] colunas = new String []{"ID", "Nome"};
		return new DefaultTableModel(linhas, colunas);
		}
	
	private void listaEstilos() {
		// Carregar o model na JTable
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		EstiloDao dao = new EstiloDao();
		try {
			List<Estilo>  lista  = dao.consultar();
			
			for (Estilo tipo : lista) {
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
	
	private void selecionarEstiloAlter() {
		int linha = table.getSelectedRow();
		int id = (Integer)table.getValueAt(linha, 0);
		String nome = (String)table.getValueAt(linha, 1);
		Estilo estilo = new Estilo();
		EstiloDao dao = new EstiloDao();
		estilo = dao.getEstilo(id);
		EstiloAlterar alterarEstilo = new EstiloAlterar(estilo);
		alterarEstilo.alteraEstilo(estilo);
	}
	

}
