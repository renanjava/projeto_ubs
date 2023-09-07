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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import dao.jdbc.PacienteDAO;
import model.Paciente;

public class TelaLogin extends JDialog {
	private JPanel telaLogin = new JPanel(new GridBagLayout());
	private JLabel tituloLogin = new JLabel("CPF");
	private JLabel tituloSenha = new JLabel("Senha");
	private TextField campoCpf = new TextField();
	private JPasswordField campoSenha = new JPasswordField();
	private JButton botaoCadastrar = new JButton("Logar");
	private boolean botaoAcionado = false;
	private GridBagConstraints coordenadas = new GridBagConstraints();

	public TelaLogin() {
		setTitle("UBS - Unidade Básica de Saúde");
		setSize(190, 140);
		setLocationRelativeTo(null);
		setResizable(false);

		
		coordenadas.gridx = 1;
		telaLogin.add(new JLabel("Acesso de usuário"),coordenadas);
		tituloLogin.setBounds(20, 50, 120, 20);
		tituloSenha.setBounds(20, 100, 120, 20);
		campoCpf.setPreferredSize(new Dimension(120, 22));
		campoSenha.setPreferredSize(new Dimension(120, 22));

		coordenadas.gridx = 0;
		coordenadas.gridy = 2;
		telaLogin.add(tituloLogin,coordenadas);
		coordenadas.gridx++;
		telaLogin.add(campoCpf,coordenadas);
		coordenadas.gridx = 0;
		coordenadas.gridy += 4;
		telaLogin.add(tituloSenha,coordenadas);
		coordenadas.gridx++;
		telaLogin.add(campoSenha,coordenadas);
		coordenadas.gridx = 1;
		coordenadas.gridy += 4;
		telaLogin.add(botaoCadastrar,coordenadas);

		add(telaLogin, BorderLayout.WEST);
		setVisible(true);

		botaoCadastrar.addActionListener(new ActionListener() {
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
	
	public TextField getCampoCpf() {
		return campoCpf;
	}
	
	public JPasswordField getCampoSenha() {
		return campoSenha;
	}
	
	public boolean getBotaoAcionado() {
		return botaoAcionado;
	}
}
