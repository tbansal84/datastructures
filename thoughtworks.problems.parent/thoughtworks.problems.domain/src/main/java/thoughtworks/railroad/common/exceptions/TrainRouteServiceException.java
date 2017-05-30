package thoughtworks.railroad.common.exceptions;

/**
 * 
 * Exception class to report service exceptions
 * 
 * @author tbansal
 *
 */
public class TrainRouteServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TrainRouteServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainRouteServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TrainRouteServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TrainRouteServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TrainRouteServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
