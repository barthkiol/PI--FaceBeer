package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import classes.Avaliacao;
import classes.Cerveja;


public class AvaliacaoDao {

	private Connection con = null; 
	
	public String salvar(Avaliacao avaliacao) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(avaliacao);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Avaliacao: "+e.getMessage());
		} 			
	}
	// alterar
		public String alterar(Avaliacao avaliacao) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(avaliacao);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Avaliacao: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Avaliacao avaliacao) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Avaliacao c = em.find(Avaliacao.class, avaliacao.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Avaliacao: " + e.getMessage());
			}		
		}
		
		public String deletarAvaporCerveja(Cerveja cerveja) throws Exception {
			try {
				Connection con = null;
				String url = "jdbc:sqlserver://localhost;databaseName=bancoPI;";
          
				String username = "Teste";
				String password = "barth2006";
 		 	
				con = DriverManager.getConnection(url,username,password);	
				
				String cSql = "DELETE FROM AVALIACAO WHERE cerveja_id = ?";
				PreparedStatement pstmt = con.prepareStatement(cSql);
				pstmt.setInt(1, cerveja.getId());
				pstmt.execute();
				pstmt.close();		
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro excluindo  Avaliacao: " + e.getMessage());
			}		
		}
		
		// consultar
		public List<Avaliacao> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Avaliacao");
			return q.getResultList();				
		}
		public double mediaNota(Cerveja cerveja) {
			EntityManager em = Conexao.getEntityManager();
			CervejaDao dao = new CervejaDao();
			Query q = em.createQuery("SELECT avg(nota) from Avaliacao where cerveja_id = :cerveja");
			q.setParameter("cerveja", cerveja.getId());
			double f = (double) q.getSingleResult();
			return f;	
		}
		
		public List<Avaliacao> consultarCerveja(Cerveja cerveja) throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Avaliacao where cerveja_id = :cerveja");
			q.setParameter("cerveja", cerveja.getId());
			return q.getResultList();				
		}
		
		public boolean temNota(Cerveja cerveja) {
			List <Avaliacao> list;
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Avaliacao where cerveja_id = :cerveja");
			q.setParameter("cerveja", cerveja.getId());
			list = q.getResultList();
			if (list.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
}
