package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(){
		try{
			System.out.println("Conectado!");
			return DriverManager.getConnection("jdbc:mysql://localhost/digiteca","root","");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
