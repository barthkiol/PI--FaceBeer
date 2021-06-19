package dao;

import java.sql.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.Aroma;



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
		finally {
			con.close();
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
}
