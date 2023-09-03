package main;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.swing.JOptionPane;

import conexao.postgres.SingleConnection;
import model.Paciente;
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
		
		SingleConnection conexaoTeste = new SingleConnection();
		
		if(cadastrar) {
			Paciente paciente = new Paciente(); //teste jdbc
			TelaCadastro telaCadastro = new TelaCadastro(paciente,1);
			
		}else {
			TelaLogin telaLogin = new TelaLogin();
		}
			

	}

}
