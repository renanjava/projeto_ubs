package ubs.enums;

public enum ConsultaBanco {
	PACIENTE("CPF"),
	MEDICO("CRM"),
	ADMINISTRADOR("IDADMIN"),
	MEDICAMENTO("IDMEDICAMENTO");
	
	private final String chavePrimaria;
	
	ConsultaBanco(String chavePrimaria){
		this.chavePrimaria = chavePrimaria;
	}
	
	public String getChavePrimaria() {
		return chavePrimaria;
	}
}
