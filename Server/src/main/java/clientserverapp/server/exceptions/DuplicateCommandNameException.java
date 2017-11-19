package clientserverapp.server.exceptions;

public class DuplicateCommandNameException extends RuntimeException {

	public DuplicateCommandNameException(String commandName) {
		super("Duplicate command: " + commandName);
	} 
	
}
