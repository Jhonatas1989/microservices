package br.com.sctdb.dao;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author Jhonatas Oliveira
 *
 * @param <T>
 */
public class GenericDao<T> implements Dao<T> {

	private final Class<T> classe;
	protected EntityManager em;

	public GenericDao(Class<T> classe) {
		this.classe = classe;
		em = JpaUtil.getEntityManager();
	}

	/*
	 * Metodo para criar e salvar um objeto
	 * 
	 * @see br.com.sctdb.dao.Dao#salvar(java.lang.Object)
	 */
	@Override
	public void cadastrar(T entidade) {
		try {
			em.getTransaction().begin();
			em.persist(entidade);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	@Override
	public void alterar(T entidade) {
		try {
			em.getTransaction().begin();
			em.merge(entidade);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	/*
	 * Metodo para listar os objetos
	 * 
	 * @see br.com.sctdb.dao.Dao#listar() Return uma lista de objetos T
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName()).getResultList();
	}

	/*
	 * Metodo para buscar o objeto a partir de um ID
	 * 
	 * @see br.com.sctdb.dao.Dao#buscar(int) return um objeto T
	 */
	@Override
	public T buscar(int id) {
		return em.find(classe, id);
	}

	/*
	 * Exclui um objeto a partir de um ID
	 * 
	 * @see br.com.sctdb.dao.Dao#deletar(java.lang.Object) Return Excluir um
	 * objeto
	 */
	@Override
	public void deletar(T entidade) {
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(entidade));
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}