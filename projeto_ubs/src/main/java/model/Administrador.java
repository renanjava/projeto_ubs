package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import classes.Pessoa;

public class Administrador extends Pessoa{
	
	private String id;
	private String dataInicialAdm;
	
	public List<JButton> interagirBotoes() {
		//cadastrar médico
		//excluir medico
		//excluir paciente
		//atualizar os medicamentos
		List<JButton> listaBotoes = new ArrayList<JButton>();
		return listaBotoes;
	}
	
	public void setPk(String id) {
		this.id = id;
	}
	
	public String getPk() {
		return id;
	}

	public String getDataInicialAdm() {
		return dataInicialAdm;
	}

	public void setDataInicialAdm(String dataInicialAdm) {
		this.dataInicialAdm = dataInicialAdm;
	}
}
