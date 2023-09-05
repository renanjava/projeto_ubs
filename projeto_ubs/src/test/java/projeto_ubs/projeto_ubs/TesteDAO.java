package projeto_ubs.projeto_ubs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

import conexao.postgres.SingleConnection;
import dao.jdbc.UserPosDAO;
import model.Paciente;
import ubs.enums.BuscarBanco;
import ubs.exceptions.UsuarioNullException;

public class TesteDAO {
	
	@Test
	public void buscarDeveRetornarPacienteValido() throws Exception {
		UserPosDAO userPosDAO = new UserPosDAO();
		Paciente usuarioEncontrado = userPosDAO.buscar("11", BuscarBanco.PACIENTE);
		assertEquals(1, usuarioEncontrado.getIdade());
	}
	
	@Test
	public void buscarDeveRetornarUsuarioNullException() throws UsuarioNullException{
		UserPosDAO userPosDAO = new UserPosDAO();
		
		Exception resultado = assertThrows(UsuarioNullException.class, 
				() -> userPosDAO.buscar("96868685", BuscarBanco.PACIENTE));
		
		assertEquals("Usuário não encontrado", resultado.getMessage());
	}
}
