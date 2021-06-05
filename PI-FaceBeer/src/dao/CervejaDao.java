package dao;

import java.sql.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import classes.Cerveja;


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
}
