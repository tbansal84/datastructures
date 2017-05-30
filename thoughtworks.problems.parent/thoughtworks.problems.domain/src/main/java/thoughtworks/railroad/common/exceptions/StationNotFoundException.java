package thoughtworks.railroad.common.exceptions;
/**
 * 
 * Exception class to report non existent station 
 * @author tbansal
 *
 */
public class StationNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3316627649763875667L;

	public StationNotFoundException() {
	}

	public StationNotFoundException(String message) {
		super(message);
	}

	public StationNotFoundException(Throwable cause) {
		super(cause);
	}

	public StationNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StationNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
