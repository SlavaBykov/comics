package by.htp6.comicsworld.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.comicsworld.bean.entity.User;
import by.htp6.comicsworld.command.Command;
import by.htp6.comicsworld.command.exception.CommandNotFoundException;
import by.htp6.comicsworld.controller.PageName;
import by.htp6.comicsworld.service.ServiceFactory;
import by.htp6.comicsworld.service.UserService;
import by.htp6.comicsworld.service.exception.ServiceException;

public class SignUp implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandNotFoundException {
		User user = new User();
		String page = null;
		
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		try{
		user.setLogin(request.getParameter("login").trim());
		user.setEmail(request.getParameter("email").trim());
		user.setPassword(request.getParameter("password").trim());
		user.setConfirmPassword(request.getParameter("confirmPassword").trim());
		//Тест
		System.out.println("---------- в command---------------");
		System.out.println(request.getParameter("login"));
		
		user = userService.registration(user);
		
		
		if(user != null){
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			page = PageName.INDEX_PAGE;
		}else{
			//Add PAGE!!!
		}
		}catch(ServiceException e){
			e.printStackTrace();
		}
		
		return page;
	}

}
