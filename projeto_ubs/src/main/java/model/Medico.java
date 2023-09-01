package model;

import classes.Pessoa;
import ubs.enums.AreaMedico;

public class Medico extends Pessoa{
	private AreaMedico especializacao;
	private String crm;
	
	public Medico(String username, String password, String nome, 
			String crm, AreaMedico especializacao){
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.crm = crm;
		this.especializacao = especializacao;
	}
}
