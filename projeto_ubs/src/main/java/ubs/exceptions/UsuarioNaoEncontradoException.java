package ubs.exceptions;

public class UsuarioNaoEncontradoException extends Exception{

	public UsuarioNaoEncontradoException() {
		super("O usuário não foi encontrado");
	}
}
