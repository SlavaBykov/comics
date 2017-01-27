package by.htp6.comicsworld.dao;

import by.htp6.comicsworld.bean.entity.User;
import by.htp6.comicsworld.dao.exception.DAOException;

public interface UserDAOSource {
	User addUser(User user) throws DAOException;

}
