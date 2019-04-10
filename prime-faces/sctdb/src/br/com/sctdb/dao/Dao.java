package br.com.sctdb.dao;

import java.util.List;

public interface Dao<T> {

	/**
	 * @param entidade
	 */
	void cadastrar(T entidade);

	/**
	 * @param entidade
	 */
	void alterar(T entidade);

	/**
	 * @param id
	 * @return entidade
	 */
	T buscar(int id);

	/**
	 * @param entidade
	 */
	void deletar(T entidade);

	/**
	 * @return lista
	 */
	List<T> listar();

}
