package by.htp6.comicsworld.command.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp6.comicsworld.command.Command;
import by.htp6.comicsworld.command.exception.CommandNotFoundException;
import by.htp6.comicsworld.dao.exception.DAOException;
import by.htp6.comicsworld.service.DAOService;
import by.htp6.comicsworld.service.ServiceFactory;
import by.htp6.comicsworld.service.exception.ServiceException;

public class InitDAOCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
			throws CommandNotFoundException {
		ServiceFactory factory = ServiceFactory.getInstance();
		String status;
		DAOService initDAO = factory.getDao();
		try{
			initDAO.initDAO();
			status = "DAO has init";
		}catch(ServiceException e){
			e.printStackTrace();
			status = "DAO hasn't init";
		}
		return status;
	}
	

}
