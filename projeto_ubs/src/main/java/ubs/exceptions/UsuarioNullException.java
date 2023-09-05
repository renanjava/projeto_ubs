package ubs.exceptions;

public class UsuarioNullException extends Exception{

	public UsuarioNullException() {
		super("Usuário não encontrado");
	}
}
