package dao;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.Administrador;


public class AdministradorDao {

	private Connection con = null; 
	
	public String salvar(Administrador administrador) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(administrador);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Administrador: "+e.getMessage());
		} 
					
	}
	// alterar
		public String alterar(Administrador administrador) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(administrador);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Administrador: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Administrador administrador) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Administrador c = em.find(Administrador.class, administrador.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Administrador: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Administrador> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Administrador");
			return q.getResultList();				
		}
		
		 public Administrador getAdministrador(String user, String senha) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		        Administrador administrador = (Administrador) em.createQuery("SELECT u from Administrador u where u.usuarioAdm = :user and u.senhaAdm = :senha").setParameter("user", user).setParameter("senha", senha).getSingleResult();
		      

		        return administrador;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
}
