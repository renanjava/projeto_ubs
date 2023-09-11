package classes;

import java.text.SimpleDateFormat;
import javax.swing.UIManager;
import java.util.Date;

import javax.swing.JOptionPane;

import ubs.threads.ThreadContaBloqueio;
import ubs.threads.ThreadTempoLimite;

public class BloqueioDeConta {
	private int qtdErro = 0;
	private ThreadContaBloqueio tContaBloqueio;
	private ThreadTempoLimite tTempoLimite;

	public void instrucoesBloqueio() {
		JOptionPane.showMessageDialog(null, 
				"Instruções\n\n" 
				+ "- 30 segundos para logar-se\n"
				+"- 10 segundos de bloqueio de conta\n" 
				+ "- 3 Tentativas de login\n\n");
	}

	public void iniciarContagem() {
		tContaBloqueio = new ThreadContaBloqueio();
		tTempoLimite = new ThreadTempoLimite();
		tTempoLimite.start();
	}

	public void atingiuQtdErrosLimite() {
		tTempoLimite.interrupt();
		tContaBloqueio.start();
		InfoBloqueio();
		qtdErro = 0;
	}
	
	public static void InfoBloqueio() {
		Date dataHorario = new Date();
		SimpleDateFormat horarioFormatado = new SimpleDateFormat("HH:mm:ss");
		String exibirData1 = "Acesso bloqueado em: " + horarioFormatado.format(dataHorario);
		dataHorario.setSeconds(dataHorario.getSeconds() + 15);
		String exibirData2 = "Acesso desbloqueará em: " + horarioFormatado.format(dataHorario);
		JOptionPane.showMessageDialog(null, exibirData1 + "\n" + exibirData2);
		dataHorario.setSeconds(dataHorario.getSeconds() - 15);
	}

	public void somarErro() {
		qtdErro += 1;
	}

	public int getQtdErro() {
		return qtdErro;
	}

	public ThreadContaBloqueio getTContaBloqueio() {
		return tContaBloqueio;
	}

	public ThreadTempoLimite getTTempoLimite() {
		return tTempoLimite;
	}
}
