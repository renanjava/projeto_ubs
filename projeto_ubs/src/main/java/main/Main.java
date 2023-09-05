package main;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.swing.JOptionPane;

import com.sun.jna.platform.win32.User32Util;
import com.sun.jna.platform.win32.COM.TypeLibUtil.FindName;

import classes.BloqueioDeConta;
import conexao.postgres.SingleConnection;
import dao.jdbc.UserPosDAO;
import model.Paciente;
import ubs.email.CodigoConfirmacao;
import ubs.enums.ConsultaBanco;
import ubs.swing.TelaCadastro;
import ubs.swing.TelaInicial;
import ubs.swing.TelaLogin;

public class Main {

	public static void main(String[] args)
			throws UnsupportedEncodingException, MessagingException, InterruptedException {
		
		Paciente usuarioLogado = null;
		String botoesCadastro[] = { "Login", "Cadastro" };
		boolean logar = 
				(JOptionPane.showOptionDialog(null, "Seja bem-vindo(a)!", 
						"Início", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, botoesCadastro, 
						botoesCadastro[0]) == 0 ? true : false);

		SingleConnection conexaoTeste = new SingleConnection();

		if (logar) {

			BloqueioDeConta bloqueioConta = new BloqueioDeConta();
			bloqueioConta.instrucoesBloqueio();
			bloqueioConta.iniciarContagem();
			do {
				TelaLogin telaLogin = new TelaLogin();

				while (!telaLogin.getBotaoAcionado()) {
					Thread.sleep(350); // aguardando o botão logar ser acionado
				}

				UserPosDAO userPosDAO = new UserPosDAO();

				try {
					usuarioLogado = userPosDAO.buscar(telaLogin.getCampoCpf().getText(),
							ConsultaBanco.PACIENTE);
					
					if (usuarioLogado.getCpf().equals(telaLogin.getCampoCpf().getText())
							&& usuarioLogado.getSenha().equals(
									telaLogin.getCampoSenha().getText())
							&& !bloqueioConta.getTContaBloqueio().isControle()) {
						
						bloqueioConta.getTTempoLimite().interrupt();
						JOptionPane.showMessageDialog(null, "Logado!");
						break;

					}else 
						erroLogin(bloqueioConta,"Dados Inválidos");
						
				} catch (Exception e1) {
					erroLogin(bloqueioConta,"Conta não cadastrada");
				}
				
			} while (true);
		} else {
			Paciente paciente = new Paciente(); // teste jdbc
			TelaCadastro telaCadastro = new TelaCadastro(paciente);
			while (!telaCadastro.getBotaoAcionado()) {
				Thread.sleep(350); // aguardando o botão salvar ser acionado
			}
			System.exit(0);
		}
		
		//a partir daqui, o usuário logou em uma conta
		TelaInicial telaInicial = new TelaInicial(usuarioLogado);

	}
	
	public static void erroLogin(BloqueioDeConta bloqueioConta, String msgErro) {
		if (!bloqueioConta.getTContaBloqueio().isControle()) {
			JOptionPane.showMessageDialog(null, msgErro);
			bloqueioConta.somarErro();

			if (bloqueioConta.getQtdErro() == 3)
				bloqueioConta.atingiuQtdErrosLimite();
		} else {
			JOptionPane.showMessageDialog(null, "Acesso bloqueado, aguarde...");
		}
	}

}
