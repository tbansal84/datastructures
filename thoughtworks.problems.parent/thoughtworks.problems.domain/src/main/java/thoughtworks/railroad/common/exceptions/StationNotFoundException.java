package thoughtworks.railroad.common.exceptions;
/**
 * 
 * Exception class to report non existent station 
 * @author tbansal
 *
 */
public class StationNotFoundException extends Exception {

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
