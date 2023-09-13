package ubs.enums;

public enum AreaMedico {
	
	PSICOLOGO("PSICÓLOGO"),
	PSIQUIATRA("PSIQUIATRA"),
	DENTISTA("DENTISTA"),
	CIRURGIAO("CIRURGIÃO"),
	DERMATOLOGISTA("DERMATOLOGISTA");
	
	private String areaMedico;
	
	AreaMedico(String areaMedico) {
		this.areaMedico = areaMedico;
	}
	
	public String getAreaMedico() {
		return areaMedico;
	}
}
