package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import classes.Pessoa;

public class Paciente extends Pessoa {
	private String cpf;
	private int idade;
	private String email;
	
	public List<JButton> interagirBotoes() {
		//JButton meusDados = new JButton("Meus Dados");
		//JButton editarDados = new JButton("Editar Dados");
		JButton notificaMedicamento = new JButton("Notificação Medicamento");
		JButton realizarConsulta = new JButton("Realizar Consulta");
		
		List<JButton> listaBotoes = new ArrayList<JButton>();
		listaBotoes.addAll(List.of(
				//meusDados, editarDados,
				realizarConsulta, notificaMedicamento
				));
		return listaBotoes;
	}
	public void setPk(String cpf) {
		this.cpf = cpf;
	}
	public String getPk() {
		return cpf;
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
		return "Paciente [cpf=" + cpf + ", idade=" + idade + ", email=" + email + ", senha="
				+ senha + ", nome=" + nome + "]";
	}
	
	
}