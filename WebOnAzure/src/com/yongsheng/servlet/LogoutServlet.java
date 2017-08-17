package com.yongsheng.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 990948219872410638L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 req.getSession().invalidate();
	 String forward="/01/login.jsp";
     RequestDispatcher rd=req.getRequestDispatcher(forward);
     rd.forward(req, resp);
	}
}
