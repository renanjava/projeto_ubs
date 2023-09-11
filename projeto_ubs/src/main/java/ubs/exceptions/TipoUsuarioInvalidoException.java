package ubs.exceptions;

public class TipoUsuarioInvalidoException extends Exception {
	
	public TipoUsuarioInvalidoException() {
		super("O tipo de usuário informado é inválido");
	}
}
