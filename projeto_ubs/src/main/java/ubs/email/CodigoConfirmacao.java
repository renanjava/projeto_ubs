package ubs.email;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import com.sun.jdi.connect.Transport;


public class CodigoConfirmacao{
	
	public CodigoConfirmacao(String emailUsuario) throws InterruptedException{
		
		
			System.out.println("Sucesso! "+emailUsuario);
			EnviaEmail enviarEmail = new EnviaEmail(emailUsuario);
		
			String inputUsuario = null;
			String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			StringBuilder chaveAcesso = new StringBuilder();

			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				int indice = random.nextInt(caracteres.length());
				chaveAcesso.append(caracteres.charAt(indice));
			}
			enviarEmail.setChave(chaveAcesso.toString());
			try {
				enviarEmail.ProcessoEmail();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			Thread.sleep(5000);
			JOptionPane.showMessageDialog(null, "Email enviado com sucesso!");
			System.out.println("CodigoConfirmacao: "+chaveAcesso);
			
			do {
				if(inputUsuario != null)
					JOptionPane.showMessageDialog(null, "Código inválido");
				inputUsuario = JOptionPane.showInputDialog("Informe o código recebido pelo email");
			}while(!(inputUsuario.equals(chaveAcesso.toString())));
			
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso! "
					+ "Clique aqui para logar-se");
			
		}
		
	}
