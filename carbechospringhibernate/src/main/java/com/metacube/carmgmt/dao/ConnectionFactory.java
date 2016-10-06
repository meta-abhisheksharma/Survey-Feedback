package com.metacube.carmgmt.dao;

import com.metacube.carmgmt.exception.SystemException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component("connectionFactory")
public class ConnectionFactory {
	
	private static ConnectionFactory connectionFactory = new ConnectionFactory();
	
	public static ConnectionFactory getInstance() {
		return connectionFactory;
	}
	
	public Connection getConnection() throws SystemException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carbecho?characterEncoding=UTF-8", "root", "12345");
		} catch (ClassNotFoundException e) {
			throw new SystemException("Please add mysql jars in classpath");
		} catch (SQLException e) {
			throw new SystemException("Please check database configuration");
		}
		return connection;
	}

	public void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Could not close connection.");
			}
		}
	}
}