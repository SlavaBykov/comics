package by.htp6.comicsworld.service;

import by.htp6.comicsworld.bean.entity.User;
import by.htp6.comicsworld.service.exception.ServiceException;

public interface UserService {
	User registration(User regUser) throws ServiceException;
	User loginization(User logUser) throws ServiceException;

}
