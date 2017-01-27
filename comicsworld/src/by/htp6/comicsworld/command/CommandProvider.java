package by.htp6.comicsworld.command;

import java.util.HashMap;
import java.util.Map;

import by.htp6.comicsworld.command.exception.CommandNotFoundException;
import by.htp6.comicsworld.command.user.RegistrationUserCommand;

public class CommandProvider {

	private Map<String, Command> commands = new HashMap<String, Command>();
	private static CommandProvider instance;

	/* ВОЗМОЖНО МОДИФИКАТОР БУДЕТ public */
	private CommandProvider() {
		commands.put("REGISTRATION", new RegistrationUserCommand());
		commands.put("LOGINIZATION", new LoginizationUserCommand());
	}

	public Command getCommand(String commandName) throws CommandNotFoundException {
		Command command = commands.get(commandName);
		if (command != null) {
			return command;
		} else {
			throw new CommandNotFoundException();
		}
	}

	public static CommandProvider getInstance() {
		if (instance == null) {
			instance = new CommandProvider();
		}
		return instance;
	}
}
