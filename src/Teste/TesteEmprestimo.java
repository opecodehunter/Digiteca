package Teste;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import Conexao.AssociadoDAO;
import Conexao.EmprestimoDAO;
import Conexao.LivroDAO;
import Modelo.Associado;
import Modelo.Emprestimo;
import Modelo.Livro;

public class TesteEmprestimo {
	public static void main(String[]args) throws SQLException{


		//Pesquisa de livro com filtro;

		EmprestimoDAO dao= new EmprestimoDAO();

		List<Emprestimo> emprestimos = dao.getLista("1600364");

		if(emprestimos.size() > 0){
			for(Emprestimo emprestimo : emprestimos){
				System.out.println("id "+emprestimo.getId());
				System.out.println("Associado "+emprestimo.getAssociado().getNome());
				System.out.println("DataSaida "+emprestimo.getDataSaida());
				System.out.println("PREVISTA "+emprestimo.getDataPrevista());
	
			}
		}else{
			System.out.println("Emprestimo não encontrado");
		}
		
		
		
		//Cria uma instancia de um associado
		
		AssociadoDAO associadodao = new AssociadoDAO();
		List<Associado>associados = associadodao.getLista("ra", "1600364");
		
		String ra = associados.get(0).getRa();
		String email = associados.get(0).getEmail();
		String nome = associados.get(0).getNome();
		String telefone = associados.get(0).getTelefone();
		String tipo = associados.get(0).getTipo();
		
		Associado associado = new Associado();
		
		associado.setRa(ra);
		associado.setEmail(email);
		associado.setNome(nome);
		associado.setTelefone(telefone);
		associado.setTipo(tipo);
		
		//Cria uma instancia de um livro
		LivroDAO livrodao = new LivroDAO();
		
		List<Livro>livros = livrodao.getLista("id_livro","1");
		
		Livro livro = new Livro();
		
		livro.setAutor(livros.get(0).getAutor());
		livro.setEditora(livros.get(0).getEditora());
		livro.setTitulo(livros.get(0).getTitulo());
		livro.setISBN(livros.get(0).getISBN());
		livro.setTombo(livros.get(0).getTombo());
		
		//Configura a data do emprestimo

		long semanams = 604800000;
 		Calendar dataSaida = Calendar.getInstance();
 		Calendar dataPrevista = Calendar.getInstance();
 		
 		
 		Emprestimo emprestimo = new Emprestimo();
 		
 		emprestimo.setAssociado(associado);
 		emprestimo.setDataPrevista(dataPrevista);
 		emprestimo.setDataSaida(dataSaida);
 		emprestimo.setLivro(livro);
 		
 		/*System.out.println(emprestimo.getAssociado().getEmail());
 		System.out.println(emprestimo.getLivro().getTitulo());
 		System.out.println(emprestimo.getDataSaida());
 		System.out.println(emprestimo.getDataPrevista());*/
 		
 		EmprestimoDAO emprestimodao = new EmprestimoDAO();
 		
 		//emprestimodao.adiciona(emprestimo);
		
	}
}
