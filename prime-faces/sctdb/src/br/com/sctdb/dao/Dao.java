package br.com.sctdb.dao;

import java.util.List;

public interface Dao<T> {
	void cadastrar(T entidade);
	void alterar(T entidade);
	T buscar(int id);
	void deletar(T entidade);
	List<T> listar();
	
}
