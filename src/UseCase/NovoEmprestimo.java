package UseCase;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import Conexao.AssociadoDAO;
import Conexao.EmprestimoDAO;
import Conexao.LivroDAO;
import Modelo.Associado;
import Modelo.Emprestimo;
import Modelo.Livro;

public class NovoEmprestimo {

	public static void novo(String ra,String tombo) throws SQLException{
		
		
		//Cria uma instancia de um associado
		
		AssociadoDAO associadodao = new AssociadoDAO();
		List<Associado>associados = associadodao.getLista("ra",ra);
		Associado associado = new Associado();

		associado.setRa(associados.get(0).getRa());
		associado.setEmail(associados.get(0).getEmail());
		associado.setNome(associados.get(0).getNome());
		associado.setTelefone(associados.get(0).getTelefone());
		associado.setTipo(associados.get(0).getTipo());

		
		//Cria uma instancia de um livro
		
		LivroDAO livrodao = new LivroDAO();	
		List<Livro>livros = livrodao.getLista("id_livro",tombo);
		Livro livro = new Livro();
		
		livro.setAutor(livros.get(0).getAutor());
		livro.setEditora(livros.get(0).getEditora());
		livro.setTitulo(livros.get(0).getTitulo());
		livro.setISBN(livros.get(0).getISBN());
		livro.setTombo(livros.get(0).getTombo());
		
		//Configura a data do emprestimo
		
		Calendar dataSaida = Calendar.getInstance();
		Calendar dataPrevista = Calendar.getInstance();
		dataPrevista.add(Calendar.DATE, +7);
 		
 		//Registra o emprestimo
 		
 		Emprestimo emprestimo = new Emprestimo();
 		
 		emprestimo.setAssociado(associado);
 		emprestimo.setDataPrevista(dataPrevista);
 		emprestimo.setDataSaida(dataSaida);
 		emprestimo.setLivro(livro);
 		
 		EmprestimoDAO emprestimodao = new EmprestimoDAO();
 		
 		emprestimodao.adiciona(emprestimo);
	}
}
