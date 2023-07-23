package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	public static String DB_URL = "jdbc:mysql://localhost:3306/test";
	public static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static String DB_USER = "nilesh";
	public static String DB_PASSWORD = "nilesh";
	
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		return con;
	}
}
