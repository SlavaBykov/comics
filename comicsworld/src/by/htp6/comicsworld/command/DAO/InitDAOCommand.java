package by.htp6.comicsworld.command.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp6.comicsworld.command.Command;
import by.htp6.comicsworld.command.exception.CommandNotFoundException;

public class InitDAOCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
			throws CommandNotFoundException {
		ServiseFactory factory = ServiseFactory.getInstanse();
		InitDAOServise initDAO = factory.getInitService();
		try{
			initDAO.DAOSourceInit();
		}catch(DAOException e){
			
		}
		return null;
	}
	

}
