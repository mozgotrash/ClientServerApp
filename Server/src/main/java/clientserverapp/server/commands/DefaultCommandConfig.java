package clientserverapp.server.commands;

import clientserverapp.server.commands.commands.AlertCommand;
import clientserverapp.server.commands.commands.ClearCommand;
import clientserverapp.server.commands.commands.NullCommand;
import clientserverapp.server.commands.commands.PushCommand;


@RegisterCommand({
	AlertCommand.class,
	ClearCommand.class,
	PushCommand.class,
	NullCommand.class
})
public class DefaultCommandConfig implements CommandConfig{

}
