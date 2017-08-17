package com.yongsheng.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static Connection connection;
	
	static {
		Properties properties=new Properties();
		InputStream inputStream = ConnectionFactory.class.
				getClassLoader().getResourceAsStream("dbconfig.properties");
		try {
			properties.load(inputStream);
			//driver=properties.getProperty("driver");
			//System.out.println(driver+"cys");
			url=properties.getProperty("url");
			user=properties.getProperty("user");
			password=properties.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("========�����ļ�����========");
		}
		
		
	}
	private ConnectionFactory() {}
	private static final ConnectionFactory factory = new ConnectionFactory();
	public static ConnectionFactory getInstance() {
		return factory;
    }
	public static Connection getConnection(){
	try {
		Class.forName("com.mysql.jdbc.Driver");//��̬����
		System.out.println(driver+"cys");
		connection=DriverManager.getConnection(url,user,password);//实例化
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
		
	}

}
