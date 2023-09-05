package ubs.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import com.sun.mail.handlers.message_rfc822;

public class EnviaEmail {
	private String userName = "renanjavaotp@gmail.com";
	private String password = "viwzfnlaibdmoqay\r\n" + 
			"";
	private String destino;
	private String chave;
	String textoEmail = "O Código de confirmação do"
			+ " cadastro no aplicativo da UBS é: ";
	
	public EnviaEmail(String destino) {
		this.destino = destino;
	}
	
	public void setChave(String chave){
		this.chave = chave;
	}

	public void ProcessoEmail() throws MessagingException, UnsupportedEncodingException {
		Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session sess = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});

		
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		 stringBuilderTextoEmail.append("<h1>Olá Paciente</h1> <br/><br/>");
		  stringBuilderTextoEmail.append("Você está recenbendo um email com o <b>Código de Confirmação</b><br/>");
		  stringBuilderTextoEmail.append("<br/><br/><br/><br/>");
		  
		Address[] toUser = InternetAddress.parse(destino);
		Message mensagem = new MimeMessage(sess);
		mensagem.setFrom(new InternetAddress(userName, "UBS - Unidade Básica de Saúde"));
		mensagem.setRecipients(Message.RecipientType.TO, toUser);
		mensagem.setSubject("Código de confirmação");
		mensagem.setText(stringBuilderTextoEmail+textoEmail+chave);

		javax.mail.Transport.send(mensagem);
	}
}

