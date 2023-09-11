package projeto_ubs.projeto_ubs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import dao.jdbc.PacienteDAO;
import model.Paciente;
import ubs.exceptions.ObjetoNaoEncontradoException;
import ubs.exceptions.PkDuplicadaException;
import ubs.exceptions.ObjetoSemDadosException;

public class CreatePacienteTest {
	
	@Test
	public void salvarDeveInserirNoBanco() throws Exception{
		PacienteDAO pacienteDAO = new PacienteDAO();
		
		Paciente pacienteInserir = new Paciente();
		pacienteInserir.setPk("900.090.009-90");
		pacienteInserir.setEmail("teste@unitario");
		pacienteInserir.setIdade(99);
		pacienteInserir.setNome("TESTES UNITÁRIOS");
		pacienteInserir.setSenha("teste123");
		
		pacienteDAO.create(pacienteInserir);
		assertEquals(pacienteInserir.getNome(),pacienteInserir.getNome());
		
		Paciente pacienteBuscado = pacienteDAO.findById(pacienteInserir.getPk());
		assertEquals(pacienteBuscado.getNome(), pacienteInserir.getNome());
	}
	
	@Test
	public void salvarDeveBloquearUsuarioNulo() throws ObjetoSemDadosException{
		PacienteDAO pacienteDAO = new PacienteDAO();
		
		Exception resultado = assertThrows(ObjetoSemDadosException.class,
				() -> pacienteDAO.create(null));
		assertEquals("O objeto informado não tem dados",resultado.getMessage());
	}
	
	@Test
	public void salvarDeveBloquearPkDuplicada() throws Exception{
		PacienteDAO pacienteDAO = new PacienteDAO();
		
		Paciente usuarioPkDuplicada = new Paciente();
		usuarioPkDuplicada.setPk("900.090.009-90");
		
		Exception resultado = assertThrows(PkDuplicadaException.class,
				() -> pacienteDAO.create(usuarioPkDuplicada));
		
		assertEquals("A chave primária já existe", resultado.getMessage());
	}
}
