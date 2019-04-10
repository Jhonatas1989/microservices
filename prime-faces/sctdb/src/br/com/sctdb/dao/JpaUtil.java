package br.com.sctdb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Jhonatas Oliveira
 *
 */
public class JpaUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sctdb_jpa");

	/**
	 * @return
	 */
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}
