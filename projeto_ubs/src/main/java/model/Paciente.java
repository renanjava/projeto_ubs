package model;

import classes.Pessoa;

public class Paciente extends Pessoa{
	
	public Paciente(String username, String password, String nome, 
			String cpf, int idade){
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
		

}
