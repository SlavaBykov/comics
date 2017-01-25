package by.htp6.comicsworld.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp6.comicsworld.dao.exception.CommandNotFoundException;

public interface Command {
	
	String execute (HttpServletRequest request, HttpServletResponse response) 
			throws CommandNotFoundException;

}
