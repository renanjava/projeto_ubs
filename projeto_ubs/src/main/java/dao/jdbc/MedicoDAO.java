package dao.jdbc;

import ubs.exceptions.ObjetoNaoEncontradoException;
import ubs.interfaces.OperacoesDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.PessoaDAO;
import model.Medico;
import model.Paciente;

public class MedicoDAO extends PessoaDAO implements OperacoesDAO<Medico> {

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
					+ "WHERE CRM = '" + crm + "'";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		Medico usuarioEncontrado = new Medico();

		if (!resultado.next())
			throw new ObjetoNaoEncontradoException();

		usuarioEncontrado.setNome(resultado.getString("NOME"));
		usuarioEncontrado.setPk(resultado.getString("CRM"));
		usuarioEncontrado.setSenha(resultado.getString("SENHA"));
		return usuarioEncontrado;
	}
}
