package main;


import java.awt.TextField;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import classes.BloqueioDeConta;
import classes.Pessoa;
import dao.jdbc.AdministradorDAO;
import dao.jdbc.MedicoDAO;
import dao.jdbc.PacienteDAO;
import dao.jdbc.ConexaoDAO;
import model.Administrador;
import model.Medico;
import model.Paciente;
import ubs.exceptions.LoginCamposNulosException;
import ubs.exceptions.ObjetoNaoEncontradoException;
import ubs.exceptions.TipoUsuarioInvalidoException;
import ubs.interfaces.OperacoesDAO;
import ubs.swing.TelaCadastro;
import ubs.swing.TelaInicial;
import ubs.swing.TelaLogin;

public class Main {

	public static void main(String[] args)
			throws Exception, ObjetoNaoEncontradoException {
		
		String botoesPaciente[] = { "Login", "Cadastro" };
		String botoesTipoUsuario[] = { "Paciente", "Médico", "Admin" };
		int tipoUsuario = 
				(JOptionPane.showOptionDialog(null, "Olá, qual tipo de usuário você é?", 
				"Início", JOptionPane.DEFAULT_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, botoesTipoUsuario, 
				botoesTipoUsuario[0]))+1;
		
		//1 - Paciente
		//2 - Médico
		//3 - Admin	
		
		Pessoa usuarioLogando = null;
		
		if(tipoUsuario == 1) 
			if(JOptionPane.showOptionDialog(null, "Seja bem-vindo(a)!", 
				"Login/Cadastro", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
				null, botoesPaciente, botoesPaciente[0]) == 1)
				processoCadastroPaciente();
		
		Pessoa usuarioLogadoComSucesso = processoLogin(tipoUsuario);
		//a partir daqui, o usuário logou em uma conta
		TelaInicial telaInicial = new TelaInicial(usuarioLogadoComSucesso);

	}
	
	public static Pessoa processoLogin(int tipoUsuario) throws Exception{	
		
		Pessoa usuarioLogando = null;
		ConexaoDAO operacaoDAO = null;
		
		switch(tipoUsuario) { //definindo o tipo de usuário
			case 1: usuarioLogando = Paciente.class.newInstance(); break;
			case 2: usuarioLogando = Medico.class.newInstance(); break;
			case 3: usuarioLogando = Administrador.class.newInstance(); break;
			default: throw new TipoUsuarioInvalidoException();
		}
		
		switch(tipoUsuario) { //definindo o tipo de operação DAO
			case 1: operacaoDAO = PacienteDAO.class.newInstance(); break;
			case 2: operacaoDAO = MedicoDAO.class.newInstance(); break;
			case 3: operacaoDAO = AdministradorDAO.class.newInstance(); break;
			default: throw new TipoUsuarioInvalidoException();
		}
		
		BloqueioDeConta bloqueioConta = new BloqueioDeConta();
		bloqueioConta.instrucoesBloqueio();
		bloqueioConta.iniciarContagem();
		do {
			TelaLogin telaLogin = new TelaLogin(tipoUsuario);

			while (!telaLogin.getBotaoAcionado()) {
				Thread.sleep(350);
				if(!telaLogin.isActive()
					&& telaLogin.getCampoLogin().getText().equals(new TextField().getText())
					&& telaLogin.getCampoSenha().getText().equals(new JPasswordField().getText()))
					{
					//exception e interrupção na thread
					//quando o usuário não informa login e senha
					try {
						bloqueioConta.getTTempoLimite().interrupt();
						throw new LoginCamposNulosException();
					}catch(LoginCamposNulosException e) {
						e.printStackTrace();
						System.exit(0);
					}
				}	
			}

			try {
				usuarioLogando = ((OperacoesDAO<Pessoa>) operacaoDAO).findById(
						telaLogin.getCampoLogin().getText());
				
				if (usuarioLogando.getPk().equals(telaLogin.getCampoLogin().getText())
						&& usuarioLogando.getSenha().equals(
								telaLogin.getCampoSenha().getText())
						&& !bloqueioConta.getTContaBloqueio().isControle()) {
					
					bloqueioConta.getTTempoLimite().interrupt();
					JOptionPane.showMessageDialog(null, "Logado!");
					break;

				}else 
					erroLogin(bloqueioConta,"Dados Inválidos");
					
			} catch (ObjetoNaoEncontradoException e) {
				erroLogin(bloqueioConta,"Conta não cadastrada");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} while (true);
		
		return usuarioLogando;
	}
	
	public static void processoCadastroPaciente() throws InterruptedException {
		
		Paciente paciente = new Paciente();
		TelaCadastro telaCadastro = new TelaCadastro(paciente);
		
		while (!telaCadastro.getBotaoAcionado()) {
			Thread.sleep(350);
		}
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
