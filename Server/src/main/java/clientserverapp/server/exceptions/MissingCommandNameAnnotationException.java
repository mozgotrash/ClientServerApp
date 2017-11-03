package clientserverapp.server.exceptions;

public class MissingCommandNameAnnotationException extends RuntimeException{
	
	public MissingCommandNameAnnotationException(String message) {
		super(message);
	}
}
