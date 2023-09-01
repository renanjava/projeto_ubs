package model;

import classes.Pessoa;

public class Administrador extends Pessoa{
	
	public Administrador(String username, String password, 
			String nome){
		this.username = username;
		this.password = password;
		this.nome = nome;
	}
}
