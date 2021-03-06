package dao;

import java.sql.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.Estilo;



public class EstiloDao {

	private Connection con = null; 
	
	public String salvar(Estilo estilo) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(estilo);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Estilo: "+e.getMessage());
		} 
					
	}
	// alterar
		public String alterar(Estilo estilo) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(estilo);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Estilo: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Estilo estilo) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Estilo c = em.find(Estilo.class, estilo.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Estilo: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Estilo> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Estilo");
			return q.getResultList();				
		}
		
		public Estilo getEstilo(Integer id) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		    	  Estilo estilo = (Estilo) em.createQuery("SELECT c from Estilo c where c.id = :id").setParameter("id", id).getSingleResult();
		      

		        return estilo;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
}
