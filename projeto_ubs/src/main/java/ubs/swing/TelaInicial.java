package ubs.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JPanel;
import javax.swing.JTextArea;

import classes.Pessoa;
import model.Medico;
import model.Paciente;
import sun.tools.jconsole.inspector.Utils.EditFocusAdapter;

public class TelaInicial extends JDialog {
	private JFrame frame = new JFrame();
	private JPanel telaInicial = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private Pessoa usuario;

	public TelaInicial(Pessoa usuario) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setTitle("UBS - Unidade Básica de Saúde");
		frame.setLocationRelativeTo(null);
		setResizable(false);

		this.usuario = usuario;

		List<JButton> listaDeBotoesUsuario = usuario.interagirBotoes();
		for (JButton botao : listaDeBotoesUsuario) {
			comportamentosBotoes(botao);
			telaInicial.add(botao);
		}

		frame.add(telaInicial);
		frame.setVisible(true);
	}

	public void comportamentosBotoes(JButton botao) {
		switch (botao.getText()) {
		case "Realizar Consulta":
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					TelaPacienteConsulta telaPacienteConsulta = new TelaPacienteConsulta((Paciente) usuario);
					
				}
			});
			break;
		case "Visualizar Consultas":
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					try {
						TelaMedicoConsulta telaMedicoConsulta = new TelaMedicoConsulta((Medico) usuario);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			break;
		case "Notificação Medicamento":
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.removeAll();
					frame.add(new JTextArea("Você tem X notificações"));
					
				}
			});
			break;
		/*
		 * case "Meus Dados": botao.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { setVisible(false); telaInicial.removeAll();
		 * telaInicial.add(new JLabel("Nome: " + usuario.getNome()));
		 * telaInicial.add(new JLabel("PK: " + usuario.getPk())); setVisible(true); }
		 * }); break; case "Editar Dados": botao.addActionListener(new ActionListener()
		 * { public void actionPerformed(ActionEvent e) {
		 * 
		 * setVisible(false); telaInicial.removeAll();
		 * 
		 * JLabel emailAtualTitulo = new JLabel("Email Atual"); TextField
		 * emailAtualCampo = new TextField(); emailAtualTitulo.setPreferredSize(new
		 * Dimension(230, 25)); emailAtualCampo.setPreferredSize(new Dimension(220,
		 * 25)); emailAtualCampo.setText(((Paciente)usuario).getEmail());
		 * 
		 * setTitle("UBS - Unidade Básica de Saúde"); setSize(new Dimension(255, 340));
		 * setLocationRelativeTo(null); setResizable(false);
		 * 
		 * telaInicial.add(emailAtualTitulo); telaInicial.add(emailAtualCampo);
		 * 
		 * add(telaInicial, BorderLayout.WEST); setVisible(true); } });
		 */
		}
	}
}
