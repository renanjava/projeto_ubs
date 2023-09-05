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
import ubs.exceptions.UsuarioNaoEncontradoException;
import ubs.exceptions.UsuarioPkDuplicadaException;

public class UserPosDAO {
	private Connection conexao;

	public UserPosDAO() {
		conexao = SingleConnection.getConnection();
	}

	public void salvar(Paciente paciente) throws Exception
	{
		
		if(paciente == null)
			throw new UsuarioSemDadosException();
		
		if(paciente.getCpf().equals(buscar(paciente.getCpf(),BuscarBanco.PACIENTE).getCpf()))
			throw new UsuarioPkDuplicadaException();
		
		try {
			String sql = "INSERT INTO PACIENTE(NOME, IDADE, EMAIL, CPF, SENHA)" 
						+" VALUES(?, ?, ?, ?, ?)";

			PreparedStatement insert = conexao.prepareStatement(sql);
			insert.setString(1, paciente.getNome());
			insert.setInt(2, paciente.getIdade());
			insert.setString(3, paciente.getEmail());
			insert.setString(4, paciente.getCpf());
			insert.setString(5, paciente.getSenha());

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
	}

	public List<Paciente> listar() throws Exception {
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

	public Paciente buscar(String cpf, BuscarBanco tabela) throws Exception {
		
		if(cpf == null)
			throw new UsuarioSemDadosException();

		String sql = "SELECT * FROM " + tabela + " " + 
					 "WHERE " + tabela.getChavePrimaria() + " = '" + cpf + "'";

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

	/*
	 * public void atualizar(Long id, String nomeAtualizado) { String sql =
	 * "UPDATE Paciente " + "	  SET NOME = ?" + "	  WHERE ID = "+id; try {
	 * PreparedStatement update = conexao.prepareStatement(sql); update.setString(1,
	 * nomeAtualizado); update.execute(); conexao.commit(); } catch (SQLException e)
	 * { try { conexao.rollback(); }catch(Exception e1) { e1.printStackTrace(); }
	 * e.printStackTrace(); } }
	 * 
	 * public void deletar(Long id) { String sql = "DELETE FROM PACIENTE" +
	 * "	  WHERE ID = "+id; try { PreparedStatement delete =
	 * conexao.prepareStatement(sql); delete.execute(); conexao.commit();
	 * }catch(Exception e){ try { conexao.rollback(); }catch(Exception e1) {
	 * e1.printStackTrace(); } e.printStackTrace(); } }
	 */
}
