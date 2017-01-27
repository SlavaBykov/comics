package by.htp6.comicsworld.service.impl;

import by.htp6.comicsworld.bean.entity.User;
import by.htp6.comicsworld.dao.DAOFactory;
import by.htp6.comicsworld.dao.UserDAOSource;
import by.htp6.comicsworld.dao.exception.DAOException;
import by.htp6.comicsworld.service.UserService;
import by.htp6.comicsworld.service.exception.ServiceException;


public class UserServiseImpl implements UserService{

	@Override
	public User registration(User regUser) throws ServiceException{
		DAOFactory factory = DAOFactory.getInstance();
		UserDAOSource dao = factory.getUserDAO();
		try{
			regUser = dao.addUser(regUser);
		} catch(DAOException e){
			e.printStackTrace();
		}
		return regUser;
	}

	@Override
	public User loginization(User logUser) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
