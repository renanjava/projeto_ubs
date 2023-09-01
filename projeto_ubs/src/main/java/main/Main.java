package main;

import javax.swing.JOptionPane;

import ubs.swing.TelaCadastro;
import ubs.swing.TelaLogin;

public class Main {

	public static void main(String[] args) {
		String botoesCadastro[] = {"Sim","Não"};
		boolean cadastrar = 
				(JOptionPane.showOptionDialog(null, 
				"Deseja realizar o cadastro?", "Cadastrar Usuário", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
				botoesCadastro, botoesCadastro[0]) == 0 ? true : false);
		
		if(cadastrar) {
			TelaCadastro telaCadastro = new TelaCadastro(1);
		}
		else {
			TelaLogin telaLogin = new TelaLogin();
		}
			

	}

}
