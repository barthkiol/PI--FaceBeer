package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.Suporte;
import classes.Produtor;
import classes.Suporte;


public class SuporteDao {

	private Connection con = null; 
	
	public String salvar(Suporte suporte) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(suporte);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Suporte: "+e.getMessage());
		} 
					
	}
	// alterar
		public String alterar(Suporte suporte) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(suporte);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Suporte: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Suporte suporte) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Suporte c = em.find(Suporte.class, suporte.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Suporte: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Suporte> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Suporte");
			return q.getResultList();				
		}
		
		public Suporte getSuporte(Integer id) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		    	  Suporte suporte = (Suporte) em.createQuery("SELECT c from Suporte c where c.id = :id").setParameter("id", id).getSingleResult();
		      

		        return suporte;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
		
		public boolean buscaReq(Produtor produtor) throws SQLException {
			Connection con = null;
            String url = "jdbc:sqlserver://localhost;databaseName=bancoPI;";
            
            String username = "Teste";
   		 	String password = "barth2006";
   		 	
            con = DriverManager.getConnection(url,username,password);
            String cSql = "select * from SUPORTE where produtor_id = (?)";

            PreparedStatement pstnt = con.prepareStatement(cSql);
            pstnt.setInt(1, produtor.getId());

            ResultSet rs = pstnt.executeQuery();
            int numLinhas = 0;
            while (rs.next()) {
                numLinhas++;
            }
            if (numLinhas == 0) {
            	return true;
            } else {
            	return false;
            }
           
		}
}
