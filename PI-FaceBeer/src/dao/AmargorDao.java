package dao;

import java.sql.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.Amargor;
import classes.Amargor;


public class AmargorDao {

	private Connection con = null; 
	
	public String salvar(Amargor amargor) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(amargor);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Amargor: "+e.getMessage());
		} 			
	}
	// alterar
		public String alterar(Amargor amargor) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(amargor);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Amargor: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Amargor amargor) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Amargor c = em.find(Amargor.class, amargor.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Amargor: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Amargor> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Amargor");
			return q.getResultList();				
		}
		
		public Amargor getAmargor(Integer id) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		    	  Amargor amargor = (Amargor) em.createQuery("SELECT c from Amargor c where c.id = :id").setParameter("id", id).getSingleResult();
		      

		        return amargor;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
}
