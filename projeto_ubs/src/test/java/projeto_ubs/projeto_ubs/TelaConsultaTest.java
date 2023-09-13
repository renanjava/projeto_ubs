package projeto_ubs.projeto_ubs;

import org.junit.jupiter.api.Test;

import model.Paciente;
import ubs.swing.TelaPacienteConsulta;

public class TelaConsultaTest {

	@Test
	public void telaConsultaTeste() throws InterruptedException {
		TelaPacienteConsulta telaConsulta = new TelaPacienteConsulta(new Paciente());
		Thread.sleep(9000);
	}
}
