package ubs.enums;

public enum TipoMedicamento {
	
	NAO_PODE_RECEITAR("NÃO PODE RECEITAR",0),
	ANALGESICO("ANALGESICO",1),
	ANTIINFLAMATORIO("ANTIINFLAMATORIO",2),
	ANTIBIOTICO("ANTIBIOTICO",3),
	ANTIVIRAL("ANTIVIRAL",4),
	ANTIFUNGICO("ANTIFUNGICO",5),
	ANTIDEPRESSIVO("ANTIDEPRESSIVO",6),
	ANSIOLITICO("ANSIOLITICO",7),
	ANTIPSICOTICO("ANTIPSICOTICO",8),
	ANTICONVULSIVANTE("ANTICONVULSIVANTE",9),
	ANTICOAGULANTE("ANTICOAGULANTE",10),
	ANTIHISTAMINICO("ANTIHISTAMINICO",11);
	
	private String nome;
	private int disponivelParaMedico;
	
	TipoMedicamento(String nome, int disponivelParaMedico) {
		this.nome = nome;
		this.disponivelParaMedico = disponivelParaMedico;
	}
	
	public String getNomeCategoria() {
		return nome;
	}
	
	public int getDispMedico(){
		return disponivelParaMedico;
	}
}
