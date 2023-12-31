package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	public static Connection getConnect() {
		Connection connect = null;

		/**
		 * @CloudDB
		 */
//		
//		String DB_URL;
//		String DB_USER;
//		String DB_PASSWORD;
//		
//		DB_URL = System.getenv("DB_URL");
//		DB_USER = System.getenv("DB_USER");
//		DB_PASSWORD = System.getenv("DB_PASSWORD");
		
		/**
		 * @LocalHost
		 */

		String DB_URL1;
		String DB_USER1 ;
		String DB_PASSWORD1 ;
		
		DB_URL1 = System.getenv("DB_URL1");
		DB_USER1 = System.getenv("DB_USER1");
		DB_PASSWORD1 = System.getenv("DB_PASSWORD1");
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(DB_URL1, DB_USER1, DB_PASSWORD1);
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new RuntimeException("Unable to connect to database", e);
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
			throw new RuntimeException("Database driver class not found", e);
		}
		return connect;
	}
}
