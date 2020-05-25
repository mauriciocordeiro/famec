package br.org.mcord.famec.exception;

public class PermissionDeniedException extends Exception {

	private static final long serialVersionUID = 7574558804943775889L;
	
	public PermissionDeniedException(String errorMessage) {
		super(errorMessage);
	}
	
	public PermissionDeniedException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
