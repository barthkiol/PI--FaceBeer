package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sqlserver");

	public static EntityManager getEntityManager() { // getConnection() {
		return emf.createEntityManager();
	}
}
