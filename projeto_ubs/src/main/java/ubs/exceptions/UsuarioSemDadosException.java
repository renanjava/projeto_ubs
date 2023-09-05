package ubs.exceptions;

public class UsuarioSemDadosException extends Exception{
	
	public UsuarioSemDadosException() {
		super("O usuário informado não tem dados");
	}
}
