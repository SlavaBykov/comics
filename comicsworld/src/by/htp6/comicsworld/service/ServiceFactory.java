package by.htp6.comicsworld.service;

import by.htp6.comicsworld.service.impl.DAOServiceImpl;
import by.htp6.comicsworld.service.impl.UserServiseImpl;

public class ServiceFactory {

	private UserService userService = new UserServiseImpl();
	private DAOService dao = new DAOServiceImpl();
	
	private static ServiceFactory instance;

	private ServiceFactory() {}

	public static ServiceFactory getInstance() {
		if (instance == null) {
			instance = new ServiceFactory();
		}
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public DAOService getDao() {
		return dao;
	}
	
	

}
