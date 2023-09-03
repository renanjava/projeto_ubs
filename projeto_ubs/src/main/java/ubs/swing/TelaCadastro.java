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
import javax.swing.JTextField;

import dao.jdbc.UserPosDAO;
import model.Paciente;
import ubs.email.CodigoConfirmacao;

public class TelaCadastro extends JDialog {
	private JPanel telaCadastro = new JPanel(new GridBagLayout());
	private List<JLabel> descricoesCampos = new ArrayList<JLabel>();
	private List<TextField> dadosCampos = new ArrayList<TextField>();
	private JLabel tituloNome = new JLabel();
	private JLabel tituloCpf = new JLabel();
	private JLabel tituloSenha = new JLabel();
	private JLabel tituloEmail = new JLabel();
	private JLabel tituloIdade = new JLabel();
	private TextField campoNome = new TextField();
	private TextField campoCpf = new TextField();
	private TextField campoSenha = new TextField();
	private TextField campoEmail = new TextField();
	private TextField campoIdade = new TextField();
	private JButton botaoCadastrar = new JButton("Cadastrar");
	private boolean botaoAcionado = false;

	public TelaCadastro(final Paciente paciente) {

		setTitle("UBS - Unidade Básica de Saúde");
		setSize(new Dimension(255, 340));
		setLocationRelativeTo(null);
		setResizable(false);

		// acima é as configurações básicas de Nomea tela

		campoNome.setPreferredSize(new Dimension(220, 25));
		campoCpf.setPreferredSize(new Dimension(220, 25));
		campoSenha.setPreferredSize(new Dimension(220, 25));
		campoEmail.setPreferredSize(new Dimension(220, 25));
		campoIdade.setPreferredSize(new Dimension(220, 25));
		descricoesCampos.add(tituloNome);
		descricoesCampos.add(tituloCpf);
		descricoesCampos.add(tituloSenha);
		descricoesCampos.add(tituloEmail);
		descricoesCampos.add(tituloIdade);
		dadosCampos.add(campoIdade);
		dadosCampos.add(campoEmail);
		dadosCampos.add(campoSenha);
		dadosCampos.add(campoCpf);
		dadosCampos.add(campoNome);
		telaCadastro.add(new JLabel("Cadastro de usuário"));

		GridBagConstraints coordenadas = new GridBagConstraints();
		coordenadas.gridx = 0;
		coordenadas.gridy = 2;
		String titulos[] = { "Informe o nome", "Informe o CPF", "Infome a senha", "Informe o Email",
				"Informe a idade" };
		int i = 0;

		for (JLabel descricoes : descricoesCampos) {
			descricoes.setText(titulos[i]);
			descricoes.setPreferredSize(new Dimension(230, 25));
			telaCadastro.add(descricoes, coordenadas);
			coordenadas.gridy += 4;
			i++;
		}
		telaCadastro.add(botaoCadastrar, coordenadas);
		coordenadas.gridy -= 2;
		for (TextField campos : dadosCampos) {
			telaCadastro.add(campos, coordenadas);
			coordenadas.gridy -= 4;
		}

		add(telaCadastro, BorderLayout.WEST);
		setVisible(true);

		botaoCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				paciente.setNome(campoNome.getText());
				paciente.setCpf(campoCpf.getText());
				paciente.setSenha(campoSenha.getText());
				paciente.setEmail(campoEmail.getText());
				paciente.setIdade(Integer.parseInt(campoIdade.getText()));
				
				/*
				try {
					CodigoConfirmacao codigoConfirmacao = new CodigoConfirmacao(campoEmail.getText());
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				*/
				
				UserPosDAO userPosDAO = new UserPosDAO();
				userPosDAO.salvar(paciente);
				TelaCadastro.this.dispose();
				botaoAcionado = true;
			}
		});
	}
	public boolean getBotaoAcionado() {
		return botaoAcionado;
	}
}
