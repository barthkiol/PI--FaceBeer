package dao;

import java.sql.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import classes.Avaliacao;


public class AvaliacaoDao {

	private Connection con = null; 
	
	public String salvar(Avaliacao avaliacao) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(avaliacao);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Avaliacao: "+e.getMessage());
		} 
		finally {
			con.close();
		}			
	}
	// alterar
		public String alterar(Avaliacao avaliacao) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(avaliacao);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Avaliacao: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Avaliacao avaliacao) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Avaliacao c = em.find(Avaliacao.class, avaliacao.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Avaliacao: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Avaliacao> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Avaliacao");
			return q.getResultList();				
		}
}
