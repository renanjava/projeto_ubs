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

import classes.Pessoa;
import model.Paciente;

public class TelaInicial extends JDialog {
	private JPanel telaInicial = new JPanel(new GridBagLayout());
	GridBagConstraints coordenadas = new GridBagConstraints();
	private Pessoa usuario;
	private JLabel apresentacao;

	public TelaInicial(Pessoa usuario) {
		
		setTitle("UBS - Unidade Básica de Saúde");
		setSize(new Dimension(110, 180));
		setLocationRelativeTo(null);
		setResizable(false);

		this.usuario = usuario;
		telaInicial.add(new JLabel("Bem-vindo(a) " + usuario.getNome()));
		
		coordenadas.gridx = 0;
		coordenadas.gridy = 0;
		
		List<JButton> listaDeBotoesUsuario = usuario.interagirBotoes();
		for (JButton botao : listaDeBotoesUsuario) {
			comportamentosBotoes(botao);
			telaInicial.add(botao, somarY());
		}

		add(telaInicial, BorderLayout.WEST);
		setVisible(true);
	}

	public GridBagConstraints somarY() {
		coordenadas.gridy += 1;
		return coordenadas;
	}

	public void comportamentosBotoes(JButton botao) {
		switch (botao.getText()) {
		case "Meus Dados":
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					telaInicial.add(new JLabel("Nome: " + usuario.getNome()), somarY());
					telaInicial.add(new JLabel("PK: " + usuario.getPk()), somarY());
					setVisible(true);
				}
			});
			break;
		case "Editar Dados":
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					setVisible(false);
					// remove();

					JLabel emailAtualTitulo = new JLabel("Email Atual");
					TextField emailAtualCampo = new TextField();
					emailAtualTitulo.setPreferredSize(new Dimension(230, 25));
					emailAtualCampo.setPreferredSize(new Dimension(220, 25));
					// emailAtualCampo.setText(usuario.getEmail());

					setTitle("UBS - Unidade Básica de Saúde");
					setSize(new Dimension(255, 340));
					setLocationRelativeTo(null);
					setResizable(false);

					coordenadas.gridx = 0;
					coordenadas.gridy = 0;

					telaInicial.add(emailAtualTitulo, somarY());
					telaInicial.add(emailAtualCampo, somarY());

					add(telaInicial, BorderLayout.WEST);
					setVisible(true);
				}
			});
		}
	}
}
