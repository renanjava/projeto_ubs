package dao.jdbc;

import ubs.enums.BuscarBanco;
import ubs.interfaces.OperacoesDAO;

import java.util.ArrayList;
import java.util.List;

import model.Medicamento;

public class MedicamentoDAO implements OperacoesDAO<Medicamento> {
	
	public void create(Medicamento medicamentoSalvar) throws Exception{
		
	}
	public List<Medicamento> findAll() throws Exception{
		List<Medicamento> listar = new ArrayList<Medicamento>();
		
		return listar;
	}
	public void update(Medicamento medicamentoAlterar) {
		
	}
	public void delete(String codigo) {
		
	}
	public Medicamento findById(String chavePK, BuscarBanco tabela) throws Exception{
		Medicamento medicamento = new Medicamento();
		
		return medicamento;
	}
}

