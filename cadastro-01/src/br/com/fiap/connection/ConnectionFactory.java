package br.com.fiap.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection DBConnectionManager() throws ClassNotFoundException, SQLException {
		
		String dbURL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		String user	 = "xxxxxx";
		String pwd	 = "xxxxxx";
		
		//Utilizando o ClassForName para aplicações WEB
		Class.forName("oracle.jdbc.OracleDriver");
		
		return DriverManager.getConnection(dbURL,user,pwd);
	}

}
