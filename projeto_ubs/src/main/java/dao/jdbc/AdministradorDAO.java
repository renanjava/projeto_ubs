package dao.jdbc;

import ubs.enums.BuscarBanco;
import ubs.interfaces.OperacoesDAO;

import java.util.ArrayList;
import java.util.List;

import model.Administrador;

public class AdministradorDAO implements OperacoesDAO<Administrador> {
	
	public void create(Administrador admSalvar) throws Exception{
		
	}
	public List<Administrador> findAll() throws Exception{
		List<Administrador> listar = new ArrayList<Administrador>();
		
		return listar;
	}
	public void update(Administrador admAlterar) {
		
	}
	public void delete(String codigo) {
		
	}
	public Administrador findById(String chavePK, BuscarBanco tabela) throws Exception{
		Administrador adm = new Administrador();
		
		return adm;
	}
}