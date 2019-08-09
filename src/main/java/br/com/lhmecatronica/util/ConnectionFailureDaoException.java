package br.com.lhmecatronica.util;

public class ConnectionFailureDaoException extends RuntimeException {

	private static final long serialVersionUID = 1006254208435585760L;

	public ConnectionFailureDaoException() {
		super();
	}

	public ConnectionFailureDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnectionFailureDaoException(String message) {
		super(message);
	}

	public ConnectionFailureDaoException(Throwable cause) {
		super(cause);
	}

}
