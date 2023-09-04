package ubs.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Paciente;

public class TelaInicial extends JDialog{
	private JPanel telaInicial = new JPanel(new GridBagLayout());
	private JButton listarMedicamentos = new JButton("VisualizarMedicamentos");
	private JButton dadosUsuario = new JButton("Meus Dados");
	
	public TelaInicial(Paciente usuario){
		setTitle("UBS - Unidade Básica de Saúde");
		setSize(new Dimension(315,140));
		setLocationRelativeTo(null);
		setResizable(false);
		
		GridBagConstraints coordenadas = new GridBagConstraints();
		coordenadas.gridx = 0;
		coordenadas.gridy = 0;
		
		telaInicial.add(new JLabel("SEUS DADOS"),coordenadas);
		coordenadas.gridy++;
		telaInicial.add(new JLabel("Nome: "+usuario.getNome()),coordenadas);
		coordenadas.gridy++;
		telaInicial.add(new JLabel("Idade: "+usuario.getIdade()),coordenadas);
		coordenadas.gridy++;
		telaInicial.add(new JLabel("Email: "+usuario.getEmail()),coordenadas);
		coordenadas.gridy++;
		telaInicial.add(new JLabel("CPF: "+usuario.getCpf()),coordenadas);
		//telaInicial.add(listarMedicamentos,coordenadas);
		//telaInicial.add(dadosUsuario,coordenadas);
		
		add(telaInicial, BorderLayout.WEST);
		setVisible(true);
	}
}
