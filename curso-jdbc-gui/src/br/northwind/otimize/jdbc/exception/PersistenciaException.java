package br.northwind.otimize.jdbc.exception;

public class PersistenciaException extends Exception {

	private static final long serialVersionUID = 1L;

	public PersistenciaException(String msg, Exception exception) {
		super(msg, exception);
	}
	
	public PersistenciaException(String msg) {
		super(msg);
	}

}
