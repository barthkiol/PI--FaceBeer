package dao;

import java.sql.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.Pais;



public class PaisDao {

	private Connection con = null; 
	
	public String salvar(Pais pais) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(pais);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Pais: "+e.getMessage());
		} 
		finally {
			con.close();
		}			
	}
	// alterar
		public String alterar(Pais pais) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(pais);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Pais: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Pais pais) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Pais c = em.find(Pais.class, pais.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Pais: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Pais> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Pais");
			return q.getResultList();				
		}
		
		public Pais getPais(Integer id) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		    	  Pais pais = (Pais) em.createQuery("SELECT c from Pais c where c.id = :id").setParameter("id", id).getSingleResult();
		      

		        return pais;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
}
