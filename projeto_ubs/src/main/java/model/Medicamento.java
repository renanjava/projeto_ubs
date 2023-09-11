package model;

import ubs.enums.TipoMedicamento;

public class Medicamento {
	private String nome;
	private int quantidade;
	private TipoMedicamento categoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public TipoMedicamento getCategoria() {
		return categoria;
	}

	public void setCategoria(TipoMedicamento categoria) {
		this.categoria = categoria;
	}

}
