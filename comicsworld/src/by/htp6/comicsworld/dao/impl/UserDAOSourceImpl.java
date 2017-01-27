package by.htp6.comicsworld.dao.impl;

import by.htp6.comicsworld.bean.entity.User;
import by.htp6.comicsworld.dao.UserDAOSource;
import by.htp6.comicsworld.dao.exception.DAOException;
import by.htp6.comicsworld.dao.jdbc.DBConnectionPool;


public class UserDAOSourceImpl implements UserDAOSource{

	@Override
	public User addUser(User user) throws DAOException {
		DBConnectionPool pool = DBConnectionPool.getInstance();
		Connection connection;
		try{
		
		}
		return null;
	}

}
