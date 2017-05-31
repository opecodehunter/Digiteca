package Teste;

import java.sql.SQLException;
import java.util.List;

import Conexao.EmprestimoDAO;
import Modelo.Emprestimo;

public class TestePesquisaEmprestimo {
	public static void main(String[]args) throws SQLException{


		//Pesquisa de livro com filtro;

		EmprestimoDAO dao= new EmprestimoDAO();

		List<Emprestimo> emprestimos = dao.getLista();

		if(emprestimos.size() > 0){
			for(Emprestimo emprestimo : emprestimos){
				System.out.println("id "+emprestimo.getId());
				System.out.println("Associado "+emprestimo.getAssociado().getNome());
				//System.out.println("ISBN "+livro.getISBN());
				//System.out.println("editora "+livro.getEditora());
				//System.out.println("tombo "+livro.getTombo());
			}
		}else{
			System.out.println("Emprestimo não encontrado");
		}
		//Pesquisa de Livro 

	}
}
