package Teste;

import java.sql.SQLException;
import java.util.List;
import Conexao.ReservaDAO;
import Modelo.Reserva;



public class TesteReserva {
	public static void main(String[]args) throws SQLException{


		ReservaDAO dao = new ReservaDAO();

		List<Reserva> reservas = dao.getLista("1600364");

		if(reservas.size() > 0){
			for(Reserva reserva : reservas){
				System.out.println("Nome "+reserva.getAssociado().getNome());
				System.out.println("Titulo "+reserva.getLivro().getTitulo());
			}
		}else{
			System.out.println("Associado não encontrado");
		}

	}
}
