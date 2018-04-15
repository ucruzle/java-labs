package br.northwind.otimize.jdbc.exception;

public class NegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	public NegocioException(String msg, Exception exception) {
		super(msg, exception);
	}
	
	public NegocioException(String msg) {
		super(msg);
	}
}
