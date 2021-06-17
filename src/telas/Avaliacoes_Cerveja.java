package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classes.*;
import bo.*;
import dao.*;

public class Avaliacoes_Cerveja extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void telaAvalicoesCerveja(Cerveja cerveja) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Avaliacoes_Cerveja frame = new Avaliacoes_Cerveja(cerveja);
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
	public Avaliacoes_Cerveja(Cerveja cerveja) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 496, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				"Nome", "Comentario", "Nota"
				}
				));
		table.setBounds(21, 46, 261, 141);
		//contentPane.add(table);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 62, 261, 141);
		contentPane.add(scroll, BorderLayout.WEST);
		pesquisaCerveja(cerveja);
	}

	private DefaultTableModel getModelo() {
		String[][] linhas= new String[][] {{"Gabriel Barth", "Comentario", "3.5"}};
		String[] colunas = new String []{"Nome", "Comentario", "Nota"};
		return new DefaultTableModel(linhas, colunas);
		}
	
	private void pesquisaCerveja(Cerveja cerveja) {
		// Carregar o model na JTable
		DefaultTableModel modelo = (DefaultTableModel)this.table.getModel();
		modelo.setRowCount(0);
		table.setModel(modelo);
		
		AvaliacaoDao dao = new AvaliacaoDao();
		try {
			List<Avaliacao>  lista  = dao.consultarCerveja(cerveja);
			
			for (Avaliacao avaliacao : lista) {
				modelo.addRow(
						new Object[] {
								avaliacao.getApreciador().getNome(),
								avaliacao.getDescricao(),
								avaliacao.getNota()
						}
					);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  "Erro consultando: "+e.getMessage());
		}
	}
}
