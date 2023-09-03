package ubs.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class ThreadContaBloqueio extends Thread{
	private boolean controle = false;
	private int contador = 15;
	private int tempoLimite = 10;
	
	public void run() {
		controle = true; //true: está em execução
		Date dataHorario = new Date();
		SimpleDateFormat horarioFormatado = new SimpleDateFormat("HH:mm:ss");
		try {
			do {
				System.out.print("Conta bloqueada, aguarde " + contador);
				if(contador > 1)
					System.out.print(" segundos - ");
				else
					System.out.print(" segundo - ");
				
				System.out.println(horarioFormatado.format(dataHorario));
				Thread.sleep(1000);
				dataHorario.setSeconds(dataHorario.getSeconds()+1);
				contador--;
			}while(contador > 0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		controle = false;//false: parou de executar
		System.out.println("Conta desbloqueada - "+horarioFormatado.format(dataHorario));
				ThreadTempoLimite tTempoLimite = new ThreadTempoLimite();
		tTempoLimite.start();
	}

	public boolean isControle() {
		return controle;
	}

	public void setControle(boolean controle) {
		this.controle = controle;
	}

	public int getContador() {
		return contador;
	}
}
