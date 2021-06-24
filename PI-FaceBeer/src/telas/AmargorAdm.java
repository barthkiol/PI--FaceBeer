package telas;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classes.*;
import dao.*;

public class AmargorAdm extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void telaAmargor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AmargorAdm frame = new AmargorAdm();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {						 
						    Menu_Adm frameNew = new Menu_Adm();
						    frameNew.menuAdm();
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
	public AmargorAdm() {
		setTitle("Amargores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 431, 282);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
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
				AmargorNovo novoAmargor = new AmargorNovo();
				novoAmargor.novoAmargorCer();
				dispose();
			}
		});
		btnNovoTipo.setBounds(319, 67, 89, 23);
		contentPane.add(btnNovoTipo);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarAmargorAlter();
				dispose();
			}
		});
		btnAlterar.setBounds(319, 139, 89, 23);
		contentPane.add(btnAlterar);
		
		
		listaAmargors();
	}
	
	private DefaultTableModel getModelo() {
		String[][] linhas= new String[][] {{"1", "Nome"}};
		String[] colunas = new String []{"ID", "Nome"};
		return new DefaultTableModel(linhas, colunas);
		}
	
	private void listaAmargors() {
		// Carregar o model na JTable
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		AmargorDao dao = new AmargorDao();
		try {
			List<Amargor>  lista  = dao.consultar();
			
			for (Amargor tipo : lista) {
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
	
	private void selecionarAmargorAlter() {
		int linha = table.getSelectedRow();
		int id = (Integer)table.getValueAt(linha, 0);
		String nome = (String)table.getValueAt(linha, 1);
		Amargor amargor = new Amargor();
		AmargorDao dao = new AmargorDao();
		amargor = dao.getAmargor(id);
		AmargorAlterar alterarAmargor = new AmargorAlterar(amargor);
		alterarAmargor.alteraAmargor(amargor);
	}
	

}
