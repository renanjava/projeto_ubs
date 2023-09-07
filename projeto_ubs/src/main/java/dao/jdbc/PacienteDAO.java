package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.postgres.SingleConnection;
import model.Paciente;
import ubs.enums.BuscarBanco;
import ubs.exceptions.UsuarioSemDadosException;
import ubs.interfaces.OperacoesDAO;
import ubs.exceptions.UsuarioNaoEncontradoException;
import ubs.exceptions.UsuarioPkDuplicadaException;

public class PacienteDAO implements OperacoesDAO<Paciente> {
	private Connection conexao;

	public PacienteDAO() {
		conexao = SingleConnection.getConnection();
	}

	public void create(Paciente pacienteSalvar) throws Exception {

		if (pacienteSalvar == null)
			throw new UsuarioSemDadosException();

		if (pacienteSalvar.getCpf().equals(findById(
				pacienteSalvar.getCpf(), BuscarBanco.PACIENTE).getCpf()))
			throw new UsuarioPkDuplicadaException();

		try {
			String sql = "INSERT INTO PACIENTE(NOME, IDADE, EMAIL, CPF, SENHA)" + " VALUES(?, ?, ?, ?, ?)";

			PreparedStatement insert = conexao.prepareStatement(sql);
			insert.setString(1, pacienteSalvar.getNome());
			insert.setInt(2, pacienteSalvar.getIdade());
			insert.setString(3, pacienteSalvar.getEmail());
			insert.setString(4, pacienteSalvar.getCpf());
			insert.setString(5, pacienteSalvar.getSenha());

			insert.execute();
			conexao.commit();
			System.out.println("Cadastrado no banco de dados");

		} catch (Exception e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public List<Paciente> findAll() throws Exception {
		List<Paciente> lista = new ArrayList<Paciente>();

		String sql = "SELECT * FROM PACIENTE";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			// Paciente user = new Paciente();
			// user.setNome(resultado.getString("NOME"));
			// user.setEmail(resultado.getString("EMAIL"));
			// lista.add(user);
		}

		return lista;
	}

	public Paciente findById(String cpf, BuscarBanco tabela) throws Exception {

		if (cpf == null)
			throw new UsuarioSemDadosException();

		String sql = "SELECT * FROM " + tabela + " " + "WHERE " + tabela.getChavePrimaria() + " = '" + cpf + "'";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		Paciente usuarioEncontrado = new Paciente();

		if (!resultado.next())
			throw new UsuarioNaoEncontradoException();

		usuarioEncontrado.setNome(resultado.getString("NOME"));
		usuarioEncontrado.setIdade(resultado.getInt("IDADE"));
		usuarioEncontrado.setEmail(resultado.getString("EMAIL"));
		usuarioEncontrado.setCpf(resultado.getString("CPF"));
		usuarioEncontrado.setSenha(resultado.getString("SENHA"));
		return usuarioEncontrado;
	}

	public void update(Paciente pacienteModificado) {
		String sql = "UPDATE Paciente " + " SET EMAIL = ?" 
					+"WHERE ID = " + pacienteModificado.getCpf();
		try {
			PreparedStatement update = conexao.prepareStatement(sql);
			update.setString(1, pacienteModificado.getEmail());
			update.execute();
			conexao.commit();
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void delete(String cpf) {
		String sql = "DELETE FROM PACIENTE" + "	  WHERE CPF = " + cpf;
		try {
			PreparedStatement delete = conexao.prepareStatement(sql);
			delete.execute();
			conexao.commit();
		} catch (Exception e) {
			try {
				conexao.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
