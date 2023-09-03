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
	private JLabel tituloLogin = new JLabel();
	private JLabel tituloSenha = new JLabel();
	private TextField nomeUsuario = new TextField();
	private TextField loginUsuario = new TextField();
	private TextField senhaUsuario = new TextField();
	private JButton botaoSalvar = new JButton("Salvar");

	public TelaCadastro(final Paciente paciente, final int pagina) {
		
		setTitle("UBS - Unidade Básica de Saúde");
		setSize(new Dimension(255, 250));
		setLocationRelativeTo(null);
		setResizable(false);

		// acima é as configurações básicas de uma tela

		nomeUsuario.setPreferredSize(new Dimension(220, 25));
		loginUsuario.setPreferredSize(new Dimension(220, 25));
		senhaUsuario.setPreferredSize(new Dimension(220, 25));
		descricoesCampos.add(tituloNome);
		descricoesCampos.add(tituloLogin);
		descricoesCampos.add(tituloSenha);
		dadosCampos.add(nomeUsuario);
		dadosCampos.add(loginUsuario);
		dadosCampos.add(senhaUsuario);
		// customizar a janela JPanel
		telaCadastro.add(new JLabel("Cadastro de usuário"));

		GridBagConstraints coordenadas = new GridBagConstraints();
		coordenadas.gridx = 0;
		coordenadas.gridy = 2;
		final String titulos[] = paginaTela(pagina);
		int i = 0;

		for (JLabel descricoes : descricoesCampos) {
			descricoes.setText(titulos[i]);
			descricoes.setPreferredSize(new Dimension(230, 25));
			telaCadastro.add(descricoes, coordenadas);
			coordenadas.gridy += 4;
			i++;
		}
		telaCadastro.add(botaoSalvar, coordenadas);
		coordenadas.gridy -= 2;
		for (TextField campos : dadosCampos) {
			telaCadastro.add(campos, coordenadas);
			coordenadas.gridy -= 4;
		}

		add(telaCadastro, BorderLayout.WEST);
		setVisible(true);

		botaoSalvar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
				
				System.out.println(paciente);

				if (pagina == 1){

					paciente.setNome(nomeUsuario.getText());
					paciente.setUsername(loginUsuario.getText());
					paciente.setSenha(senhaUsuario.getText());
					
					TelaCadastro.this.dispose();
					TelaCadastro telaPaginaDois = new TelaCadastro(paciente,2);
				} else {
					
					paciente.setCpf(nomeUsuario.getText());
					paciente.setEmail(loginUsuario.getText());
					paciente.setIdade(4000);

					try {
						CodigoConfirmacao codigoConfirmacao = new CodigoConfirmacao(loginUsuario.getText());
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					UserPosDAO userPosDAO = new UserPosDAO();
					userPosDAO.salvar(paciente);
					TelaCadastro.this.dispose();
				}
			}
		});
	}

	private String[] paginaTela(int pagina) {
		String[] titulos1 = { "Informe o nome", "Informe o login", "Informe a senha" };
		String[] titulos2 = { "Informe o CPF", "Informe o email", "Informe a idade" };
		if (pagina == 1)
			return titulos1;
		else
			return titulos2;
	}
}
