package model;

import classes.Pessoa;
import ubs.enums.AreaMedico;

public class Medico extends Pessoa {
	private AreaMedico especializacao;
	private String crm;

	public AreaMedico getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(AreaMedico especializacao) {
		this.especializacao = especializacao;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
}
