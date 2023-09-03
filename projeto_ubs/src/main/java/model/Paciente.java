package model;

import classes.Pessoa;

public class Paciente extends Pessoa {
	private String cpf;
	private int idade;
	private String email;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Paciente [cpf=" + cpf + ", idade=" + idade + ", email=" + email + ", username=" + username + ", senha="
				+ senha + ", nome=" + nome + "]";
	}
	
	
}