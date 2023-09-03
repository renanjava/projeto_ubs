package ubs.threads;

import java.util.Date;

import javax.swing.JOptionPane;

public class ThreadTempoLimite extends Thread{
	private int tempo = 30;
	
	public void run() {
		
		Date limite = new Date();
		limite.setSeconds(limite.getSeconds()+tempo);
		
		while (!Thread.currentThread().isInterrupted()) { //enquanto a thread não for interrompida, ela executa isto
			Date atual = new Date();
			if(atual.after(limite)) {
				JOptionPane.showMessageDialog(null, "Tempo limite de acesso alcançado. Tente novamente!");
				break;
			}
			continue;
		}
	}
}

