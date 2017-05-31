package Modelo;

import java.sql.Date;
import java.util.Calendar;

public class Emprestimo {
	int id;
	Calendar dataSaida;
	Calendar dataPrevista;
	Associado associado;
	Livro livro;

	
	public Emprestimo(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida2) {
		this.dataSaida = dataSaida2;
	}

	public Calendar getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(Calendar dataPrevista2) {
		this.dataPrevista = dataPrevista2;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado2) {
		this.associado = associado2;
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	
	
}
