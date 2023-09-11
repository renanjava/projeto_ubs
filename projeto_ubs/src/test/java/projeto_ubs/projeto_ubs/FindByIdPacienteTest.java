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
import ubs.exceptions.ObjetoSemDadosException;
import ubs.exceptions.ObjetoNaoEncontradoException;

public class FindByIdPacienteTest {
	
	@Test
	public void buscarDeveRetornarPacienteValido() throws Exception {
		PacienteDAO userPosDAO = new PacienteDAO();
		Paciente usuarioEncontrado = userPosDAO.findById("11");
		assertEquals(1, usuarioEncontrado.getIdade());
	}
	
	@Test
	public void buscarDeveRetornarUsuarioNullException() throws ObjetoNaoEncontradoException{
		PacienteDAO userPosDAO = new PacienteDAO();
		
		Exception resultado = assertThrows(ObjetoNaoEncontradoException.class, 
				() -> userPosDAO.findById("96868685"));
		
		assertEquals("Nenhum objeto foi encontrado", resultado.getMessage());
	}
	
	@Test
	public void buscarDeveRetornarStringNullException() throws ObjetoSemDadosException {
		PacienteDAO userPosDAO = new PacienteDAO();
				
		Exception resultado = assertThrows(ObjetoSemDadosException.class, 
				()-> userPosDAO.findById(null));
		assertEquals("O objeto informado não tem dados",resultado.getMessage());
	}
}
