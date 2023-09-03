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
			//Paciente user = new Paciente();
			//user.setNome(resultado.getString("NOME"));
			//user.setEmail(resultado.getString("EMAIL"));
			//lista.add(user);
		}

		return lista;
	}

	public boolean buscar(String cpf, String senha) throws Exception {
		
		String sql = "SELECT CPF, SENHA FROM PACIENTE WHERE CPF = '"+cpf+"'";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		boolean encontrou;
		Paciente usuarioEncontrado = new Paciente();

		while (resultado.next()) {
			usuarioEncontrado.setCpf(resultado.getString("CPF"));
			usuarioEncontrado.setSenha(resultado.getString("SENHA"));
		}
		
		if(usuarioEncontrado.getCpf().equals(cpf) 
		&& usuarioEncontrado.getSenha().equals(senha)) 
			encontrou = true;
		else
			encontrou = false;
		/*
		usuarioBuscado.setNome(resultado.getString("NOME"));
		usuarioBuscado.setIdade(resultado.getInt("IDADE"));
		usuarioBuscado.setEmail(resultado.getString("EMAIL"));
		usuarioBuscado.setCpf(resultado.getString("CPF"));
		usuarioBuscado.setSenha(resultado.getString("SENHA"));
		*/
		
		return encontrou;
	}
	
	/*
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
	 */
}

