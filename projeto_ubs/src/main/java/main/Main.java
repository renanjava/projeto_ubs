package main;

import javax.swing.JOptionPane;

import ubs.swing.TelaCadastro;

public class Main {

	public static void main(String[] args) {
		String botoesCadastro[] = {"Sim","Não"};
		boolean cadastrar = 
				(JOptionPane.showOptionDialog(null, 
				"Deseja realizar o cadastro?", "Cadastrar Usuário", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
				botoesCadastro, botoesCadastro[0]) == 0 ? true : false);
		
		if(cadastrar) {
			TelaCadastro telaCadastro1 = new TelaCadastro(1);
			//TelaCadastro telaCadastro2 = new TelaCadastro(2);
		}else {
			
			
		}

	}

}
