package com.tourism.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourism.service.UserService;
import com.tourism.service.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
//@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private UserService userService;
	
	public void init() {
		userService = new UserServiceImpl();
	}
	
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		try{
			switch(url){
			case "/user" :
				userService.userPage(request,response);
				break;
			case "/user/add":
				userService.appointment(request,response);
				break;
			case "/user/book":
				userService.save(request,response);
				break;
			}
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
