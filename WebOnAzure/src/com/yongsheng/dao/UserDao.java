package com.yongsheng.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import yongsheng.com.entity.UserEntity;

public interface UserDao {
  public ResultSet find(Connection connection,UserEntity user) throws SQLException; 
  public ResultSet find2(Connection connection,UserEntity user) throws SQLException; 
  public void register(Connection connection,UserEntity user) throws SQLException; 
  
}
