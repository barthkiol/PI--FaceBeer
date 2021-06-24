package telas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import classes.Amargor;
import classes.Aroma;
import classes.Cerveja;
import classes.Coloracao;
import classes.Estilo;
import classes.Pais;
import classes.Produtor;
import dao.AmargorDao;
import dao.AromaDao;
import dao.CervejaDao;
import dao.ColoracaoDao;
import dao.EstiloDao;
import dao.PaisDao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Nova_Cerveja extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textVolume;
	private JTextField textTeorAlc;
	private JTextField textTempIde;

	/**
	 * Launch the application.
	 */
	public static void telaCadastroCerveja(Produtor produtor) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nova_Cerveja frame = new Nova_Cerveja(produtor);
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
	public Nova_Cerveja(Produtor produtor)  {
		setTitle("Nova Cerveja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 319, 424);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 25, 46, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(10, 37, 192, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblPais = new JLabel("Pa\u00EDs: ");
		lblPais.setBounds(10, 68, 46, 14);
		contentPane.add(lblPais);
		
		JComboBox cbPais = new JComboBox();
		cbPais.setBounds(10, 80, 115, 22);
		contentPane.add(cbPais);
		PaisDao paisD = new PaisDao();
		try {
			for (Pais p : paisD.consultar()) {
				
				cbPais.addItem(p);
			}
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		JLabel lblEstilo = new JLabel("Estilo: ");
		lblEstilo.setBounds(135, 68, 46, 14);
		contentPane.add(lblEstilo);
		
		
		JComboBox cbEstilo = new JComboBox();
		cbEstilo.setBounds(135, 80, 115, 22);
		contentPane.add(cbEstilo);
		EstiloDao estiloD = new EstiloDao();
		try {
			for (Estilo e : estiloD.consultar()) {
				
				cbEstilo.addItem(e);
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel lblAmargor = new JLabel("Amargor: ");
		lblAmargor.setBounds(10, 112, 78, 14);
		contentPane.add(lblAmargor);
		
		JComboBox cbAmargor = new JComboBox();
		cbAmargor.setBounds(10, 125, 115, 22);
		contentPane.add(cbAmargor);
		AmargorDao amargorD = new AmargorDao();
		try {
			for (Amargor amrg : amargorD.consultar()) {
				
				cbAmargor.addItem(amrg);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblCor = new JLabel("Colora\u00E7\u00E3o: ");
		lblCor.setBounds(135, 113, 67, 14);
		contentPane.add(lblCor);
		
		JComboBox cbCor = new JComboBox();
		cbCor.setBounds(135, 125, 115, 22);
		contentPane.add(cbCor);
		ColoracaoDao corD = new ColoracaoDao();
		try {
			for (Coloracao c : corD.consultar()) {
				
				cbCor.addItem(c);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblAroma = new JLabel("Aromas: ");
		lblAroma.setBounds(10, 158, 67, 14);
		contentPane.add(lblAroma);
		
		JComboBox cbAromas = new JComboBox();
		cbAromas.setBounds(10, 172, 115, 22);
		contentPane.add(cbAromas);
		AromaDao aromaD = new AromaDao();
		try {
			for (Aroma aro : aromaD.consultar()) {
				
				cbAromas.addItem(aro);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblVolume = new JLabel("Volume (ml):");
		lblVolume.setBounds(135, 158, 83, 14);
		contentPane.add(lblVolume);
		
		textVolume = new JTextField();
		textVolume.setBounds(135, 173, 115, 20);
		contentPane.add(textVolume);
		textVolume.setColumns(10);
		
		JLabel lblTeorAlc = new JLabel("Teor Alco\u00F3lico (%): ");
		lblTeorAlc.setBounds(10, 205, 115, 14);
		contentPane.add(lblTeorAlc);
		
		textTeorAlc = new JTextField();
		textTeorAlc.setBounds(10, 219, 115, 20);
		contentPane.add(textTeorAlc);
		textTeorAlc.setColumns(10);
		
		JLabel lblTempIdeal = new JLabel("Temperatura Ideal (\u00B0C): ");
		lblTempIdeal.setBounds(135, 205, 138, 14);
		contentPane.add(lblTempIdeal);
		
		textTempIde = new JTextField();
		textTempIde.setBounds(132, 219, 118, 20);
		contentPane.add(textTempIde);
		textTempIde.setColumns(10);
		
		JLabel lblDesc = new JLabel("Descri\u00E7\u00E3o: ");
		lblDesc.setBounds(10, 250, 78, 14);
		contentPane.add(lblDesc);
		
		JTextPane textDesc = new JTextPane();
		textDesc.setBounds(10, 263, 240, 72);
		contentPane.add(textDesc);
		String descTemp = textDesc.getText();
		
		JButton btnNovaCerveja = new JButton("Nova Cerveja");
		btnNovaCerveja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pais paisTemp = (Pais) cbPais.getSelectedItem();
				Estilo estiloTemp = (Estilo) cbEstilo.getSelectedItem();
				Amargor amargorTemp = (Amargor) cbAmargor.getSelectedItem();
				Coloracao corTemp = (Coloracao) cbCor.getSelectedItem();
				Aroma aromaTemp = (Aroma) cbAromas.getSelectedItem();
				String descTemp = textDesc.getText();
				cadastrarCerveja(paisTemp, estiloTemp, amargorTemp, corTemp, aromaTemp, descTemp, produtor);
				JOptionPane.showMessageDialog(null, "Cerveja criada com sucesso!");
				Menu_Produtor telaMenu = new Menu_Produtor(produtor);
				telaMenu.menuProdutor(produtor);
				dispose();
			}
		});
		btnNovaCerveja.setBackground(Color.GREEN);
		btnNovaCerveja.setBounds(175, 342, 118, 32);
		contentPane.add(btnNovaCerveja);
		
		
	}
	
	public void cadastrarCerveja(Pais pais, Estilo estilo, Amargor amargor, Coloracao cor, Aroma aro, String desc, Produtor produtor) {
		Cerveja cervejaTemp =  new Cerveja();
		cervejaTemp.setNome(textNome.getText());
		cervejaTemp.setPais(pais);
		cervejaTemp.setEstilo(estilo);
		cervejaTemp.setAmargor(amargor);
		cervejaTemp.setCor(cor);
		cervejaTemp.adicionaAroma(aro);
		float teorTemp = Float.parseFloat(textTeorAlc.getText());
		cervejaTemp.setTeorAlc(teorTemp);
		int volTemp = Integer.parseInt(textVolume.getText());
		cervejaTemp.setVolume(volTemp);
		float temperaturaTemp = Float.parseFloat(textTempIde.getText());
		cervejaTemp.setTemperatura(temperaturaTemp);
		cervejaTemp.setDescricao(desc);
		cervejaTemp.setProdutor(produtor);
		CervejaDao dao = new CervejaDao();
		try {
			dao.salvar(cervejaTemp);
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}
}
