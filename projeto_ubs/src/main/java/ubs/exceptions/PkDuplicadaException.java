package ubs.exceptions;

public class PkDuplicadaException extends Exception{
	
	public PkDuplicadaException() {
		super("A chave primária já existe");
	}
}
