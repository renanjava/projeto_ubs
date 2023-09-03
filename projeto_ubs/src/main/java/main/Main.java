package main;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.swing.JOptionPane;

import ubs.email.CodigoConfirmacao;
import ubs.swing.TelaCadastro;
import ubs.swing.TelaLogin;

public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException, MessagingException, InterruptedException {
		String botoesCadastro[] = {"Cadastro","Login"};
		boolean cadastrar = 
				(JOptionPane.showOptionDialog(null, 
				"Seja bem-vindo(a)!", "Início", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
				botoesCadastro, botoesCadastro[0]) == 0 ? true : false);
		
		if(cadastrar) {
			TelaCadastro telaCadastro = new TelaCadastro(1);
		}else {
			TelaLogin telaLogin = new TelaLogin();
		}
			

	}

}
