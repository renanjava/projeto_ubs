
package projeto_ubs.projeto_ubs;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import dao.jdbc.FunctionDAO;
import ubs.exceptions.ObjetoNaoEncontradoException;

public class FunctionQuantidadeConsultaTest {
	
	@Test
	public void functionDeveRetornarQuantidadeConsulta() throws Exception {
		FunctionDAO functionDAO = new FunctionDAO();
		
		assertEquals(2,functionDAO.qtdPacienteAtendimentoPorEspecializacao("PSIQUIATRA"));
	}
}
