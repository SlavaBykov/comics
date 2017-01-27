package by.htp6.comicsworld.controller.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.htp6.comicsworld.command.Command;
import by.htp6.comicsworld.command.CommandProvider;
import by.htp6.comicsworld.command.exception.CommandNotFoundException;

public class SourceListner implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		CommandProvider provider = CommandProvider.getInstance();
		String statusDAO = null;
		try{
			Command command = provider.getCommand("dao_init");
			statusDAO = command.execute(null, null);
		}catch(CommandNotFoundException e){
			e.printStackTrace();
		}
		
	}

}
