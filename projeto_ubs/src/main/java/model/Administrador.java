package model;

import classes.Pessoa;

public class Administrador extends Pessoa{
	
	public Administrador(String username, String senha, 
			String nome){
		this.username = username;
		this.senha = senha;
		this.nome = nome;
	}
}
