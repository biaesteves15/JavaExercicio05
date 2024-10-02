package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static String host = "jdbc:postgresql://localhost:5432/bd_contatos";
	private static String user = "postgres";
	private static String pass = "2234";
	
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(host, user, pass);
	}

}
