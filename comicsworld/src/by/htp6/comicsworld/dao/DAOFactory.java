package by.htp6.comicsworld.dao;

import by.htp6.comicsworld.dao.impl.UserDAOSourceImpl;

public class DAOFactory {
	private static DAOFactory instance;
	private UserDAOSourceImpl userDAO = new UserDAOSourceImpl();
	
	private DAOFactory(){}
	
	public static DAOFactory getInstance(){
		if(instance == null){
			instance = new DAOFactory();
		}
		return instance;
	}

	public UserDAOSourceImpl getUserDAO() {
		return userDAO;
	}
	
	
	
	
}
