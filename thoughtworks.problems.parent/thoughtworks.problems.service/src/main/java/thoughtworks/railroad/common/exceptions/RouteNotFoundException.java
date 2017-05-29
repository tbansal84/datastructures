package thoughtworks.railroad.common.exceptions;

public class RouteNotFoundException extends Exception {

	public RouteNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public RouteNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RouteNotFoundException(String source, String destination) {
		super(String.format("Source %1s , Destinations %2s", source, destination));
	}

	public RouteNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public RouteNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RouteNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
