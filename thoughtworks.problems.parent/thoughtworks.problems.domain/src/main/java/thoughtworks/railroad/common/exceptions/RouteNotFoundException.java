package thoughtworks.railroad.common.exceptions;

/**
 * 
 * Exception class to report issues with train route
 * @author tbansal
 *
 */
public class RouteNotFoundException extends Exception {

	public RouteNotFoundException() {
	}

	public RouteNotFoundException(String message) {
		super(message);
	}

	public RouteNotFoundException(String source, String destination) {
		super(String.format("Source %1s , Destinations %2s", source, destination));
	}

	public RouteNotFoundException(Throwable cause) {
		super(cause);
	}

	public RouteNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RouteNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
