package ubs.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import dao.jdbc.PacienteDAO;
import model.Paciente;

public class TelaLogin extends JDialog {
	private JPanel telaLogin = new JPanel(new GridBagLayout());
	private JLabel tituloLogin = null;
	private JLabel tituloSenha = new JLabel("Senha");
	private TextField campoLogin = new TextField();
	private JPasswordField campoSenha = new JPasswordField();
	private JButton botaoLogar = new JButton("Logar");
	private boolean botaoAcionado = false;
	private GridBagConstraints coordenadas = new GridBagConstraints();
	private String nomeTipoUsuario;

	public TelaLogin(int tipoUsuario) {
		definirTipoUsuario(tipoUsuario);
		setTitle("UBS - Unidade Básica de Saúde");
		setSize(190, 140);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		coordenadas.gridx = 1;
		telaLogin.add(new JLabel("Acesso de "+nomeTipoUsuario),coordenadas);
		tituloLogin.setBounds(20, 50, 120, 20);
		tituloSenha.setBounds(20, 100, 120, 20);
		campoLogin.setPreferredSize(new Dimension(120, 22));
		campoSenha.setPreferredSize(new Dimension(120, 22));

		coordenadas.gridx = 0;
		coordenadas.gridy = 2;
		
		telaLogin.add(tituloLogin,coordenadas);
		coordenadas.gridx++;
		telaLogin.add(campoLogin,coordenadas);
		coordenadas.gridx = 0;
		coordenadas.gridy += 4;
		telaLogin.add(tituloSenha,coordenadas);
		coordenadas.gridx++;
		telaLogin.add(campoSenha,coordenadas);
		coordenadas.gridx = 1;
		coordenadas.gridy += 4;
		telaLogin.add(botaoLogar,coordenadas);

		add(telaLogin, BorderLayout.WEST);
		setVisible(true);

		botaoLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin.this.dispose();
				botaoAcionado = true;
			}
		});
	}

	public GridBagConstraints somarCoordenadas(GridBagConstraints coordenadas) {
		this.coordenadas.gridx = coordenadas.gridx += 1;
		return this.coordenadas;
	}
	
	public void definirTipoUsuario(int tipoUsuario) {
		
		switch(tipoUsuario) {
			case 1: 
				tituloLogin = new JLabel("CPF"); 
				nomeTipoUsuario = "Paciente";
				break;
			case 2:	
				tituloLogin = new JLabel("CRM"); 
				nomeTipoUsuario = "Médico";
				break;
			case 3:	
				tituloLogin = new JLabel("ID"); 
				nomeTipoUsuario = "Admin";
				break;
		}
	}
	
	public TextField getCampoLogin() {
		return campoLogin;
	}
	
	public JPasswordField getCampoSenha() {
		return campoSenha;
	}
	
	public boolean getBotaoAcionado() {
		return botaoAcionado;
	}
}
