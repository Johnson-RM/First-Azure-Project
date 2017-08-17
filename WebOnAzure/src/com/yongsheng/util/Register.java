package com.yongsheng.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.yongsheng.dao.UserImpl;

import yongsheng.com.entity.UserEntity;

public class Register {
	private ResultSet resultSet;
	private Connection connection=null;
	private UserImpl userImpl=new UserImpl();
    public Register() {
		// TODO Auto-generated constructor stub
	}
	public boolean check_register(UserEntity user) {
		connection= ConnectionFactory.getInstance().getConnection();
		try {
			connection.setAutoCommit(false);
			resultSet=userImpl.find2(connection, user);
			connection.commit();
			if(resultSet.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		    try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public void register(UserEntity user) {
		connection= (Connection) ConnectionFactory.getInstance().getConnection();
		try {
			connection.setAutoCommit(false);
			userImpl.register(connection, user);
			connection.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		    try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
