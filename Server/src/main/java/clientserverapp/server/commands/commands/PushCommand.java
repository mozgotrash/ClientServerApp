package clientserverapp.server.commands.commands;

import clientserverapp.server.commands.CommandName;
import clientserverapp.server.commands.commands.Command;


@CommandName("push")
public class PushCommand  implements Command {

	@Override
	public void execute() {
		System.out.println("Push");
	}

}
