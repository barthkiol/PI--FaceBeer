package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import classes.Apreciador;
import classes.Cerveja;
import classes.Produtor;


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
		
		public List<Cerveja> pesquisaPerso(String nome, Integer idtipo, Integer idpais, Integer idamargor) throws Exception{        
	        EntityManager em = Conexao.getEntityManager();
	        String cSql = "select g from Cerveja g";
	        String cWhere = "";
	        Query q = null;
	        if (nome.isBlank()) {
	        }
	        else {
	            cWhere = "  nome = :nome";
	        }        
	        if (idtipo != 0) {
	            if (cWhere.isBlank()) {
	                cWhere = cWhere + " estilo_id = :estilo_id";
	            }
	            else {
	                cWhere = cWhere + " and estilo_id = :estilo_id";
	            }            
	        }
	        if (idpais != 0) {
	        	if (cWhere.isBlank()) {
	        		cWhere = cWhere + " pais_id = :pais_id";
	        	}
	        	else {
	                cWhere = cWhere + " and pais_id = :pais_id";
	            } 
	        }
	        if (idamargor != 0) {
	        	if (cWhere.isBlank()) {
	        		cWhere = cWhere + " amargor_id = :amargor_id";
	        	}
	        	else {
	                cWhere = cWhere + " and amargor_id = :amargor_id";
	            } 
	        }
	        
	        if(cWhere.isBlank()) {
	        	q = em.createQuery(cSql);
	        } else {
	        	q = em.createQuery(cSql + " where " + cWhere); 
	        }
	        
	               
	        
	        if (nome.isBlank()) {
	        	
	        }
	        else {
	            q.setParameter("nome", nome);
	        }        
	        if (idtipo != 0) {
	            q.setParameter("estilo_id", idtipo);
	        }
	        if (idpais != 0) {
	        	q.setParameter("pais_id", idpais);
	        }
	        if (idamargor != 0) {
	        	q.setParameter("amargor_id", idamargor);
	        }
	        
	        System.out.println(cSql + " WHERE " + cWhere);
	        
	        return q.getResultList();        
	    }
		
		public List<Cerveja> pesquisaCatalogo(String nome, Integer idApreciador) throws Exception{        
	        EntityManager em = Conexao.getEntityManager();
	        String cSql = "select g from TB_APRECIADOR_CERVEJA g";
	        String cWhere = "apreciador_id = :idapreciador";
	        Query q = null;
	        if (nome.isBlank()) {
	        }
	        else {
	            cWhere = " and nome = :nome";
	        }        
	        
	        
	        q = em.createQuery(cSql + " where " + cWhere); 
	        
	        if (nome.isBlank()) {
	        	
	        }
	        else {
	            q.setParameter("nome", nome);
	        }        
	        
	        q.setParameter("idapreciador", idApreciador);
	        
	        System.out.println(cSql + " WHERE " + cWhere);
	        
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
		
		public Cerveja getCervejaById(int id) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		        Cerveja cerveja = (Cerveja) em.createQuery("SELECT c from Cerveja c where c.id = :id").setParameter("id", id).getSingleResult();
		      

		        return cerveja;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
		
		public List<Cerveja> consultarCervProdutor(Produtor produtor) throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("Select c from Cerveja c where c.produtor = :id");
			q.setParameter("id", produtor);
			return q.getResultList();				
		}
		
		public int numeroCervejas() {
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Cerveja");
			List <Cerveja> lista = q.getResultList();
			int i = lista.size();
			return i;
		}
		
		public void favoritar(Cerveja cerveja, Apreciador apreciador) throws Exception {
			try {
	            Connection con = null;
	            String url = "jdbc:sqlserver://localhost;databaseName=bancoPI;";
	            
	            String username = "Teste";
	   		 	String password = "barth2006";
	   		 	
	            con = DriverManager.getConnection(url,username,password);
	            String cSql = "select * from TB_APRECIADOR_CERVEJA where apreciador_id = (?) and cerveja_id = (?)";

	            PreparedStatement pstnt = con.prepareStatement(cSql);
	            pstnt.setInt(1, apreciador.getId());
	            pstnt.setInt(2, cerveja.getId());

	            ResultSet rs = pstnt.executeQuery();
	            int numLinhas = 0;
	            while (rs.next()) {
	                numLinhas++;
	            }
	            if (numLinhas == 0) {
	                
	                cSql = "insert into TB_APRECIADOR_CERVEJA (apreciador_id, cerveja_id) " + "values (?, ?)";
	                pstnt = con.prepareStatement(cSql);
	                pstnt.setInt(1, apreciador.getId());
	                pstnt.setInt(2, cerveja.getId());
	                pstnt.execute();
	                JOptionPane.showMessageDialog(null, "Cerveja favoritada");
	                //System.out.println("favoritada");
	            } else {
	                JOptionPane.showMessageDialog(null, "Voce ja favoritou essa cerveja");
	            	//System.out.println("ja favoritou");
	            }

	            pstnt.close();
	            con.close();

	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage());
	        	//System.out.println(ex);
	        }
					
		}
		
		
		public void desfavoritar(Cerveja cerveja, Apreciador apreciador) throws Exception {
			try {
				Connection con = null;
				String url = "jdbc:sqlserver://localhost;databaseName=bancoPI;";
          
				String username = "Teste";
				String password = "barth2006";
 		 	
				con = DriverManager.getConnection(url,username,password);
				

		        String cSql = "delete from TB_APRECIADOR_CERVEJA where apreciador_id = ? and cerveja_id = ?";
		        PreparedStatement pstnt = con.prepareStatement(cSql);
		        pstnt = con.prepareStatement(cSql);
		        pstnt.setInt(1, apreciador.getId());
		        pstnt.setInt(2, cerveja.getId());
		        pstnt.execute();
		        JOptionPane.showMessageDialog(null, "Cerveja desfavoritada");         
	             	          
		        pstnt.close();
		        con.close();

			} catch (Exception ex) {
	          JOptionPane.showMessageDialog(null, ex.getMessage());
	      	
			}
					
		}
		
		public List<Cerveja> consultarFavoritos(Integer idApreciador) throws Exception{
			// criar uma var para lista
			List<Cerveja> lista = new ArrayList<>();
			try {
				Connection con = null;
				String url = "jdbc:sqlserver://localhost;databaseName=bancoPI;";
          
				String username = "Teste";
				String password = "barth2006";
 		 	
				con = DriverManager.getConnection(url,username,password);	
				
				String cSql = "SELECT * FROM TB_APRECIADOR_CERVEJA WHERE apreciador_id = ?";
				PreparedStatement pstmt = con.prepareStatement(cSql);
				pstmt.setInt(1, idApreciador);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					int codigoCerveja = rs.getInt(2);
					// pegando o vlr do nome do bd e jogo na var nome
					
					Cerveja cerveja = new Cerveja();
					cerveja.setId(codigoCerveja); /// rs.getInt(1);
					Cerveja cervejaSelect = getCervejaById(cerveja.getId());
					
					lista.add(cervejaSelect);				
				}		
				
				return lista;
			} catch(SQLException e) {
				throw new Exception("Erro selecionando Cerveja: "+e.getMessage());
			}				
		}
		
		
}

