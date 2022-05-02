package br.com.feliciano.springangular.resources.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String string) {
		super(string);
	}

	public ObjectNotFoundException(String string, Throwable cause) {
		super(string, cause);
	}

}
