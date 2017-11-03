package clientserverapp.server.commands.commands;

import clientserverapp.server.commands.CommandName;
import clientserverapp.server.commands.commands.Command;

@CommandName("null")
public class NullCommand implements Command {

	@Override
	public void execute() {
		System.out.println("Такой команды не существует");
		
	}

}
