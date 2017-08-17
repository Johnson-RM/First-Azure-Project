package com.yongsheng.util;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.yongsheng.dao.UserImpl;

import yongsheng.com.entity.UserEntity;


public class Check {
	private ResultSet resultSet;
	private Connection connection=null;
	private UserImpl userImpl=new UserImpl();
	public Check() {
	
		
	}
	public boolean check_login(UserEntity user) {
		connection=  ConnectionFactory.getInstance().getConnection();
		try {
			connection.setAutoCommit(false);
			resultSet=userImpl.find(connection, user);
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
	

}
