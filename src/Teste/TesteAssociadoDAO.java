package Teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Conexao.AssociadoDAO;
import Conexao.ConnectionFactory;
import Modelo.Associado;

public class TesteAssociadoDAO {
	public static void main(String[]args) throws SQLException{
		Associado associado = new Associado();
		AssociadoDAO associadoDAO = new AssociadoDAO();
		
		associado.setRa("1600364");
		associado.setEmail("isakfreires@gmail.com");
		associado.setNome("isak silva");
		associado.setTelefone("11988188978");
		associado.setTipo("aluno");
		
		associadoDAO.adiciona(associado);

	}
}