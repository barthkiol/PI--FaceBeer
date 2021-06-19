package principal;

import java.util.List;

import classes.Cerveja;
import dao.CervejaDao;

public class Testes {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//		Inserção de um apreciador
//		Apreciador apreciador = new Apreciador();
//		apreciador.setCpf("09588672910");
//		String sDate1 = "20/06/2002";
//		SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
//		Date date1=formatter1.parse(sDate1); 
//		apreciador.setDatanasc(date1);
//		apreciador.setEmail("asdasdasd@gmail.com");
//		apreciador.setSenhaA("123456");
//		apreciador.setUsuarioA("abdefg");
//		apreciador.setNome("Gabriel Barth");
//
//		ApreciadorBo bo = new ApreciadorBo();
//		try {
//			bo.salvar(apreciador);
//			System.out.println("Inserido!");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		
		
		
		
		//inserção de produtor
//		Produtor produtor = new Produtor ();
//		produtor.setCnpj("12345678910111");
//		produtor.setEmail("iasudhasuihashd@hotmail.com");
//		produtor.setNome("sdoiashdashd");
//		produtor.setSenhaP("12345");
//		produtor.setUsuarioP("909090");
//		produtor.setTelefone("419999999999");
//		ProdutorBo bo = new ProdutorBo();
//		try {
//			bo.salvar(produtor);
//			System.out.println("inserido");
//		} catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		//inserção de cerveja
//		Cerveja cerveja = new Cerveja();
//		Amargor amargor = new Amargor();
//		amargor.setId(1);
//		cerveja.setAmargor(amargor);
//		Coloracao cor = new Coloracao();
//		cor.setId(1);
//		cerveja.setCor(cor);
//		Estilo estilo = new Estilo();
//		estilo.setId(1);
//		cerveja.setEstilo(estilo);
//		Pais pais = new Pais();
//		pais.setId(1);
//		cerveja.setPais(pais);
//		produtor.setId(1);
//		cerveja.setProdutor(produtor);
//		Aroma aroma1 = new Aroma();
//		aroma1.setId(1);
//		Aroma aroma2 = new Aroma();
//		aroma2.setId(2);
//		cerveja.adicionaAroma(aroma1);
//		cerveja.adicionaAroma(aroma2);
//		cerveja.setTemperatura((float) 8.5);
//		cerveja.setDescricao("teste teste teste teste teste teste");
//		cerveja.setVolume(500);
//		cerveja.setNome("cerveja de teste");
//		CervejaDao dao = new CervejaDao();
//		try {
//			dao.salvar(cerveja);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		Apreciador apreciador = new Apreciador();
//		apreciador.setId(2);
//		Cerveja cerveja = new Cerveja();
//		cerveja.setId(6);
//		ArrayList<Cerveja> cervejas = new ArrayList();
//		cervejas.add(cerveja);
//		apreciador.setCervejas(cerveja);
//		ApreciadorDao dao = new ApreciadorDao();
//		try {
//			dao.salvar(apreciador);
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		CervejaDao dao = new CervejaDao();
//		Produtor produtor = new Produtor();
//		produtor.setId(1);
//		
//		for (Cerveja c : dao.consultarCervProdutor(produtor)) {
//			System.out.println(c);
//		}
		
//		ApreciadorBo bo = new ApreciadorBo();
//		Apreciador apre = new Apreciador();
//		String sDate1 = "20/06/2002";
//		SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
//		Date date1=formatter1.parse(sDate1);
//		Date datahoje =

//		Cerveja cerveja = new Cerveja();
//		cerveja.setId(10);
//		Apreciador apreciador = new Apreciador();
//		apreciador.setId(3);
//		apreciador.adicionaCerveja(cerveja);
//		cerveja.adicionaApreciador(apreciador);
//		ApreciadorDao dao = new ApreciadorDao();
//		CervejaDao daoC = new CervejaDao();
//		try {
//			daoC.salvar(cerveja);
//			dao.salvar(apreciador);
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
//		Cerveja cerveja = new Cerveja();
//		cerveja.setId(10);
//		Apreciador apreciador = new Apreciador();
//		apreciador.setId(2);
//		CervejaDao dao = new CervejaDao();
//		try {
//			dao.favoritar(cerveja, apreciador);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		try {
//            Connection con = null;
//            String url = "jdbc:sqlserver://localhost;databaseName=bancoPI;";
//            
//            String username = "Teste";
//   		 	String password = "barth2006";
//   		 	
//            con = DriverManager.getConnection(url,username,password);
//            //String cSql = "select * from TB_APRECIADOR_CERVEJA where apreciador_id = (?) and cerveja_id = (?)";
//
//            
////            pstnt.setInt(1, apreciador.getId());
////            pstnt.setInt(2, cerveja.getId());
//
//            String cSql = "delete from TB_APRECIADOR_CERVEJA where apreciador_id = ? and cerveja_id = ?";
//            PreparedStatement pstnt = con.prepareStatement(cSql);
//            pstnt = con.prepareStatement(cSql);
//            pstnt.setInt(1, 2);
//            pstnt.setInt(2, 8);
//            pstnt.execute();
//            JOptionPane.showMessageDialog(null, "Cerveja desfavoritada");
//            //System.out.println("favoritada");
//           
//        	            
//
//            pstnt.close();
//            con.close();
//
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        	//System.out.println(ex);
//        }
		
//		CervejaDao dao = new CervejaDao();
//		String nome = "";
//		int estilo = 0;
//		int pais = 0;
//		int amargor = 0;
//		int apreciador = 4;
//		try {
//			List<Cerveja> lista = dao.pesquisaCatalogo(nome, 4);
//			for (Cerveja c : lista) {
//				System.out.println(c);
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
	  
//		Estilo estilo = new Estilo(1, "Pilsen");
//		EstiloDao dao = new EstiloDao();
//		try {
//			dao.alterar(estilo);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		CervejaDao dao = new CervejaDao();
//		try {
//			List<Cerveja> lista = dao.consultarFavoritos(4);
//			for (Cerveja c : lista) {
//				System.out.println(c);
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
				
	} 

	
}
	


