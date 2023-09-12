package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import classes.Pessoa;
import ubs.enums.AreaMedico;

public class Medico extends Pessoa {
	private AreaMedico especializacao;
	private String crm;
	
	public List<JButton> interagirBotoes() {
		JButton visualizarConsultas = new JButton("Visualizar Consultas");
		JButton criarReceita = new JButton("Criar Receita");
		JButton iniciarExame = new JButton("Iniciar Exame");
		
		List<JButton> listaBotoes = new ArrayList<JButton>();
		listaBotoes.addAll(List.of(
				criarReceita, iniciarExame,
				visualizarConsultas
				));
		return listaBotoes;
	}
	
	public void setPk(String crm) {
		this.crm = crm;
	}
	
	public String getPk() {
		return crm;
	}

	public AreaMedico getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(AreaMedico especializacao) {
		this.especializacao = especializacao;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
}
