package com.yongsheng.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.catalina.util.SessionConfig;

import com.yongsheng.util.Check;

import yongsheng.com.entity.UserEntity;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private UserEntity user=new UserEntity();
    private Check check=new Check();
	private static final long serialVersionUID = -3189710993900164314L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=req.getParameter("userName");
		String passWord=req.getParameter("password");
		user.setName(userName);
		user.setPassword(passWord);
	    Boolean boolean1=check.check_login(user);
	    if(boolean1) {
	    	req.getSession().setAttribute("flag", "success_login");
	    	String forward="/01/hello.jsp";
	    	RequestDispatcher rDispatcher=req.getRequestDispatcher(forward);
	    	rDispatcher.forward(req, resp);
	    	}
	    else {
	    	req.getSession().setAttribute("flag", "error_login");
	    	String forward="/01/login.jsp";
	    	RequestDispatcher rDispatcher=req.getRequestDispatcher(forward);
	    	rDispatcher.forward(req, resp);
	    }
		
	}
	
	
	
	

}
