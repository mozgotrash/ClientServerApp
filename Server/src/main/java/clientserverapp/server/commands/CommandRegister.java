package clientserverapp.server.commands;

import clientserverapp.server.commands.commands.Command;

public interface CommandRegister {

	void register(Class<? extends Command> clazz, String... commandAliases);

	Command createCommand(String commandName);
	
	void clear();

}