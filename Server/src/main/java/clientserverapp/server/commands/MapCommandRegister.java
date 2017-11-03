package clientserverapp.server.commands;

import java.lang.reflect.Constructor; 
import java.util.HashMap;
import java.util.Map;

import clientserverapp.server.commands.commands.Command;
import clientserverapp.server.exceptions.DuplicateCommandNameException;
import clientserverapp.server.exceptions.IllegalNameCommandException;

public class MapCommandRegister implements CommandRegister {
	
	
	private Map<String, Class<? extends Command>> commands;

	private static final CommandRegister commandRegister = new MapCommandRegister();
	
	public static CommandRegister getInstance() {
		//if(commandRegister == null) {
		//	commandRegister = new CommandRegister();
		//}
		
		return commandRegister;
	}
	
	private MapCommandRegister() {
		super();
		commands = new HashMap<>();
	}
	
	/* (non-Javadoc)
	 * @see command.CommandRegister#register(java.lang.Class, java.lang.String)
	 */
	@Override
	public void register(final Class<? extends Command> clazz, final String... commandAliases) {
		for(String name: commandAliases) {
			final String lowerCaseCommandName = name.toLowerCase();
			
			if(commands.containsKey(lowerCaseCommandName)) {
				throw new DuplicateCommandNameException(name);
			}
					
			commands.put(lowerCaseCommandName, clazz);
		}	
	}
	
	
	/* (non-Javadoc)
	 * @see command.CommandRegister#createCommand(java.lang.String)
	 */
	@Override
	public Command createCommand(final String commandName) {
		final String lowerCaseCommandName = commandName.toLowerCase();
		
		Class<? extends Command> clazz = commands.get(lowerCaseCommandName);
		
		if(clazz == null) {
			throw new IllegalNameCommandException(commandName);
		}
		
		Command command = null;
		
		try {
			Constructor<? extends Command> ctor = clazz.getConstructor(); clazz.getFields()
			command = ctor.newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return command;
	}

	public Map<String, Class<? extends Command>> getMap(){
		return commands;
	}
	
	@Override
	public void clear() {
		commands.clear();
		
	}

}
