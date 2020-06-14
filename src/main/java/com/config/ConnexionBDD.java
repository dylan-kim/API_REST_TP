package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnexionBDD {

	private Connection connexion;
	private static final String BDD_SO_MANAGER_URL = "jdbc:mysql://localhost:3306/test";
	private static final String BDD_USER = "somanager";
	private static final String BDD_PASSWORD = "yhqyD4rJzto+K4";

	public static Connection getConnexion() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(BDD_SO_MANAGER_URL, BDD_USER, BDD_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnexion() throws SQLException {
		this.connexion.close();
	}

}
