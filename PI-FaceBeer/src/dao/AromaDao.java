package dao;

import java.sql.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.Aroma;
import classes.Cerveja;



public class AromaDao {

	private Connection con = null; 
	
	public String salvar(Aroma aroma) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(aroma);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Aroma: "+e.getMessage());
		} 			
	}
	// alterar
		public String alterar(Aroma aroma) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(aroma);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Aroma: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Aroma aroma) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Aroma c = em.find(Aroma.class, aroma.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Aroma: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Aroma> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Aroma");
			return q.getResultList();				
		}
		
		public Aroma getAroma(Integer id) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		    	  Aroma aroma = (Aroma) em.createQuery("SELECT c from Aroma c where c.id = :id").setParameter("id", id).getSingleResult();
		      

		        return aroma;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
		
		public String deletarAromasporCerveja(Cerveja cerveja) throws Exception {
			try {
				Connection con = null;
				String url = "jdbc:sqlserver://localhost;databaseName=bancoPI;";
          
				String username = "Teste";
				String password = "barth2006";
 		 	
				con = DriverManager.getConnection(url,username,password);	
				
				String cSql = "DELETE FROM TB_CERVEJA_AROMA WHERE cerveja_id = ?";
				PreparedStatement pstmt = con.prepareStatement(cSql);
				pstmt.setInt(1, cerveja.getId());
				pstmt.execute();
				pstmt.close();
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro excluindo  Avaliacao: " + e.getMessage());
			}		
		}
}
