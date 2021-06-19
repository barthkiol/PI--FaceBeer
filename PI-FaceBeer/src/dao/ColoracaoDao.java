package dao;

import java.sql.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.Coloracao;



public class ColoracaoDao {

	private Connection con = null; 
	
	public String salvar(Coloracao coloracao) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(coloracao);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Coloracao: "+e.getMessage());
		} 
		finally {
			con.close();
		}			
	}
	// alterar
		public String alterar(Coloracao coloracao) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(coloracao);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Coloracao: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Coloracao coloracao) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Coloracao c = em.find(Coloracao.class, coloracao.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Coloracao: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Coloracao> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Coloracao");
			return q.getResultList();				
		}
		
		public Coloracao getColoracao(Integer id) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		    	  Coloracao coloracao = (Coloracao) em.createQuery("SELECT c from Coloracao c where c.id = :id").setParameter("id", id).getSingleResult();
		      

		        return coloracao;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
}
