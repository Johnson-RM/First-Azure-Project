package com.yongsheng.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yongsheng.util.Check;
import com.yongsheng.util.Register;

import yongsheng.com.entity.UserEntity;

public class RegisterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3083514478311969171L;
	private UserEntity user=new UserEntity();
    private Register check=new Register();
	

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
	    Boolean boolean1=check.check_register(user);
	    if(boolean1) {
	    	req.getSession().setAttribute("flag1", "already");
	    	String forward="/01/register.jsp";
	    	RequestDispatcher rDispatcher=req.getRequestDispatcher(forward);
	    	rDispatcher.forward(req, resp);
	    	}
	    else {
	    	req.getSession().setAttribute("flag", "success_login");
	    	check.register(user);
	    	String forward="/01/hello.jsp";
	    	RequestDispatcher rDispatcher=req.getRequestDispatcher(forward);
	    	rDispatcher.forward(req, resp);
	    }
		
	}
}
