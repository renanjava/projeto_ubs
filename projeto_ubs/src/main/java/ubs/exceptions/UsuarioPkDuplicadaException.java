package ubs.exceptions;

public class UsuarioPkDuplicadaException extends Exception{
	
	public UsuarioPkDuplicadaException() {
		super("A chave primária do usuário já existe");
	}
}
