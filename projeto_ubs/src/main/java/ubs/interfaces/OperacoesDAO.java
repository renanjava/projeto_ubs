package ubs.interfaces;

import java.util.List;

public interface OperacoesDAO<T> {
	
	public void create(T usuarioSalvar) throws Exception;
	public List<T> findAll() throws Exception;
	public void update(T usuarioAlterar);
	public void delete(String codigo);
	public T findById(String chaveP) throws Exception;
}
