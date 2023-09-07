package dao.jdbc;

import ubs.enums.BuscarBanco;
import ubs.interfaces.OperacoesDAO;

import java.util.ArrayList;
import java.util.List;

import model.Medico;

public class MedicoDAO implements OperacoesDAO<Medico> {
	
	public void create(Medico medicoSalvar) throws Exception{
		
	}
	public List<Medico> findAll() throws Exception{
		List<Medico> listar = new ArrayList<Medico>();
		
		return listar;
	}
	public void update(Medico medicoAlterar) {
		
	}
	public void delete(String codigo) {
		
	}
	public Medico findById(String chavePK, BuscarBanco tabela) throws Exception{
		Medico medico = new Medico();
		
		return medico;
	}
}
