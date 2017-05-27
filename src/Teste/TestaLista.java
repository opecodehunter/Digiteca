package Teste;

import java.util.List;

import Conexao.AssociadoDAO;
import Modelo.Associado;

public class TestaLista {
	public static void main(String[]args){
		AssociadoDAO dao= new AssociadoDAO();

		List<Associado> associados = dao.getLista();

		for(Associado associado : associados){
			System.out.println("RA "+associado.getRa());
			System.out.println("Email "+associado.getEmail());
			System.out.println("Nome "+associado.getNome());
			System.out.println("Telefone "+associado.getTelefone());
			System.out.println("Tipo "+associado.getTipo());
		}
	}
}
