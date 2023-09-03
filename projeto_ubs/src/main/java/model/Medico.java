package model;

import classes.Pessoa;
import ubs.enums.AreaMedico;

public class Medico extends Pessoa{
	private AreaMedico especializacao;
	private String crm;
	
	public Medico(String username, String senha, String nome, 
			String crm, AreaMedico especializacao){
		this.username = username;
		this.senha = senha;
		this.nome = nome;
		this.crm = crm;
		this.especializacao = especializacao;
	}
}
