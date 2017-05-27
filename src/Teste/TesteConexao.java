package Teste;

import java.sql.Connection;
import java.sql.SQLException;

import Conexao.ConnectionFactory;

public class TesteConexao {
	public static void main(String[]args) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		con.close();
	}
}
