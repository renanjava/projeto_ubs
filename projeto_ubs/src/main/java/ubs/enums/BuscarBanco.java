package ubs.enums;

public enum BuscarBanco {
	PACIENTE("CPF"),
	MEDICO("CRM"),
	ADMINISTRADOR("IDADMIN"),
	MEDICAMENTO("IDMEDICAMENTO");
	
	private final String chavePrimaria;
	
	BuscarBanco(String chavePrimaria){
		this.chavePrimaria = chavePrimaria;
	}
	
	public String getChavePrimaria() {
		return chavePrimaria;
	}
}
