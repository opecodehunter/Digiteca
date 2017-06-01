package UseCase;

import java.sql.SQLException;
import java.util.List;

import Conexao.MultaDAO;
import Modelo.Multa;

public class ConsultarMulta {
	public static void pesquisarMulta(String ra) throws SQLException{
		MultaDAO multadao = new MultaDAO();
		List<Multa> multas = multadao.getLista(ra);

		if(multas.size() > 0){
			for(Multa multa : multas){
				System.out.println("ID: "+multa.getId_multa()+" | "
						+ "Associado: "+multa.getAssociado().getNome()+" | "
						+ "Valor: "+multa.getValor()+" | ");	
			}
		}else{
			System.out.println("Multa não encontrada");
		}
	}
}
