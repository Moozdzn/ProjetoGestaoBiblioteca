package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import database.singleton;

//group: usar isto para aceder à base de dados, desta forma não temos de a chamar várias vezes
/**
 * 
 * Classe que autentica a ligação á base de dados
 *
 */
public class singleton {
	private static final String DRIVER ="com.mysql.jdbc.Driver";
	private static final String CONNECTION ="jdbc:mysql://localhost:3306/bibliotech?autoReconnect=true&useSSL=false";
	private static final String USER ="root";
	private static final String PASSWORD ="ripsql";
	private static singleton connector = null;
	
	private singleton(){
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static singleton getConnector() {
		if (connector == null) 
			connector = new singleton();
		return connector;
	}
	
	public Connection getConnection() {
		try {
			
			return DriverManager.getConnection(CONNECTION,USER,PASSWORD);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}		
		return null;
	}

	
}
