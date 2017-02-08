package by.htp6.comicsworld.command;

import java.util.HashMap;
import java.util.Map;

import by.htp6.comicsworld.command.DAO.InitDAOCommand;
import by.htp6.comicsworld.command.exception.CommandNotFoundException;
import by.htp6.comicsworld.command.user.LogOut;
import by.htp6.comicsworld.command.user.SignUp;

public class CommandProvider {

	private Map<String, Command> commands = new HashMap<String, Command>();
	private static CommandProvider instance;

	/* ВОЗМОЖНО МОДИФИКАТОР БУДЕТ public */
	public CommandProvider() {
		//User's commands
		commands.put("SIGNUP", new SignUp());
		commands.put("LOGOUT", new LogOut());
		
		//Listnre's commands
		commands.put("dao_init", new InitDAOCommand());
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
