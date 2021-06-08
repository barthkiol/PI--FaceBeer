package dao;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.*;


public class CervejaDao {

	private Connection con = null; 
	
	public String salvar(Cerveja cerveja) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(cerveja);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Cerveja: "+e.getMessage());
		} 
				
	}
	// alterar
		public String alterar(Cerveja cerveja) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(cerveja);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Cerveja: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Cerveja cerveja) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Cerveja c = em.find(Cerveja.class, cerveja.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Cerveja: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Cerveja> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Cerveja");
			return q.getResultList();				
		}
		public List<Cerveja> consultarPerso(String consulta) throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Cerveja inner join Pais"
					+ "on pais.id = cerveja.pais_id inner join Amargor"
					+ "on Amargor.id = Cerveja.amargor_id"
					+ "where pais.nome like :pesquisa% or amargor.nome like :pesquisa%");
			q.setParameter("pesquisa", consulta);
			return q.getResultList();				
		}
		
		public Cerveja getCerveja(String nome) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		        Cerveja cerveja = (Cerveja) em.createQuery("SELECT c from Cerveja c where c.nome = :nome").setParameter("nome", nome).getSingleResult();
		      

		        return cerveja;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
		
		public List<Cerveja> consultarCervProdutor(int id) throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Cerveja where produtor_id = :id");
			q.setParameter("id", id);
			return q.getResultList();				
		}
}

