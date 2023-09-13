package dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ubs.exceptions.ObjetoNaoEncontradoException;

public class FunctionDAO extends ConexaoDAO {
	
	public FunctionDAO() {
		super();
	}
	
	public int qtdPacienteAtendimentoPorEspecializacao(String especializacao) 
			throws SQLException, ObjetoNaoEncontradoException{
		
		String sql = "SELECT CONTAR_ATENDIMENTO(?);";
		int quantidade = 999;
		
		PreparedStatement buscarQtd = conexao.prepareStatement(sql);
		buscarQtd.setString(1, especializacao);
		ResultSet resultado = buscarQtd.executeQuery();
		
		if(resultado.next())
			quantidade = resultado.getInt(1);
		
		return quantidade;
	}
}
