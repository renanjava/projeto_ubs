package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import conexao.postgres.SingleConnection;
import model.Atendimento;
import model.Medicamento;
import model.Paciente;
import ubs.exceptions.ConsultaDuplicadaException;
import ubs.exceptions.ObjetoNaoEncontradoException;
import ubs.exceptions.ObjetoSemDadosException;
import ubs.interfaces.OperacoesDAO;

public class AtendimentoDAO extends ConexaoDAO{

	public AtendimentoDAO() {
		super();
	}
	
	public String create(String cpf, String problema, String profissional) throws Exception {
		
		if(buscarConsultaDuplicada(cpf,problema,profissional))
			throw new ConsultaDuplicadaException();
			
		try {
			String sql = "INSERT INTO ATENDIMENTO(CPF_PACIENTE,PROBLEMA,PROFISSIONAL)" 
						+ " VALUES(?, ?, ?)";

			PreparedStatement insert = conexao.prepareStatement(sql);
			insert.setString(1, cpf);
			insert.setString(2, problema);
			insert.setString(3, profissional);

			insert.execute();
			conexao.commit();
			

		} catch (Exception e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return buscarCodigoConsulta(cpf, problema, profissional);
		
	}
	
	public boolean buscarConsultaDuplicada(String cpf, String problema, String profissional) throws Exception {
		
		String sql = "SELECT * FROM ATENDIMENTO "
				+ "WHERE CPF_PACIENTE = ? "
				+ "AND PROBLEMA = ? "
				+ "AND PROFISSIONAL = ? ";
		
		PreparedStatement consultaDuplicada = conexao.prepareStatement(sql);
		consultaDuplicada.setString(1, cpf);
		consultaDuplicada.setString(2, problema);
		consultaDuplicada.setString(3, profissional);
		
		ResultSet resultado = consultaDuplicada.executeQuery();
		
		if(!resultado.next())
			return false;
		
		return true;
		
	}
	
	public String buscarCodigoConsulta(String cpf, String problema, String profissional) throws Exception {
		
		String sql = "SELECT ID_ATENDIMENTO FROM ATENDIMENTO "
					+ "WHERE CPF_PACIENTE = ? "
					+ "AND PROBLEMA = ? "
					+ "AND PROFISSIONAL = ? ";
		
		PreparedStatement codigoConsulta = conexao.prepareStatement(sql);
		codigoConsulta.setString(1, cpf);
		codigoConsulta.setString(2, problema);
		codigoConsulta.setString(3, profissional);
		
		ResultSet resultado = codigoConsulta.executeQuery();
		
		if(!resultado.next())
			throw new ObjetoNaoEncontradoException();
		
		return resultado.getString("ID_ATENDIMENTO");
	}
	
	public List<Atendimento> findAll() throws Exception{
		List<Atendimento> lista = new ArrayList<Atendimento>();

		String sql = "SELECT * FROM ATENDIMENTO";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			Atendimento user = new Atendimento();
			user.setPk(resultado.getString("CPF_PACIENTE"));
			user.setProblema(resultado.getString("PROBLEMA"));
			user.setProfissional(resultado.getString("PROFISSIONAL"));
			lista.add(user);
		}

		return lista;
	}
	
	public List<Atendimento> findByProfissional(String profissional) throws Exception{
		List<Atendimento> lista = new ArrayList<Atendimento>();

		String sql = "SELECT * FROM ATENDIMENTO WHERE PROFISSIONAL = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, profissional);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			Atendimento user = new Atendimento();
			user.setPk(resultado.getString("CPF_PACIENTE"));
			user.setProblema(resultado.getString("PROBLEMA"));
			user.setProfissional(resultado.getString("PROFISSIONAL"));
			lista.add(user);
		}

		return lista;
	}
}
