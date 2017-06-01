package UseCase;

import java.sql.SQLException;
import java.util.List;

import Conexao.LivroDAO;
import Modelo.Livro;

public class ConsultarLivro {

	public static void pesquisaLivro(){

	}

	public static void pesquisaLivro(String filtro,String dado) throws SQLException{

		LivroDAO dao= new LivroDAO();
		List<Livro> livros = dao.getLista(filtro,dado);

		if(livros.size() > 0){
			for(Livro livro : livros){
				System.out.println("ID: "+livro.getTombo()+" | "
						+ "Titulo: "+livro.getTitulo()+" | "
						+ "Autor: "+livro.getAutor()+" | "
						+ "Editora: "+livro.getEditora()+" | "
						+ "ISBN: "+livro.getISBN()+" | \n");
			}
		}else{
			System.out.println("Livro não encontrado");
		}
	}
}
