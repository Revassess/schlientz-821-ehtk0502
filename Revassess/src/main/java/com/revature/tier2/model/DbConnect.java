package com.revature.tier2.model;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.CallableStatement;

public class DbConnect{
	DbConnect(){
		super();
	}
	
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			
			if(conn == null) {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Properties props = new Properties();
				FileInputStream input = new FileInputStream(DbConnect.class.getClassLoader().getResource("connection.properties").getFile());
				props.load(input);
				
				String url = props.getProperty("url");
				
				
				String username = props.getProperty("username");
				
				String password = props.getProperty("password");
				
				
				conn = DriverManager.getConnection(url, username, password);
				
				
				
				return conn;

				
			}
			else {
				return conn;
			}
			
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
				
		return null;
	}
	
	public static void main(String[] arg) {
		
		Connection m_conn = DbConnect.getConnection();
		
		try {
			
			String sql = "CREATE SEQUENCE m_sequence MINVALUE 6 START WITH 6 INCREMENT BY 3";
			
			
			PreparedStatement ps = m_conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				System.out.println("Successfully Added");
			}else {
				System.out.println("Failed to Add");
			}
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
} 