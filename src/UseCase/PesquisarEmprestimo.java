package UseCase;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Conexao.EmprestimoDAO;
import Modelo.Emprestimo;

public class PesquisarEmprestimo {


	public static void buscarEmprestimo(String ra) throws SQLException{
		EmprestimoDAO emprestimodao= new EmprestimoDAO();

		List<Emprestimo> emprestimos = emprestimodao.getLista(ra);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		
		if(emprestimos.size() > 0){
			for(Emprestimo emprestimo : emprestimos){
				Date dataSaidaformat = new Date (emprestimo.getDataSaida().getTimeInMillis()); 
				Date dataPrevistaformat = new Date(emprestimo.getDataPrevista().getTimeInMillis());
				
				System.out.println("ID: "+emprestimo.getId()+" | "
						+ "Associado: "+emprestimo.getAssociado().getNome()+" | "
						+ "Livro: "+emprestimo.getLivro().getTitulo()+" | "
						+ "DataSaida: "+sdf.format(dataSaidaformat)+" | "
						+ "DataPrevista: "+sdf.format(dataPrevistaformat)+" | ");

				
			}
		}else{
			System.out.println("Emprestimo não encontrado");
		}
	}
}

