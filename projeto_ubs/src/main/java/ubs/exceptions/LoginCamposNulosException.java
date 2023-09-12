package ubs.exceptions;

public class LoginCamposNulosException extends Exception{
	
	public LoginCamposNulosException() {
		super("Os campos login e senha estão em branco");
	}
}
