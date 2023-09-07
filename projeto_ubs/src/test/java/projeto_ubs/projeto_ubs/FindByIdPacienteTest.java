package projeto_ubs.projeto_ubs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

import conexao.postgres.SingleConnection;
import dao.jdbc.PacienteDAO;
import model.Paciente;
import ubs.enums.BuscarBanco;
import ubs.exceptions.UsuarioSemDadosException;
import ubs.exceptions.UsuarioNaoEncontradoException;

public class FindByIdPacienteTest {
	
	@Test
	public void buscarDeveRetornarPacienteValido() throws Exception {
		PacienteDAO userPosDAO = new PacienteDAO();
		Paciente usuarioEncontrado = userPosDAO.findById("11", BuscarBanco.PACIENTE);
		assertEquals(1, usuarioEncontrado.getIdade());
	}
	
	@Test
	public void buscarDeveRetornarUsuarioNullException() throws UsuarioNaoEncontradoException{
		PacienteDAO userPosDAO = new PacienteDAO();
		
		Exception resultado = assertThrows(UsuarioNaoEncontradoException.class, 
				() -> userPosDAO.findById("96868685", BuscarBanco.PACIENTE));
		
		assertEquals("O usuário não foi encontrado", resultado.getMessage());
	}
	
	@Test
	public void buscarDeveRetornarStringNullException() throws UsuarioSemDadosException {
		PacienteDAO userPosDAO = new PacienteDAO();
				
		Exception resultado = assertThrows(UsuarioSemDadosException.class, 
				()-> userPosDAO.findById(null, BuscarBanco.PACIENTE));
		assertEquals("O usuário informado não tem dados",resultado.getMessage());
	}
}
