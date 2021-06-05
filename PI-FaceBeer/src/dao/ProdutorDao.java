package dao;

import java.sql.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.Apreciador;
import classes.Produtor;


public class ProdutorDao {

	private Connection con = null; 
	
	public String salvar(Produtor produtor) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(produtor);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Produtor: "+e.getMessage());
		} 
				
	}
	// alterar
		public String alterar(Produtor produtor) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(produtor);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Produtor: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Produtor produtor) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Produtor c = em.find(Produtor.class, produtor.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Produtor: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Produtor> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Produtor");
			return q.getResultList();				
		}
		
		public Produtor getProdutor(String user, String senha) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		    	  Produtor produtor = (Produtor) em.createQuery("SELECT u from Produtor u where u.usuarioP = :user and u.senhaP = :senha").setParameter("user", user).setParameter("senha", senha).getSingleResult();
		      

		        return produtor;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
}
