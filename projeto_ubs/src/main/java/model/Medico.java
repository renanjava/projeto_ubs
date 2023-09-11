package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import classes.Pessoa;
import ubs.enums.AreaMedico;

public class Medico extends Pessoa {
	private AreaMedico especializacao;
	private String crm;
	
	//realizar exames
	//criar receitas (condição para sua área)
	
	public List<JButton> interagirBotoes() {
		List<JButton> listaBotoes = new ArrayList<JButton>();
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
