package by.htp6.comicsworld.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp6.comicsworld.command.Command;
import by.htp6.comicsworld.command.CommandProvider;
import by.htp6.comicsworld.command.exception.CommandNotFoundException;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void proccesRequest(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException{
    	CommandProvider provider = CommandProvider.getInstance();
    	String page = null;
    	Command command = null;
    	String commandName = request.getParameter("command");
    	
    	try{
    		command = provider.getCommand(commandName);
    		page = command.execute(request, response);
    	} catch(CommandNotFoundException e){
    		e.printStackTrace();
    	}
    	
    	if(page == null){
    		page = PageName.INDEX_PAGE;
    	}
    	request.getRequestDispatcher(page).forward(request, response);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proccesRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proccesRequest(request, response);
	}

}
