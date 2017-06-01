package Menu;

import java.util.Scanner;
import java.sql.SQLException;
import UseCase.*;

public class Controle {

	private static Scanner ler;

	public static void main(String[]args) throws SQLException{

		ler = new Scanner(System.in);

		System.out.println("Menu:\n "
				+ "[1]Pesquisar Livro\n "
				+ "[2]Novo Emprestimo\n "
				+ "[3]Pesquisar Emprestimo\n "
				+ "[4]Fazer Reserva\n "
				+ "[5]Gerar Multa\n "
				+ "[6]Consultar Multa\n ");
		int opcao = ler.nextInt();
		if(opcao == 1){
			System.out.println("informe o filtro do livro");
			String filtro = ler.next();

			System.out.println("informe "+filtro+" do livro");
			String dado = ler.next();

			ConsultarLivro.pesquisaLivro(filtro, dado);
		}else if(opcao == 2){
			System.out.println("Ra do associado: ");
			String ra = ler.next();
			System.out.println("Tombo do livro: ");
			String tombo = ler.next();
			RegistrarEmprestimo.novo(ra,tombo);
		}else if(opcao == 3){
			System.out.println("Ra do associado: ");
			ConsultarEmprestimo.buscarEmprestimo(ler.next());
		}else if(opcao == 4){
			System.out.println("Ra do associado: ");
			String ra = ler.next();
			System.out.println("Tombo do livro: ");
			String tombo = ler.next();
			ReservarLivro.novaReserva(ra, tombo);
		}else if(opcao == 5){
			System.out.println("Ra do associado: ");
			String ra = ler.next();
			System.out.println("Valor da multa: ");
			double valor = ler.nextDouble();
			GerarMulta.novaMulta(ra,valor);
		}else if(opcao == 6){
			System.out.println("Ra do associado: ");
			ConsultarMulta.pesquisarMulta(ler.next());
		}
	}
}


