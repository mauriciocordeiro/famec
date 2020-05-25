package br.org.mcord.famec.exception;

public class PermissionException extends Exception {

	private static final long serialVersionUID = 7574558804943775889L;
	
	public PermissionException(String errorMessage) {
		super(errorMessage);
	}
	
	public PermissionException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
