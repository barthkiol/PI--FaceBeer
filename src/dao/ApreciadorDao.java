package dao;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.Apreciador;


public class ApreciadorDao {

	private Connection con = null; 
	
	public String salvar(Apreciador apreciador) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(apreciador);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Apreciador: "+e.getMessage());
		} 
					
	}
	// alterar
		public String alterar(Apreciador apreciador) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(apreciador);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Apreciador: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Apreciador apreciador) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Apreciador c = em.find(Apreciador.class, apreciador.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Apreciador: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Apreciador> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Apreciador");
			return q.getResultList();				
		}
		
		 public Apreciador getApreciador(String user, String senha) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		        Apreciador apreciador = (Apreciador) em.createQuery("SELECT u from Apreciador u where u.usuarioA = :user and u.senhaA = :senha").setParameter("user", user).setParameter("senha", senha).getSingleResult();
		      

		        return apreciador;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
}
