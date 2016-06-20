package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionDB {
	public static Connection getConnection(){
		try {
			Connection connection;
			String url = "sun.jdbc.odbc.JdbcOdbcDriver";
			String dbUrl = "jdbc:odbc:GoCoffee";
			Class.forName(url);
			connection = DriverManager.getConnection(dbUrl,"sa","12345678");
			System.out.println("Get Connection Susscesfull");
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static PreparedStatement getPreparedStatement(Connection connection, String sql){
		try {
			PreparedStatement preparedStatement;
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			return preparedStatement;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConnection(Connection connection){
		try {
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public static void closeConnection(PreparedStatement preparedStatement){
		try {
			preparedStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static void closeConnection(ResultSet resultSet){
		try {
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				resultSet.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
}

