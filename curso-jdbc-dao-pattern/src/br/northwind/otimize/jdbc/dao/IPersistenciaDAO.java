package br.northwind.otimize.jdbc.dao;

import java.util.List;
import br.northwind.otimize.jdbc.exception.PersistenciaException;

public interface IPersistenciaDAO<T> {

	void inserir(T obj) throws PersistenciaException;
	
	void atualizar(T obj) throws PersistenciaException;
	
	void remover(Integer id) throws PersistenciaException;
	
	List<T> retornarTodos() throws PersistenciaException;
	
	T retornaPorId(Integer id) throws PersistenciaException;
	
}
