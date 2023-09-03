package model;

import classes.Pessoa;

public class Administrador extends Pessoa{
	
	public Administrador(String cpf, String senha, 
			String nome){
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
	}
}
