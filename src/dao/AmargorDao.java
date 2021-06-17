package dao;

import java.sql.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		finally {
			con.close();
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
}
