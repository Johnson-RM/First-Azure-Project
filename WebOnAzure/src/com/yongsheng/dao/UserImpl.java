package com.yongsheng.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import yongsheng.com.entity.UserEntity;

public class UserImpl implements UserDao{

	@Override
	public ResultSet find(Connection connection, UserEntity user) throws SQLException {
		PreparedStatement pStatement=(PreparedStatement) connection.
				prepareCall("select* from tbl_user where name=? and password=?");
		pStatement.setString(1,user.getName());
		pStatement.setString(2,user.getPassword());
		return pStatement.executeQuery();
	}

	@Override
	public ResultSet find2(Connection connection, UserEntity user) throws SQLException {//检查该用户是否存在
		// TODO Auto-generated method stub
		PreparedStatement pStatement=(PreparedStatement) connection.
				prepareCall("select* from tbl_user where name=?");
		pStatement.setString(1,user.getName());
		return pStatement.executeQuery();
	}

	@Override
	public void register(Connection connection, UserEntity user) throws SQLException {
		// TODO Auto-generated method stub	
		PreparedStatement pStatement=(PreparedStatement) connection.
			prepareCall("insert into tbl_user(name,password) values (?,?)");
		pStatement.setString(1,user.getName());
		pStatement.setString(2,user.getPassword());
		pStatement.execute();
	}
    
	
		
	
  
}
