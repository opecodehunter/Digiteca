package Gerencia;

import java.util.Scanner;
import java.sql.SQLException;
import UseCase.*;

public class Gerencia {

	private static Scanner ler;

	public static void main(String[]args) throws SQLException{

		ler = new Scanner(System.in);

		System.out.println("Menu:\n "
				+ "[1]Pesquisar Livro\n "
				+ "[2]Novo Emprestimo\n "
				+ "[3]Pesquisar Emprestimo\n");
		int opcao = ler.nextInt();
		if(opcao == 1){
			System.out.println("informe o filtro do livro");
			String filtro = ler.next();

			System.out.println("informe "+filtro+" do livro");
			String dado = ler.next();

			PesquisarLivro.pesquisaLivro(filtro, dado);
		}else if(opcao == 2){
			System.out.println("Ra do associado: ");
			String ra = ler.next();
			System.out.println("Tombo do livro: ");
			String tombo = ler.next();
			NovoEmprestimo.novo(ra,tombo);
		}else if(opcao == 3){
			System.out.println("Ra do associado: ");
			PesquisarEmprestimo.buscarEmprestimo(ler.next());
		}
	}
}


