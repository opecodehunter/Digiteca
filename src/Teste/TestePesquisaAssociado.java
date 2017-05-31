package Teste;

import java.sql.SQLException;
import java.util.List;

import Conexao.AssociadoDAO;
import Modelo.Associado;

public class TestePesquisaAssociado {
	public static void main(String[]args) throws SQLException{


		//Pesquisa de livro com filtro;

		AssociadoDAO dao= new AssociadoDAO();
		String dado = "1600364";
		String filtro = "ra";

		List<Associado> associados = dao.getLista(filtro,dado);

		if(associados.size() > 0){
			for(Associado associado : associados){
				System.out.println("ra "+associado.getRa());
				System.out.println("email "+associado.getEmail());
				System.out.println("nome "+associado.getNome());
				System.out.println("telefone "+associado.getTelefone());
				System.out.println("tipo "+associado.getTipo());
			}
		}else{
			System.out.println("Associado não encontrado");
		}
		//Pesquisa de Livro 

	}
}
