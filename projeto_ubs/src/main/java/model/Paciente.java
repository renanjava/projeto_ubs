package model;

import classes.Pessoa;

public class Paciente extends Pessoa{
	private String cpf;
	private int idade;
	private String email;
	
	public Paciente(String username, String password, String nome, 
			String cpf, int idade){
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
		

}