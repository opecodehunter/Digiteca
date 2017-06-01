package UseCase;

import java.sql.SQLException;

import Conexao.LivroDAO;

public class UpdateLivro {
	public UpdateLivro(){}
	
	public static void AtualizarLivro(int n) throws SQLException{
		LivroDAO dao = new LivroDAO();
		dao.alteraStatus(n);
	}
}
