package clientserverapp.server;

import clientserverapp.server.commands.CommandConfig;
import clientserverapp.server.commands.CommandName;
import clientserverapp.server.commands.CommandRegister;
import clientserverapp.server.commands.RegisterCommand;
import clientserverapp.server.commands.commands.Command;
import clientserverapp.server.exceptions.MissingCommandNameAnnotationException;


public class DeafultCommandProcessor {
	
	private Class<? extends CommandConfig> configClass;
	
	private CommandRegister register;
	
	private DeafultCommandProcessor(Class<? extends CommandConfig> configClass, CommandRegister register) {
		this.configClass = configClass;
		this.register = register;
	}
	
	public static DeafultCommandProcessor create(Class<? extends CommandConfig> configClass, CommandRegister register) {
		return new DeafultCommandProcessor(configClass, register);
	}
	
	public Class<? extends Command>[]  getAnnot(){
		Class<? extends Command>[] commands = this.configClass
				.getAnnotation(RegisterCommand.class)
				.value();
		
		return commands;
	}
	
	public void init() {
		
		Class<? extends Command>[] commands = getAnnot();
		
		for(Class<? extends Command> clazz: commands) {			
			CommandName annotation = clazz.getAnnotation(CommandName.class);
			if(annotation == null) {
				System.out.println("Класс команды: " + clazz.getName() + "не имеет аннотаций");
				throw new MissingCommandNameAnnotationException(clazz.getName());
			}
			String[] aliases = annotation.value();		
			register.register(clazz, aliases);
		}
	}
}
