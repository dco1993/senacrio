package persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3307/barbearia";
	private final String USER = "root";
	private final String PASS = "";
	
	public Conexao() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	protected Connection getConnection() 
			throws Exception {
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		return conn;
	}
}
