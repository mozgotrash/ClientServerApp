package clientserverapp.server.commands.commands;

import clientserverapp.server.commands.CommandName;

@CommandName("alert")
public class AlertCommand implements Command {
	
	@Override
	public void execute() {
		System.out.println("Alert");
	}

}
