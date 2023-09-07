package projeto_ubs.projeto_ubs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import dao.jdbc.PacienteDAO;
import model.Paciente;
import ubs.enums.BuscarBanco;
import ubs.exceptions.UsuarioNaoEncontradoException;
import ubs.exceptions.UsuarioPkDuplicadaException;
import ubs.exceptions.UsuarioSemDadosException;

public class CreatePacienteTest {
	
	@Test
	public void salvarDeveInserirNoBanco() throws Exception{
		PacienteDAO userPosDAO = new PacienteDAO();
		
		Paciente usuarioInserido = new Paciente();
		usuarioInserido.setCpf("000.000.000-00");

		//;
		
		//assertEquals(, userPosDAO.salvar(usuarioInserido));
	}
	
	@Test
	public void salvarDeveBloquearUsuarioNulo() throws UsuarioSemDadosException{
		PacienteDAO userPosDAO = new PacienteDAO();
		
		Exception resultado = assertThrows(UsuarioSemDadosException.class,
				() -> userPosDAO.create(null));
		assertEquals("O usuário informado não tem dados",resultado.getMessage());
	}
	
	@Test
	public void salvarDeveBloquearPkDuplicada() throws Exception{
		PacienteDAO userPosDAO = new PacienteDAO();
		
		Paciente usuarioPkDuplicada = new Paciente();
		usuarioPkDuplicada.setCpf("000.000.000-00");
		
		Exception resultado = assertThrows(UsuarioPkDuplicadaException.class,
				() -> userPosDAO.create(usuarioPkDuplicada));
		
		assertEquals("A chave primária do usuário já existe", resultado.getMessage());
	}
}
