package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import classes.Pessoa;

public class Administrador extends Pessoa{
	
	private String id;
	private String dataInicialAdm;
	
	public List<JButton> interagirBotoes() {
		JButton cadastrarMedico = new JButton("Cadastrar Médico");
		JButton excluirMedico = new JButton("Excluir Médico");
		JButton excluirPaciente = new JButton("Excluir Paciente");
		JButton atualizarMedicamentos = new JButton("Atualizar Medicamentos");
		
		List<JButton> listaBotoes = new ArrayList<JButton>();
		listaBotoes.addAll(List.of(
				cadastrarMedico, excluirMedico,
				excluirPaciente,atualizarMedicamentos
				));
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
