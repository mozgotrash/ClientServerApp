package clientserverapp.server.commands;

import clientserverapp.server.commands.CommandRegister;
import clientserverapp.server.commands.MapCommandRegister;
import clientserverapp.server.commands.commands.Command;
import clientserverapp.server.exceptions.IllegalNameCommandException;


public class CommandParser {
	/*
	public final static String CLEAR = "clear";
	public final static String ALERT = "alert";
	public final static String PUSH = "push";
	*/
	
	
	
	public static Command parseCommand (String commandName) throws IllegalNameCommandException{
		
		CommandRegister cr =  MapCommandRegister.getInstance();
		
		return cr.createCommand(commandName);
		
	}
}
