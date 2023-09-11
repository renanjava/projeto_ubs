package classes;

import java.util.List;

import javax.swing.JButton;

public abstract class Pessoa {
	protected String senha;
	protected String nome;
	
	public abstract List<JButton> interagirBotoes();
	public abstract void setPk(String pk);
	public abstract String getPk();

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
