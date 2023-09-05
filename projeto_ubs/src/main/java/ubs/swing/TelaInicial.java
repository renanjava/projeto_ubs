package ubs.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Paciente;

public class TelaInicial extends JDialog{
	private JPanel telaInicial = new JPanel(new GridBagLayout());
	private JButton editarDados = new JButton("Editar Dados");
	private JButton dadosUsuario = new JButton("Meus Dados");
	GridBagConstraints coordenadas = new GridBagConstraints();
	private Paciente usuario;
	private JLabel apresentacao;
	
	public TelaInicial(final Paciente usuario){
		setTitle("UBS - Unidade Básica de Saúde");
		setSize(new Dimension(110,180));
		setLocationRelativeTo(null);
		setResizable(false);
		
		this.usuario = usuario;
		apresentacao = new JLabel("Bem-vindo(a) "+usuario.getNome());
		
		coordenadas.gridx = 0;
		coordenadas.gridy = 0;
		
		telaInicial.add(apresentacao,somarY());
		telaInicial.add(dadosUsuario,somarY());
		
		add(telaInicial, BorderLayout.WEST);
		setVisible(true);
	
	dadosUsuario.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			telaInicial.add(new JLabel("Nome: "+usuario.getNome()),somarY());
			telaInicial.add(new JLabel("Idade: "+usuario.getIdade()),somarY());
			telaInicial.add(new JLabel("Email: "+usuario.getEmail()),somarY());
			telaInicial.add(new JLabel("CPF: "+usuario.getCpf()),somarY());
			telaInicial.add(editarDados,somarY());
			setVisible(true);
		}
	});
	
	editarDados.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			setVisible(false);
			//remove();
			
			JLabel emailAtualTitulo = new JLabel("Email Atual");
			TextField emailAtualCampo = new TextField();
			emailAtualTitulo.setPreferredSize(new Dimension(230, 25));
			emailAtualCampo.setPreferredSize(new Dimension(220, 25));
			emailAtualCampo.setText(usuario.getEmail());
			
			setTitle("UBS - Unidade Básica de Saúde");
			setSize(new Dimension(255, 340));
			setLocationRelativeTo(null);
			setResizable(false);
			
			coordenadas.gridx = 0;
			coordenadas.gridy = 0;
			
			telaInicial.add(emailAtualTitulo,coordenadas);
			telaInicial.add(emailAtualCampo,coordenadas);
			
			add(telaInicial, BorderLayout.WEST);
			setVisible(true);
		}
	});
	}
	public GridBagConstraints somarY() {
		coordenadas.gridy += 1;
		return coordenadas;
	}
}
