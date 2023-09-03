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

import dao.jdbc.UserPosDAO;
import model.Paciente;

public class TelaLogin extends JDialog {
	private JPanel telaLogin = new JPanel(new GridBagLayout());
	private JLabel tituloLogin = new JLabel("Informe o CPF");
	private JLabel tituloSenha = new JLabel("Informe a senha");
	private TextField campoCpf = new TextField();
	private TextField campoSenha = new TextField();
	private JButton botaoCadastrar = new JButton("Logar");
	private GridBagConstraints coordenadas = new GridBagConstraints();

	public TelaLogin() {
		setTitle("UBS - Unidade Básica de Saúde");
		setSize(new Dimension(255, 190));
		setLocationRelativeTo(null);
		setResizable(false);

		telaLogin.add(new JLabel("Acesso de usuário"));
		tituloLogin.setPreferredSize(new Dimension(230, 25));
		tituloSenha.setPreferredSize(new Dimension(230, 25));
		campoCpf.setPreferredSize(new Dimension(220, 25));
		campoSenha.setPreferredSize(new Dimension(220, 25));

		coordenadas.gridx = 0;
		coordenadas.gridy = 2;

		telaLogin.add(tituloLogin, somarY(coordenadas));
		telaLogin.add(campoCpf, somarY(coordenadas));
		telaLogin.add(tituloSenha, somarY(coordenadas));
		telaLogin.add(campoSenha, somarY(coordenadas));
		telaLogin.add(botaoCadastrar, somarY(coordenadas));

		add(telaLogin, BorderLayout.WEST);
		setVisible(true);

		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserPosDAO userPosDAO = new UserPosDAO();
				try {
					if(userPosDAO.buscar(campoCpf.getText(),campoSenha.getText())) 
						JOptionPane.showMessageDialog(null, "Logado!");
					else
						JOptionPane.showMessageDialog(null, "Conta inválida");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				TelaLogin.this.dispose();
			}
		});
	}

	public GridBagConstraints somarY(GridBagConstraints coordenadas) {
		this.coordenadas.gridy = coordenadas.gridy + 2;
		return this.coordenadas;
	}
}
