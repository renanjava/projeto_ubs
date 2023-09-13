package dao.jdbc;

import ubs.enums.AreaMedico;
import ubs.exceptions.ObjetoNaoEncontradoException;
import ubs.interfaces.OperacoesDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Medico;
import model.Paciente;

public class MedicoDAO extends ConexaoDAO implements OperacoesDAO<Medico> {

	public MedicoDAO() {
		super();
	}

	public void create(Medico medicoSalvar) throws Exception {

	}

	public List<Medico> findAll() throws Exception {
		List<Medico> listar = new ArrayList<Medico>();

		return listar;
	}

	public void update(Medico medicoAlterar) {

	}

	public void delete(String codigo) {

	}

	public Medico findById(String crm) throws Exception {
		String sql = "SELECT * FROM MEDICO "
					+ "WHERE CRM = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, crm);
		ResultSet resultado = statement.executeQuery();

		Medico usuarioEncontrado = new Medico();

		if (!resultado.next())
			throw new ObjetoNaoEncontradoException();

		usuarioEncontrado.setNome(resultado.getString("NOME"));
		usuarioEncontrado.setPk(resultado.getString("CRM"));
		usuarioEncontrado.setSenha(resultado.getString("SENHA"));
		usuarioEncontrado.setEspecializacao(AreaMedico.valueOf(resultado.getString("ESPECIALIZACAO")));
		return usuarioEncontrado;
	}
}
