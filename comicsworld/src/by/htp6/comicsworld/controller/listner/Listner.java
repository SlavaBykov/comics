package by.htp6.comicsworld.controller.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.htp6.comicsworld.command.Command;
import by.htp6.comicsworld.command.CommandProvider;
import by.htp6.comicsworld.command.exception.CommandNotFoundException;

public class Listner implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent cse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		CommandProvider provider = CommandProvider.getInstance();
		String statusDAO = null;
		try{
			Command command = provider.getCommand("dao_init");
			statusDAO = command.execute(null, null);
		}catch(CommandNotFoundException e){
			e.printStackTrace();
			statusDAO = "Listner hasn't work";
		}
		
	}

}
