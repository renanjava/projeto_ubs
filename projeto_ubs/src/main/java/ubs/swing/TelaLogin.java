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
import javax.swing.JPanel;

public class TelaLogin extends JDialog{
	private JPanel telaLogin = new JPanel(new GridBagLayout());
	private JLabel tituloLogin = new JLabel("Informe o login");
	private JLabel tituloSenha = new JLabel("Informe a senha");
	private TextField loginUsuario = new TextField();
	private TextField senhaUsuario = new TextField();
	private JButton botaoSalvar = new JButton("Salvar");
	private GridBagConstraints coordenadas = new GridBagConstraints();
	
	public TelaLogin() {
		setTitle("UBS - Unidade Básica de Saúde");
		setSize(new Dimension(255, 190));
		setLocationRelativeTo(null);
		setResizable(false);
		
		telaLogin.add(new JLabel("Acesso de usuário"));
		tituloLogin.setPreferredSize(new Dimension(230,25));
		tituloSenha.setPreferredSize(new Dimension(230,25));
		loginUsuario.setPreferredSize(new Dimension(220,25));
		senhaUsuario.setPreferredSize(new Dimension(220,25));
		
		coordenadas.gridx = 0;
		coordenadas.gridy = 2;
		
		telaLogin.add(tituloLogin,somarY(coordenadas));
		telaLogin.add(loginUsuario,somarY(coordenadas));
		telaLogin.add(tituloSenha,somarY(coordenadas));
		telaLogin.add(senhaUsuario,somarY(coordenadas));
		telaLogin.add(botaoSalvar,somarY(coordenadas));
		
		add(telaLogin, BorderLayout.WEST);
		setVisible(true);
		
		botaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					TelaLogin.this.dispose();
					System.exit(0);
				}
		});
	}
	
	public GridBagConstraints somarY(GridBagConstraints coordenadas) {
		this.coordenadas.gridy = coordenadas.gridy+2;
		return this.coordenadas;
	}
}
