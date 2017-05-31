package Teste;

import java.sql.SQLException;
import java.util.List;

import Conexao.LivroDAO;
import Modelo.Livro;


public class TestePesquisaLivro {
	public static void main(String[]args) throws SQLException{


		//Pesquisa de livro com filtro;

		LivroDAO dao= new LivroDAO();
		String dado = "Doubleday";
		String filtro = "editora";

		List<Livro> livros = dao.getLista(filtro,dado);

		if(livros.size() > 0){
			for(Livro livro : livros){
				System.out.println("titulo "+livro.getTitulo());
				System.out.println("Autor "+livro.getAutor());
				System.out.println("ISBN "+livro.getISBN());
				System.out.println("editora "+livro.getEditora());
				System.out.println("tombo "+livro.getTombo());
			}
		}else{
			System.out.println("Livro não encontrado");
		}
		//Pesquisa de Livro 

	}
}
