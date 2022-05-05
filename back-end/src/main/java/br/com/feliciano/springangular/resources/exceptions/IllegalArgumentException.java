package br.com.feliciano.springangular.resources.exceptions;

public class IllegalArgumentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IllegalArgumentException(String string) {
		super(string);
	}

	public IllegalArgumentException(String string, Throwable cause) {
		super(string, cause);
	}

}
