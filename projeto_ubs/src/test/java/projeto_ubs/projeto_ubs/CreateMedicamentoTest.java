package projeto_ubs.projeto_ubs;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import dao.jdbc.MedicamentoDAO;
import model.Medicamento;
import ubs.enums.TipoMedicamento;
import ubs.exceptions.ObjetoSemDadosException;

public class CreateMedicamentoTest {
	
	@Test
	public void createDeveInserirOuAtualizarMedicamentoNoBanco() throws Exception {
		MedicamentoDAO medDAO = new MedicamentoDAO();
		Medicamento medicamentoSalvar = new Medicamento();
		
		medicamentoSalvar.setCategoria(TipoMedicamento.ANALGESICO);
		medicamentoSalvar.setNome("teste");
		medicamentoSalvar.setQuantidade(1);
		
		medDAO.create(medicamentoSalvar);
	}
	
	@Test
	public void createDeveBloquearMedicamentoNoBanco() throws Exception {
		MedicamentoDAO medDAO = new MedicamentoDAO();
		
		Exception resultado = assertThrows(ObjetoSemDadosException.class,
				() -> medDAO.create(null));
		assertEquals("O objeto informado não tem dados",resultado.getMessage());
	}
}
