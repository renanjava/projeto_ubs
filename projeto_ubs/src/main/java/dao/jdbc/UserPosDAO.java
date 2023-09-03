package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.postgres.SingleConnection;
import model.Paciente;

public class UserPosDAO {
	private Connection conexao;

	public UserPosDAO() {
		conexao = SingleConnection.getConnection();
	}

	public void salvar(Paciente paciente) {
		try {
			String sql = "INSERT INTO PACIENTE(NOME, EMAIL, USERNAME, SENHA,"
					+ "CPF, IDADE) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement insert = conexao.prepareStatement(sql);
			insert.setString(1, paciente.getNome());
			insert.setString(2, paciente.getEmail());
			insert.setString(3, paciente.getUsername());
			insert.setString(4, paciente.getSenha());
			insert.setString(5, paciente.getCpf());
			insert.setInt(6, paciente.getIdade());
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

		String sql = "SELECT * FROM Paciente";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			//Paciente user = new Paciente();
			//user.setNome(resultado.getString("NOME"));
			//user.setEmail(resultado.getString("EMAIL"));
			//lista.add(user);
		}

		return lista;
	}

	/*public Paciente buscar(Long id) throws Exception {
		//Paciente usuario = new Paciente();

		String sql = "SELECT * FROM PACIENTE WHERE ID = "+id;

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			//usuario.setNome(resultado.getString("NOME"));
			//usuario.setEmail(resultado.getString("EMAIL"));
		}

		//return usuario;
	}
	*/
	public void atualizar(Long id, String nomeAtualizado) {
		String sql = "UPDATE Paciente "
				+ "	  SET NOME = ?"
				+ "	  WHERE ID = "+id;
		try {
			PreparedStatement update = conexao.prepareStatement(sql);
			update.setString(1, nomeAtualizado);
			update.execute();
			conexao.commit();
		} catch (SQLException e) {
			try {
				conexao.rollback();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void deletar(Long id) {
		String sql = "DELETE FROM PACIENTE"
				+ "	  WHERE ID = "+id;
		try {
			PreparedStatement delete = conexao.prepareStatement(sql);
			delete.execute();
			conexao.commit();
		}catch(Exception e){
			try {
				conexao.rollback();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}

