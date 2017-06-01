package UseCase;

import java.sql.SQLException;
import java.util.List;

import Conexao.AssociadoDAO;
import Conexao.LivroDAO;
import Conexao.ReservaDAO;
import Modelo.Associado;
import Modelo.Livro;
import Modelo.Reserva;

public class ReservarLivro {
	public static void novaReserva(String ra,String tombo) throws SQLException{
		AssociadoDAO associadodao = new AssociadoDAO();
		List<Associado>associados = associadodao.getLista("ra",ra);
		Associado associado = new Associado();

		associado.setRa(associados.get(0).getRa());
		associado.setEmail(associados.get(0).getEmail());
		associado.setNome(associados.get(0).getNome());
		associado.setTelefone(associados.get(0).getTelefone());
		associado.setTipo(associados.get(0).getTipo());

		//instancia de LIVRO
		LivroDAO livrodao = new LivroDAO();	
		List<Livro>livros = livrodao.getLista("id_livro",tombo);
		Livro livro = new Livro();

		livro.setAutor(livros.get(0).getAutor());
		livro.setEditora(livros.get(0).getEditora());
		livro.setTitulo(livros.get(0).getTitulo());
		livro.setISBN(livros.get(0).getISBN());
		livro.setTombo(livros.get(0).getTombo());

		Reserva reserva = new Reserva();

		reserva.setAssociado(associado);
		reserva.setLivro(livro);

		System.out.println(reserva.getAssociado().getRa());

		ReservaDAO reservadao = new ReservaDAO();
		reservadao.adiciona(reserva);
	}
}
